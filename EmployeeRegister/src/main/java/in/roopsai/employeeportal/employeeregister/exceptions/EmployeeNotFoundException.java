package in.roopsai.employeeportal.employeeregister.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String id) {
        super("Employee with id " + id + " not found");
    }
}
