package in.roopsai.employeeportal.employeeregister.domain;

import jakarta.validation.constraints.NotBlank;

public record Employee(
        @NotBlank(message = "Employee ID must be defined.")
        String id,
        @NotBlank(message = "Employee Name must be defined.")
        String name,
        @NotBlank(message = "Employee designation must be defined.")
        String designation
) {

}
