package in.roopsai.employeeportal.employeeregister;

import in.roopsai.employeeportal.employeeregister.domain.Employee;
import in.roopsai.employeeportal.employeeregister.domain.EmployeeRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("testdata")
public class EmployeeDataLoader {

    private final EmployeeRepository employeeRepository;

    public EmployeeDataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadEmployeeTestData() {
        var employee1 = new Employee("1", "sai", "Software Engineer");
        var employee2 = new Employee("2", "sai", "Senior Software Engineer");
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
    }
}
