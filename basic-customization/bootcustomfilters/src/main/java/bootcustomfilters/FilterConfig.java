package bootcustomfilters;

import bootcustomfilters.filters.RequestResponseLoggingFilter;
import bootcustomfilters.listener.LoggingListener;
import jakarta.servlet.ServletContextListener;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EventListener;

@Configuration
public class FilterConfig {
    
    @Bean
    public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter() {
        FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean = new FilterRegistrationBean<>();
        
        // 等于  //@Component @Order(2)
        registrationBean.setFilter(new RequestResponseLoggingFilter());
        registrationBean.setOrder(2);
        
        registrationBean.addUrlPatterns("/users/*");
        return registrationBean;

    }
    @Bean
    public ServletListenerRegistrationBean<ServletContextListener> registerListener(){
        ServletListenerRegistrationBean<ServletContextListener> eventListenerServletListenerRegistrationBean
                = new ServletListenerRegistrationBean<>();
        eventListenerServletListenerRegistrationBean.setListener(new LoggingListener());
        
        return eventListenerServletListenerRegistrationBean;
    }

}
