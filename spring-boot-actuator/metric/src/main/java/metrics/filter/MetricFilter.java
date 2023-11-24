package metrics.filter;


import jakarta.annotation.Resource;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import metrics.service.CustomActuatorMetricService;
import metrics.service.InMemoryMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Component
public class MetricFilter implements Filter {

    @Resource
    private InMemoryMetricService metricService;

    @Resource
    private CustomActuatorMetricService actMetricService;

    @Override
    public void init(final FilterConfig config) {
        if (metricService == null || actMetricService == null) {
            WebApplicationContext appContext = WebApplicationContextUtils
              .getRequiredWebApplicationContext(config.getServletContext());

            metricService = appContext.getBean(InMemoryMetricService.class);
            actMetricService = appContext.getBean(CustomActuatorMetricService.class);
        }
    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws java.io.IOException, ServletException {
        final HttpServletRequest httpRequest = ((HttpServletRequest) request);
        final String req = httpRequest.getMethod() + " " + httpRequest.getRequestURI();

        chain.doFilter(request, response);

        final int status = ((HttpServletResponse) response).getStatus();
        metricService.increaseCount(req, status);
        actMetricService.increaseCount(status);
    }

}
