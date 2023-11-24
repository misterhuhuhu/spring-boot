package propertyeditor;


import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import propertyeditor.creditcard.CreditCard;
import propertyeditor.exotictype.editor.CustomExoticTypeEditor;
import propertyeditor.exotictype.model.ExoticType;

@RestController
@RequestMapping(value = "/property-editor")
public class PropertyEditorRestController {
    
    @GetMapping(value = "/credit-card/{card-no}")
    public CreditCard parseCreditCardNumber(@PathVariable("card-no") CreditCard creditCard) {
        return creditCard;
    }
    
    @GetMapping(value = "/exotic-type/{value}")
    public ExoticType parseExoticType(@PathVariable("value") ExoticType exoticType) {
        return exoticType;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(ExoticType.class, new CustomExoticTypeEditor());
    }
    
}
