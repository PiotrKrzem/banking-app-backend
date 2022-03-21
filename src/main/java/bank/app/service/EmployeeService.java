package bank.app.service;

import bank.app.api.dto.EmployeeDTO;
import bank.app.entity.EmployeeEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {
    public List<EmployeeEntity> getEmployees() {
        return List.of();
    }

    public EmployeeEntity getEmployeeById(String id) {
        return new EmployeeEntity();
    }

    public EmployeeEntity addNewEmployee(EmployeeDTO dto) {
        return new EmployeeEntity();
    }

    public EmployeeEntity updateEmployee(String id, EmployeeDTO dto) {
        return new EmployeeEntity();
    }

    public void deleteEmployee(String id) {
    }
}
