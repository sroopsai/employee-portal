package in.roopsai.employeeportal.employeeregister.controller;

import in.roopsai.employeeportal.employeeregister.domain.Employee;
import in.roopsai.employeeportal.employeeregister.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee save(@Valid @RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @GetMapping
    public Iterable<Employee> get() {
        return employeeService.get();
    }

    @GetMapping("{id}")
    public Employee get(@PathVariable String id) {
        return employeeService.get(id);
    }

    @PutMapping("{id}")
    public Employee update(@PathVariable String id, @RequestBody Employee employee) {
        return employeeService.update(id, employee);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }

}
