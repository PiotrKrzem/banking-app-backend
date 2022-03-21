
package bank.app.examples;

import bank.app.api.dto.ClientDTO;
import bank.app.api.mapper.ClientMapper;
import bank.app.entity.ClientEntity;

import java.util.List;

public class ExampleClients {

    private static final ClientMapper mapper = ClientMapper.INSTANCE;

    public static final String EXAMPLE_CLIENT_ID_1 = "example_client_id_1";
    public static final String EXAMPLE_CLIENT_ID_2 = "example_client_id_2";
    public static final String EXAMPLE_CLIENT_ID_3 = "example_client_id_3";

    public static List<ClientEntity> getExampleClients(){
        return List.of(
                new ClientEntity(EXAMPLE_CLIENT_ID_1),
                new ClientEntity(EXAMPLE_CLIENT_ID_2),
                new ClientEntity(EXAMPLE_CLIENT_ID_3)
        );
    }

    public static List<ClientDTO> getExampleClientsDTOs() {
        return mapper.clientListToDto(getExampleClients());
    }
}
