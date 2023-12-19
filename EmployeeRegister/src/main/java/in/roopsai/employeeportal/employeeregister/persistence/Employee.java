package in.roopsai.employeeportal.employeeregister.persistence;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.*;

import java.time.Instant;

public record Employee(

        @Id
        String id,

        @CreatedDate
        Instant createdDate,

        @LastModifiedDate
        Instant lastModifiedDate,

        @NotBlank(message = "Employee Name must be defined.")
        String name,
        @NotBlank(message = "Employee designation must be defined.")
        String designation,
        @Version
        int version


) {
        public static Employee of(
                String name, String designation
        ) {
                return new Employee(null, null, null, name, designation, 0);
        }


}
