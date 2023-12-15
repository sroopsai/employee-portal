package in.roopsai.employeeportal.employeeregister.domain;

import java.util.Optional;

public interface EmployeeRepository {

    Iterable<Employee> get();

    Optional<Employee> get(String id);

    Employee save(Employee employee);

    boolean has(String id);

    void delete(String id);

}
