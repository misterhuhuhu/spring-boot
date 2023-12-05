package multiplecachemanager.bo;


import multiplecachemanager.SpringBootMvcFnApplication;
import multiplecachemanager.entity.Item;
import multiplecachemanager.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;


@Component
public class OrderDetailBO {
    
    private static final Logger LOG = LoggerFactory.getLogger(OrderDetailBO.class);
    
    @Cacheable(cacheNames = "orders", cacheResolver = "cacheResolver")
    public Order getOrderDetail(Integer orderId) {
        LOG.info("getOrderDetail");
        return Order.getOrder().stream().filter(k -> orderId.equals(k.getOrderId())).findFirst().orElse(new Order());
    }
    
    @Cacheable(cacheNames = "orderprice", cacheResolver = "cacheResolver")
    public double getOrderPrice(Integer orderId) {
        Order order = Order.getOrder().stream().filter(k -> orderId.equals(k.getOrderId())).findFirst().orElse(new Order());
        Item item = Item.getItem().stream().filter(k -> order.getItemId() == (k.getItemId())).findFirst().orElse(new Item());
        LOG.info("getOrderPrice");
        return order.getQuantity() * item.getItemPrice();
    }
}
