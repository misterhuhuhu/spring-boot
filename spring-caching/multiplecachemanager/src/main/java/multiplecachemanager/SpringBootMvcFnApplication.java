package multiplecachemanager;

import multiplecachemanager.bo.CustomerDetailBO;
import multiplecachemanager.bo.OrderDetailBO;
import multiplecachemanager.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
@EnableCaching

public class SpringBootMvcFnApplication {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootMvcFnApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(SpringBootMvcFnApplication.class, args);
        CustomerDetailBO customerDetailBO = run.getBean(CustomerDetailBO.class);
        OrderDetailBO orderDetailBO = run.getBean(OrderDetailBO.class);
        double orderPrice = orderDetailBO.getOrderPrice(30001);
        double orderPrice2 = orderDetailBO.getOrderPrice(30001);
        LOG.info(String.valueOf(orderPrice));
        LOG.info(String.valueOf(orderPrice2));
        Order orderDetail = orderDetailBO.getOrderDetail(30001);
        Order orderDetail1 = orderDetailBO.getOrderDetail(30001);
        LOG.info(String.valueOf(orderDetail));
        LOG.info(String.valueOf(orderDetail1));
    }

   
}
