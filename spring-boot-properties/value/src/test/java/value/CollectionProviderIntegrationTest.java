package value;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = CollectionProvider.class)
public class CollectionProviderIntegrationTest {

    @Autowired
    private CollectionProvider collectionProvider;

    @Test
    public void givenPropertyFileWhenSetterInjectionUsedThenValueInjected() {
        System.out.println(collectionProvider.getValues());
    }
}