package environmentpostprocessor;


import environmentpostprocessor.service.PriceCalculationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PriceCalculationApplication.class)
public class PriceCalculationEnvironmentPostProcessorLiveTest {

    @Autowired
    PriceCalculationService pcService;

    @Test
    public void whenSetNetEnvironmentVariablebyDefault_thenNoTaxApplied() {
        double total = pcService.productTotalPrice(100, 4);
        assertEquals(400.0, total, 0);
    }

}
