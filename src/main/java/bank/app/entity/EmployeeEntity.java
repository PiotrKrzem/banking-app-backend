package bank.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity extends PersonEntity{
    private Integer salary;
    private String post;

    //public Integer getSalary();

    public void printPost(){}

    public void approveLoan(){}
}
