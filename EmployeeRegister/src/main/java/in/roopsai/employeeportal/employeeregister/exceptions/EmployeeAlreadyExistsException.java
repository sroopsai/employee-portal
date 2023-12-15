package in.roopsai.employeeportal.employeeregister.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException{
    public EmployeeAlreadyExistsException(String id) {
        super("Employee with id " + id + " already exists");
    }
}
