package multiplecachemanager.bo;

import multiplecachemanager.entity.Customer;
import multiplecachemanager.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class CustomerDetailBO {
    
    private static final Logger LOG = LoggerFactory.getLogger(CustomerDetailBO.class);
    
    @Cacheable(cacheNames = "customers")
    public Customer getCustomerDetail(Integer customerId) {
        
        return Customer.getCustomer().stream().filter(k -> k.getCustomerId() == customerId).findFirst().orElse(new Customer());
    }
    
    @Cacheable(cacheNames = "customerOrders", cacheManager = "alternateCacheManager")
    public List<Order> getCustomerOrders(Integer customerId) {
        
        return Order.getOrder().stream().filter(k -> k.getCustomerId() == customerId).collect(Collectors.toList());
    }
}
