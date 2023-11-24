package probes;

import org.springframework.boot.availability.AvailabilityChangeEvent;
import org.springframework.boot.availability.LivenessState;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LivenessEventListener {

    @EventListener
    public void onEvent(AvailabilityChangeEvent<LivenessState> event) {
        switch (event.getState()) {
            case BROKEN -> System.out.printf("断开：%s:", this.getClass());
            case CORRECT -> System.out.printf("链接：%s:", this.getClass());
            
        }
    }
}
