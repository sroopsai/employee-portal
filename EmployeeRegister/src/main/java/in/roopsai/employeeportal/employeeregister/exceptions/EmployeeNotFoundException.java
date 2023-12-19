package in.roopsai.employeeportal.employeeregister.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String name) {
        super("Employee with name " + name + " not found");
    }
}
