package value.defaults;

import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Demonstrates setting defaults for @Value annotation.  Note that there are no properties 
 * defined in the specified property source.  We also assume that the user here
 * does not have a system property named some.key.
 *
 */
@Configuration
@PropertySource(name = "myProperties", value = "classpath:valueswithdefaults.properties")
public class ValuesWithDefaultsApp {

    @Value("${some.key:my default value}")
    private String stringWithDefaultValue;

    @Value("${some.key:}")
    private String stringWithBlankDefaultValue;

    @Value("${some.key:true}")
    private boolean booleanWithDefaultValue;
    
    @Value("${some.key:42}")
    private int intWithDefaultValue;  

    @Value("${some.key:one,two,three}")
    private String[] stringArrayWithDefaults;

    @Value("${some.key:1,2,3}")
    private int[] intArrayWithDefaults;

    @Value("#{systemProperties['some.key'] ?: 'my default system property value'}")
    private String spelWithDefaultValue;
    @Value("#{systemProperties}")
    private Map systemProperties;
    

    public static void main(String[] args) {
        
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ValuesWithDefaultsApp.class);
        ValuesWithDefaultsApp bean = applicationContext.getBean(ValuesWithDefaultsApp.class);
        System.out.println(bean);
    }

    @PostConstruct
    public void afterInitialize() {
    	// strings
    	Assert.isTrue(stringWithDefaultValue.equals("my default value"), "unexpected value for stringWithDefaultValue");
    	Assert.isTrue(stringWithBlankDefaultValue.equals(""), "unexpected value for stringWithBlankDefaultValue");
    	
    	// other primitives
    	Assert.isTrue(booleanWithDefaultValue, "unexpected value for booleanWithDefaultValue");
    	Assert.isTrue(intWithDefaultValue == 42, "unexpected value for intWithDefaultValue");
    	
    	// arrays
        List<String> stringListValues = Arrays.asList("one", "two", "three");
        Assert.isTrue(new HashSet<>(Arrays.asList(stringArrayWithDefaults)).containsAll(stringListValues), "unexpected value for stringArrayWithDefaults");

        List<Integer> intListValues = Arrays.asList(1, 2, 3);
        Assert.isTrue(new HashSet<>(Arrays.asList(ArrayUtils.toObject(intArrayWithDefaults))).containsAll(intListValues), "unexpected value for intArrayWithDefaults");

    	// SpEL
    	Assert.isTrue(spelWithDefaultValue.equals("my default system property value"), "unexpected value for spelWithDefaultValue");
    }
}
