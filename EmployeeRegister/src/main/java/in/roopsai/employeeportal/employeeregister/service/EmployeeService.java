package in.roopsai.employeeportal.employeeregister.service;

import in.roopsai.employeeportal.employeeregister.domain.Employee;
import in.roopsai.employeeportal.employeeregister.domain.EmployeeRepository;
import in.roopsai.employeeportal.employeeregister.exceptions.EmployeeAlreadyExistsException;
import in.roopsai.employeeportal.employeeregister.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> get() {
        return employeeRepository.get();
    }

    public Employee get(String id) {
        return employeeRepository.get(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    public Employee save(Employee employee) {
        if (employeeRepository.has(employee.id())) {
            throw new EmployeeAlreadyExistsException(employee.id());
        }
        return employeeRepository.save(employee);
    }

    public Employee update(String id, Employee employee) {
        delete(id);
        return save(employee);

    }

    public void delete(String id) {
        employeeRepository.delete(id);
    }
}
