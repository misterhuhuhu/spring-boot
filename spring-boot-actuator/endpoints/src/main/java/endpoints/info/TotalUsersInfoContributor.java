package endpoints.info;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class TotalUsersInfoContributor implements InfoContributor {

   

    @Override
    public void contribute(Info.Builder builder) {
        Map<String, Integer> userDetails = new HashMap<>();
        userDetails.put("active", 1);
        userDetails.put("inactive", 0);

        builder.withDetail("users", userDetails);
    }
}
