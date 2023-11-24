package bootcustomfilters.listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingListener implements ServletContextListener {
    private final static Logger LOG = LoggerFactory.getLogger(LoggingListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
        ServletContext servletContext = sce.getServletContext();
        LOG.info(this.getClass().toString());
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
        LOG.info(this.getClass().toString());
    }
}
