package redis;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class ItemController {
    
    private final ItemService itemService;
    
    @GetMapping("/item/{id}")
    public Item getItemById(@PathVariable String id) {
        Item itemForId = itemService.getItemForId(id);
        return itemForId;
    }
    
    @GetMapping("/getAllItem")
    public List<Item> getItemById() {
        return itemService.getAllItem();
    }
    
    @GetMapping("/evict")
    public Map<String, Item> evict() {
        ItemService itemService1 = new ItemService();
        
        return itemService.evict(itemService1);
    }
    
    
}