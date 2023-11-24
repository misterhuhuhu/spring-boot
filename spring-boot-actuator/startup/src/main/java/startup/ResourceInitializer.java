package startup;

import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Component
public class ResourceInitializer {

    ResourceInitializer() throws Exception {
        // simulate resource init with random delay of a few seconds
        int randomDelay = ThreadLocalRandom.current().nextInt(1, 3);
        TimeUnit.SECONDS.sleep(randomDelay);
    }

}
