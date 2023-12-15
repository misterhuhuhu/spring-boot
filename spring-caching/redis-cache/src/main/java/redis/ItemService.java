package redis;

import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Cacheable(cacheNames = "ItemService", key = " #root.target.class.name +':' + #root.methodName +':'+ T(java.util.Arrays).toString(#root.args)")
public class ItemService {
    
    private static final Map<String, Item> items = new HashMap<>() {{
        put("0", new Item(0, "商品0"));
        put("1", new Item(1, "商品1"));
        put("2", new Item(2, "商品2"));
        put("3", new Item(3, "商品3"));
        put("4", new Item(4, "商品4"));
    }};
    
    
    public Item getItemForId(String id) {
        Item item = items.get(id);
//        int i = 1/0;
        return item;
    }
    
    public List<Item> getAllItem() {
        
        return new ArrayList<>(items.values());
    }
    
//    @CacheEvict(key = " #root.target.class.name + ':getAllItem:'+T(java.util.Arrays).toString(#root.args)",cacheNames = )
    public Map<String, Item> evict(ItemService itemService) {
        return items;
    }
}