package in.roopsai.employeeportal.employeeregister;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "employee")
public class EmployeeProperties {
    /**
     * A message to welcome users
     */
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

}
