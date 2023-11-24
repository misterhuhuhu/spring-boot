package jasypt;


import jakarta.annotation.Resource;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {Main.class})
public class CustomJasyptIntegrationTest {
    
    @Resource
    StringEncryptor encryptorBean;
    @Autowired
    ApplicationContext appCtx;
    
    @Test
    public void whenConfiguredExcryptorUsed_ReturnCustomEncryptor() {
        Environment environment = appCtx.getBean(Environment.class);
        assertEquals("Password@3", environment.getProperty("encryptedv3.property"));
    }
    
    @Test
    void encrypt() {
        
        String privateData = "Password@3";
        String myEncryptedText = encryptorBean.encrypt(privateData);
        System.out.println(myEncryptedText);
        
    }
}
