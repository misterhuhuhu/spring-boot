package filter.regex;


import componentscan.filter.regex.ComponentScanRegexFilterApp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest(classes = ComponentScanRegexFilterApp.class)
public class ComponentScanRegexFilterAppIntegrationTest {

    @Test
    public void whenRegexFilterIsUsed_thenComponentScanShouldRegisterBeanMatchingRegex() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanRegexFilterApp.class);
        List<String> beans = Arrays.stream(applicationContext.getBeanDefinitionNames())
            .filter(bean -> !bean.contains("org.springframework") && !bean.contains("componentScanRegexFilterApp"))
            .collect(Collectors.toList());
        assertThat(beans.size(), equalTo(1));
        assertThat(beans.contains("elephant"), equalTo(true));
    }
}
