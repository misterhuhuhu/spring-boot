package environmentpostprocessor;

import environmentpostprocessor.service.PriceCalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class PriceCalculationApplication implements CommandLineRunner {

    @Autowired
    PriceCalculationService priceCalculationService;

    private static final Logger logger = LoggerFactory.getLogger(PriceCalculationApplication.class);

    public static void main(String[] args) {
        /**
         * environmentpostprocessor.calculation.mode=GROSS
         * environmentpostprocessor.gross.calculation.tax.rate=0.15
         */
        System.setProperty("calculation_mode","GROSS");
        System.setProperty("gross_calculation_tax_rate","0.15");
        ConfigurableApplicationContext run = SpringApplication.run(PriceCalculationApplication.class, args);
        PriceCalculationEnvironmentPostProcessor bean = run.getBean(PriceCalculationEnvironmentPostProcessor.class);
        System.out.println(bean);
    }

    @Override
    public void run(String... args) throws Exception {

        List<String> params = Arrays.stream(args)
            .collect(Collectors.toList());
        if (verifyArguments(params)) {
            double singlePrice = Double.valueOf(params.get(0));
            int quantity = Integer.valueOf(params.get(1));
            priceCalculationService.productTotalPrice(singlePrice, quantity);
        } else {
            logger.warn("Invalid arguments " + params.toString());
        }

    }

    private boolean verifyArguments(List<String> args) {
        boolean successful = true;
        if (args.size() != 2) {
            successful = false;
            return successful;
        }
        try {
            double singlePrice = Double.valueOf(args.get(0));
            int quantity = Integer.valueOf(args.get(1));
        } catch (NumberFormatException e) {
            successful = false;
        }
        return successful;

    }

}
