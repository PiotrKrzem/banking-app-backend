package bank.app.api;


import bank.app.api.dto.EmployeeDTO;
import bank.app.api.error_handler.errors.AccessForbiddenException;
import bank.app.api.error_handler.errors.ObjectNotFoundException;
import bank.app.api.error_handler.errors.ObjectValidationFailedException;
import bank.app.api.mapper.EmployeeMapper;
import bank.app.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeMapper employeeMapper = EmployeeMapper.INSTANCE;
    private final EmployeeService service;


    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployees()
            throws AccessForbiddenException {

        List<EmployeeDTO> employees = employeeMapper.employeeListToDto(service.getEmployees());

        return ResponseEntity.ok(employees);
    }

    @GetMapping("/employees/{employee_id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employee_id") String id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        EmployeeDTO employee = employeeMapper.employeeToDto(service.getEmployeeById(id));

        return ResponseEntity.ok(employee);
    }

    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> addNewEmployee(@RequestBody EmployeeDTO dto)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException{

        EmployeeDTO employee = employeeMapper.employeeToDto(service.addNewEmployee(dto));

        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employees/{employee_id}")
    public ResponseEntity<Void> updateEmployeeById(@PathVariable("employee_id") String id,
                                                 @RequestBody EmployeeDTO dto)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException{

        EmployeeDTO employee = employeeMapper.employeeToDto(service.updateEmployee(id, dto));

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/employees/{employee_id}")
    public ResponseEntity<Void> deleteEmployeeById(@PathVariable("employee_id") String id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException{

        service.deleteEmployee(id);

        return ResponseEntity.noContent().build();
    }
}
