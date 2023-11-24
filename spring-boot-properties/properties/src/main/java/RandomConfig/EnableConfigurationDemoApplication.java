package RandomConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.env.RandomValuePropertySource;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EnableConfigurationDemoApplication {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(EnableConfigurationDemoApplication.class);
        
        ConfigurableApplicationContext run = SpringApplication.run(EnableConfigurationDemoApplication.class, args);
        RandomValuePropertySource random = new RandomValuePropertySource("myRandom");
        // 随机生成一个整数
        logger.info("random int:{}", random.getProperty("random.int"));
        
        // 随机生成一个整数，指定上边界，不大于等于1
        logger.info("random int(1):{}", random.getProperty("random.int(1)"));
        // 随机生成一个整数，指定上边界，不大于等于5
        logger.info("random int(5):{}", random.getProperty("random.int(5)"));
        
        // 随机生成一个整数，使用区间[0,1),前闭后开=>只能是1
        // 注意区间的表示法：使用()包围,2个字符
        logger.info("random int(0,1):{}", random.getProperty("random.int(0,1)"));
        // 随机生成一个整数，使用区间[1,3),前闭后开=>只能是1或者2
        // 注意区间的表示法：使用空格包围,2个字符，前后各一个空格
        logger.info("random int(1,3):{}", random.getProperty("random.int 1,3 "));
        // 随机生成一个整数，使用区间[3,4),前闭后开=>只能是3
        // 注意区间的表示法：使用汉字包围,2个字符，前后各一个汉字自负
        logger.info("random int(3,4):{}", random.getProperty("random.int底3,4顶"));
        // 随机生成一个整数，使用区间[5,6),前闭后开=>只能是5
        // 注意区间的表示法：使用英文字母包围,2个字符，前后各一个英文字母
        logger.info("random int(5,6):{}", random.getProperty("random.intL5,6U"));
        // 随机生成一个整数，使用区间[5,6),前闭后开=>只能是5
        // 注意区间的表示法：使用数字包围,2个字符，前一个数字5，后一个数字6
        logger.info("random int(5,6):{}", random.getProperty("random.int55,66"));
        
        // 随机生成一个长整数
        logger.info("random long:{}", random.getProperty("random.long"));
        // 随机生成一个整数，使用区间[100,101),前闭后开=>只能是100
        logger.info("random long(100,101):{}", random.getProperty("random.long(100,101)"));
        
        // 随机生成一个 uuid
        logger.info("random uuid:{}", random.getProperty("random.uuid"));
        
    }
    
}