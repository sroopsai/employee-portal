package in.roopsai.employeeportal.employeeregister.controller;

import in.roopsai.employeeportal.employeeregister.EmployeeProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greeting {
    private final EmployeeProperties employeeProperties;

    public Greeting(EmployeeProperties employeeProperties) {
        this.employeeProperties = employeeProperties;
    }

    @GetMapping("/")
    public String getGreeting() {
        return employeeProperties.getGreeting();
    }
}
