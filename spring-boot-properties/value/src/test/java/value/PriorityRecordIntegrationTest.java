package value;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)

@SpringBootTest(classes = PriorityRecord.class)
public class PriorityRecordIntegrationTest {
    
    @Autowired
    private PriorityRecord priorityRecord;
    
    @Test
    public void givenPropertyFile_WhenConstructorInjectionUsedInRecord_ThenValueInjected() {
        System.out.println(priorityRecord.priority());
    }
    
}
