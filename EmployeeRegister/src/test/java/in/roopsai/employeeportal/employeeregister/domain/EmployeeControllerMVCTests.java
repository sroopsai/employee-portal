package in.roopsai.employeeportal.employeeregister.domain;

import in.roopsai.employeeportal.employeeregister.controller.EmployeeController;
import in.roopsai.employeeportal.employeeregister.exceptions.EmployeeNotFoundException;
import in.roopsai.employeeportal.employeeregister.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerMVCTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Test
    void whenEmployeeNotExists() throws Exception {
        String name = "Employee";
        given(employeeService.getEmployee(name)).willThrow(EmployeeNotFoundException.class);
        mockMvc.perform(get("/employees/" + name)).andExpect(status().isNotFound());

    }


}
