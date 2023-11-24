package ctx1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import parent.IHomeService;

@RestController
public class Ctx1Controller {

    @Autowired
    private IHomeService homeService;

    @GetMapping("/home")
    public String greeting() {
        return homeService.getGreeting();
    }
}
