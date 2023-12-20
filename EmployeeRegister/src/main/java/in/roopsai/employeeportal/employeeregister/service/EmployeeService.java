package in.roopsai.employeeportal.employeeregister.service;

import in.roopsai.employeeportal.employeeregister.persistence.Employee;
import in.roopsai.employeeportal.employeeregister.persistence.EmployeeRepository;
import in.roopsai.employeeportal.employeeregister.exceptions.EmployeeAlreadyExistsException;
import in.roopsai.employeeportal.employeeregister.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(String name) {
        return employeeRepository.findEmployeeByNameIs(name).orElseThrow(() -> new EmployeeNotFoundException(name));
    }

    public Employee save(Employee employee) {
        if (employeeRepository.existsByName(employee.name())) {
            throw new EmployeeAlreadyExistsException(employee.name());
        }
        return employeeRepository.save(employee);

    }

    public Employee update(String id, Employee employee) {
        delete(id);
        return save(employee);

    }

    public void delete(String name) {
       // employeeRepository.deleteByName(name);
    }
}
