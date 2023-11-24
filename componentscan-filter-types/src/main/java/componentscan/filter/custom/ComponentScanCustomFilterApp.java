package componentscan.filter.custom;

import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(includeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = ComponentScanCustomFilter.class))
public class ComponentScanCustomFilterApp {
    
    public static void main(String[] args) {
    
    }
}
