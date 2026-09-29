package lk.ijse.pulsefit.classservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * PulseFit - Class Service.
 * Owns the fitness class catalog (Cloud SQL / MySQL): class name,
 * category, trainer, schedule, capacity and location. Registers with
 * Eureka as CLASS-SERVICE and is called directly by booking-service to
 * validate a class exists (and to snapshot its schedule) before a
 * booking is created.
 */
@SpringBootApplication
public class ClassServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClassServiceApplication.class, args);
    }
}
