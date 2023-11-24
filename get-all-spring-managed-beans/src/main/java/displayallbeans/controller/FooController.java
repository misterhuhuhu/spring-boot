package displayallbeans.controller;

import displayallbeans.service.FooService;
import jakarta.annotation.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class FooController {
    @Resource
    private FooService fooService;
    
    @GetMapping(value = "/displayallbeans")
    public ResponseEntity<String> getHeaderAndBody(Map<String, Object> model) {
        model.put("header", fooService.getHeader());
        model.put("message", fooService.getBody());
        return ResponseEntity.ok("displayallbeans");
    }
}
