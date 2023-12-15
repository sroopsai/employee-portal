package in.roopsai.employeeportal.employeeregister.persistence;

import in.roopsai.employeeportal.employeeregister.domain.Employee;
import in.roopsai.employeeportal.employeeregister.domain.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryEmployeeRepository implements EmployeeRepository {

    private static final Map<String, Employee> employees = new ConcurrentHashMap<>();

    @Override
    public Iterable<Employee> get() {

        return employees.values();
    }

    /**
     * @param id
     * @return
     */
    @Override
    public Optional<Employee> get(String id) {
        return has(id) ? Optional.of(employees.get(id)) : Optional.empty();
    }

    /**
     * @param employee
     * @return
     */
    @Override
    public Employee save(Employee employee) {
        return employees.put(employee.id(), employee);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public boolean has(String id) {
        return employees.get(id) != null;
    }

    /**
     * @param id
     */
    @Override
    public void delete(String id) {
        employees.remove(id);
    }


}
