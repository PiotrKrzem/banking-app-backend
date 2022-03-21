package bank.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity extends PersonEntity{
    private Integer salary;
    private String post;

    public void getSalary(){}

    public void printPost(){}

    public void approveLoan(){}
}
