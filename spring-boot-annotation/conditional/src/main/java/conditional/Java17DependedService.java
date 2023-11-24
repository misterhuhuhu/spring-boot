package conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;

@Service
@Conditional(Java17Condition.class)
public class Java17DependedService {
}
