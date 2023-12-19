package in.roopsai.employeeportal.employeeregister.persistence;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    boolean existsByName(String name);


    Optional<Employee> findEmployeeByNameIs(String name);

    @Modifying
    @Query("delete from Employee where name = :name")
    void deleteByName(String name);


}
