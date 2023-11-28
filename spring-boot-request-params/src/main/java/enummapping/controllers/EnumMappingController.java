package enummapping.controllers;


import enummapping.enums.Level;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.beans.PropertyEditorSupport;

@RestController
@RequestMapping("enummapping")
public class EnumMappingController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Level.class, new LevelEditor());
    }
    
    @GetMapping("/get")
    public String getByLevel(@RequestParam(required = false) Level level) {
        if (level != null) {
            return level.name();
        }
        return "undefined";
    }
    
    public static class LevelEditor extends PropertyEditorSupport {
        
        @Override
        public void setAsText(String text) {
            if (StringUtils.isBlank(text)) {
                setValue(null);
            } else {
                setValue(EnumUtils.getEnum(Level.class, text.toUpperCase()));
            }
        }
    }
}
