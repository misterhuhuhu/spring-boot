package enummapping.config;

import enummapping.enums.Level;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.boot.convert.ApplicationConversionService;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class EnumMappingConfig implements WebMvcConfigurer {
    @Override
    public void addFormatters(FormatterRegistry registry) {
        ApplicationConversionService.configure(registry);
        registry.addConverter(new StringToLevelConverter());
    }

    public static class StringToLevelConverter implements Converter<String, Level> {

        @Override
        public Level convert(String source) {
            if (org.apache.commons.lang3.StringUtils.isBlank(source)) {
                return null;
            }
            return EnumUtils.getEnum(Level.class, source.toUpperCase());
        }

    }
}