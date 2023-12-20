package in.roopsai.employeeportal.employeeregister;

import in.roopsai.employeeportal.employeeregister.persistence.Employee;
import in.roopsai.employeeportal.employeeregister.persistence.EmployeeRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
public class EmployeeDataLoader {

    private final EmployeeRepository employeeRepository;

    public EmployeeDataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadEmployeeTestData() {
        var employee1 = Employee.of( "sai", "Software Engineer");
        var employee2 = Employee.of( "sai", "Senior Software Engineer");
        employeeRepository.saveAll(List.of(employee1, employee2));
    }
}
