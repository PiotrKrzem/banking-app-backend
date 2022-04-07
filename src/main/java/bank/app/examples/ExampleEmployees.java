
package bank.app.examples;

import bank.app.api.dto.ClientDTO;
import bank.app.api.dto.EmployeeDTO;
import bank.app.api.mapper.ClientMapper;
import bank.app.api.mapper.EmployeeMapper;
import bank.app.entity.ClientEntity;
import bank.app.entity.EmployeeEntity;

import java.time.LocalDateTime;
import java.util.List;

public class ExampleEmployees {

    private static final EmployeeMapper mapper = EmployeeMapper.INSTANCE;

    public static final Integer EXAMPLE_CLIENT_ID_1 = 1;
    public static final Integer EXAMPLE_CLIENT_ID_2 = 2;
    public static final Integer EXAMPLE_CLIENT_ID_3 = 3;

    public static final String EXAMPLE_FIRSTNAME_1 = "Johny";
    public static final String EXAMPLE_FIRSTNAME_2 = "Tom";
    public static final String EXAMPLE_FIRSTNAME_3 = "Max";

    public static final String EXAMPLE_LASTNAME_1 = "Bravo";
    public static final String EXAMPLE_LASTNAME_2 = "Jerry";
    public static final String EXAMPLE_LASTNAME_3 = "Maximus";

    public static final LocalDateTime EXAMPLE_BDAY_1 = LocalDateTime.of(2000, 1, 1, 1, 1);
    public static final LocalDateTime EXAMPLE_BDAY_2 = LocalDateTime.of(2010, 7, 3, 1, 1);
    public static final LocalDateTime EXAMPLE_BDAY_3 = LocalDateTime.of(1998, 10, 2, 1, 1);



    public static List<EmployeeEntity> getExampleEmployees(){

        //TODO
        ClientEntity entity1 = new ClientEntity(EXAMPLE_CLIENT_ID_1);
        entity1.setFirstName(EXAMPLE_FIRSTNAME_1);
        entity1.setSecondName(EXAMPLE_LASTNAME_1);
        entity1.setDateOfBirth(EXAMPLE_BDAY_1);

        ClientEntity entity2 = new ClientEntity(EXAMPLE_CLIENT_ID_2);
        entity2.setFirstName(EXAMPLE_FIRSTNAME_2);
        entity2.setSecondName(EXAMPLE_LASTNAME_2);
        entity2.setDateOfBirth(EXAMPLE_BDAY_2);

        ClientEntity entity3 = new ClientEntity(EXAMPLE_CLIENT_ID_3);
        entity3.setFirstName(EXAMPLE_FIRSTNAME_3);
        entity3.setSecondName(EXAMPLE_LASTNAME_3);
        entity3.setDateOfBirth(EXAMPLE_BDAY_3);

        //return List.of(entity1, entity2, entity3);
        return  List.of();
    }

    public static List<EmployeeDTO> getExampleEmployeesDTOs() {
        return mapper.employeeListToDto(getExampleEmployees());
    }
}
