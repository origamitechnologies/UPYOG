package org.travansoft.barrel;

import org.egov.tracer.config.TracerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({TracerConfiguration.class})
@SpringBootApplication
public class RestaurantApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(RestaurantApplication.class, args);
    }
}