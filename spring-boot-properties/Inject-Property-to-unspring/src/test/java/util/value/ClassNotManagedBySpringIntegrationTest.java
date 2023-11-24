package util.value;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import util.ClassNotManagedBySpring;
import util.InitializerBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ClassNotManagedBySpringIntegrationTest {

    @MockBean
    private InitializerBean initializerBean;

    @BeforeAll
    public void init() {
        when(initializerBean.initClass())
          .thenReturn(new ClassNotManagedBySpring("This is only sample value", "Another configured value"));
    }

    @Test
    public void givenInitializerBean_whenInvokedInitClass_shouldInitialize() throws Exception {

        //given
        ClassNotManagedBySpring classNotManagedBySpring = initializerBean.initClass();

        //when
        String initializedValue = classNotManagedBySpring.getCustomVariable();
        String anotherCustomVariable = classNotManagedBySpring.getAnotherCustomVariable();

        //then
        assertEquals("This is only sample value", initializedValue);
        assertEquals("Another configured value", anotherCustomVariable);

    }

}