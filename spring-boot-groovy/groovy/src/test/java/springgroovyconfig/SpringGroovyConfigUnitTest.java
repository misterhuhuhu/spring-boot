package springgroovyconfig;

import groovy.lang.Binding;
import groovy.lang.GroovyObject;
import groovy.util.GroovyScriptEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.context.support.GenericGroovyApplicationContext;
import org.springframework.util.ResourceUtils;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;


class SpringGroovyConfigUnitTest {
    

    
    @Test
    void givenGroovyConfigFile_whenCalledWithBeanName_thenReturnCompanyBean() {
        try (GenericGroovyApplicationContext ctx = new GenericGroovyApplicationContext()) {
            //类似 基于 XML 的配置
            //绝对路径
            ctx.load("file:" + "D:\\github project\\spring-boot\\spring-boot-groovy\\groovy\\src\\main\\java\\springgroovyconfig\\GroovyBeanBuilder.groovy");
            ctx.refresh();
            
            //转换类型时，绝对类型必须一致
            Company company = (Company) ctx.getBean("companyBean");
            
            assertEquals("ABC Inc", company.getName());
        } catch (BeansException | IllegalStateException e) {
            fail(e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    @Test
    //使用 GroovyScriptEngine 类来执行 Groovy 脚本
    void givenGroovyScript_whenCalledWithScriptEngine_thenReturnsResult() {
        try {
            GroovyScriptEngine engine = new GroovyScriptEngine(ResourceUtils.getFile("file:src/main/resources/")
                                                                       .getAbsolutePath(), this.getClass().getClassLoader());
            Class<GroovyObject> joinerClass = engine.loadScriptByName("StringJoiner.groovy");
            GroovyObject joiner = joinerClass.getDeclaredConstructor()
                                          .newInstance();
            Object result = joiner.invokeMethod("join", new Object[] { "Mr.", "Bob" });
            
            assertEquals("Mr.Bob", result.toString());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    @Test
    //直接调用 Groovy 脚本
    void givenGroovyScript_whenCalledWithBindingObject_thenReturnsResult() {
        try {
            GroovyScriptEngine engine = new GroovyScriptEngine(ResourceUtils.getFile("file:src/main/resources/")
                                                                       .getAbsolutePath(), this.getClass().getClassLoader());
            Binding binding = new Binding();
            binding.setVariable("arg1", "Mr.");
            binding.setVariable("arg2", "Bob");
            Object result = engine.run("StringJoinerScript.groovy", binding);
            
            assertEquals("Mr.Bob", result.toString());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
    
}
