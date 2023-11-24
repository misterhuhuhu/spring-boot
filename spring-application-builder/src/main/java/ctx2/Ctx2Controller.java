package ctx2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import parent.IHomeService;

@RestController
public class Ctx2Controller {

    @Autowired
    private IHomeService homeService;

    @GetMapping("/greeting")
    public String getGreeting() {
        return homeService.getGreeting();
    }
}
