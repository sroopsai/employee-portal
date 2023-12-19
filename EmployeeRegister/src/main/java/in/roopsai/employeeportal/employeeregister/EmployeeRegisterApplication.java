package in.roopsai.employeeportal.employeeregister;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(EmployeeProperties.class)
public class EmployeeRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeRegisterApplication.class, args);
    }

}
