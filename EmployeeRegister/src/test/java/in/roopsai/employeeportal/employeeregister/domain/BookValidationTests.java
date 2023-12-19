package in.roopsai.employeeportal.employeeregister.domain;

import in.roopsai.employeeportal.employeeregister.persistence.Employee;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BookValidationTests {
    private static Validator validator;

    @BeforeAll
    static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Test
    void whenAllFieldsAreValid() {
        var employee = Employee.of( "sai", "software engineer");
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        assertThat(violations).isEmpty();
    }

    @Test
    void whenSomeFieldsAreValid() {
        var employee = Employee.of( "sai", "");
        Set<ConstraintViolation<Employee>> violations = validator.validate(employee);
        assertThat(violations).hasSize(1);
        assertThat(violations.iterator().next().getMessage()).isEqualTo("Employee designation must be defined.");
    }
}
