package conditional;

import org.springframework.boot.autoconfigure.condition.AnyNestedCondition;
import org.springframework.context.annotation.Conditional;

public class Java17OrJava20 extends AnyNestedCondition  {
    Java17OrJava20() {
        super(ConfigurationPhase.REGISTER_BEAN);
    }

    @Conditional(Java17Condition.class)
    static class Java8 { }

    @Conditional(Java20Condition.class)
    static class Java9 { }
}
