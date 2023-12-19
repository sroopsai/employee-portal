package in.roopsai.employeeportal.employeeregister.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException{
    public EmployeeAlreadyExistsException(String name) {
        super("Employee with name " + name + " already exists");
    }
}
