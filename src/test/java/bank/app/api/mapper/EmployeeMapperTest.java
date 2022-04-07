package bank.app.api.mapper;

import bank.app.api.dto.EmployeeDTO;
import bank.app.entity.EmployeeEntity;
import bank.app.examples.ExampleEmployees;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class EmployeeMapperTest {

    final EmployeeMapper mapper = EmployeeMapper.INSTANCE;
    final List<EmployeeEntity> exampleEmployees = ExampleEmployees.getExampleEmployees();
    final List<EmployeeDTO> exampleEmployeesDTOs = ExampleEmployees.getExampleEmployeesDTOs();

    List<EmployeeEntity> employees;
    List<EmployeeDTO> employeeDTOs;
    EmployeeEntity employee;
    EmployeeDTO dto;

    @BeforeEach
    void before_each(){}

    @AfterEach
    void after_each(){}

    @Test
    public void test_mapper_entity_to_dto() {
        exampleEmployees.forEach(employeeEntity -> {
            employee = employeeEntity;
            dto = mapper.employeeToDto(employeeEntity);

            assertThat(dto.getFirstName().equals(employee.getFirstName())).isTrue();
            assertThat(dto.getSecondName().equals(employee.getSecondName())).isTrue();
            assertThat(dto.getDateOfBirth().equals(employee.getDateOfBirth())).isTrue();
            assertThat(dto.getSalary().equals(employee.getSalary())).isTrue();
            assertThat(dto.getPost().equals(employee.getPost())).isTrue();

        });
    }

    @Test
    public void test_mapper_dto_to_entity() {
        exampleEmployeesDTOs.forEach(employeeDTO -> {
            employee = mapper.dtoToEmployee(employeeDTO);
            dto = employeeDTO;

            assertThat(dto.getFirstName().equals(employee.getFirstName())).isTrue();
            assertThat(dto.getSecondName().equals(employee.getSecondName())).isTrue();
            assertThat(dto.getDateOfBirth().equals(employee.getDateOfBirth())).isTrue();
            assertThat(dto.getSalary().equals(employee.getSalary())).isTrue();
            assertThat(dto.getPost().equals(employee.getPost())).isTrue();
        });
    }

    @Test
    public void test_mapper_entity_list_to_dto_list(){
        employees = exampleEmployees;
        employeeDTOs = mapper.employeeListToDto(employees);
        assertThat(employeeDTOs.containsAll(exampleEmployeesDTOs)).isTrue();
    }

    @Test
    public void test_mapper_dto_list_to_entity_list(){
        employees = exampleEmployees;
        employeeDTOs = mapper.employeeListToDto(employees);
        assertThat(employeeDTOs.containsAll(exampleEmployeesDTOs)).isTrue();
    }


}
