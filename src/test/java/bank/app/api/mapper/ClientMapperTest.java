package bank.app.api.mapper;

import bank.app.api.dto.ClientDTO;
import bank.app.entity.ClientEntity;
import bank.app.examples.ExampleClients;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ClientMapperTest {

    final ClientMapper mapper = ClientMapper.INSTANCE;
    final List<ClientEntity> exampleClients = ExampleClients.getExampleClients();
    final List<ClientDTO> exampleClientsDTOs = ExampleClients.getExampleClientsDTOs();

    List<ClientEntity> clients;
    List<ClientDTO> clientDTOs;
    ClientEntity client;
    ClientDTO dto;

    @BeforeEach
    void before_each(){}

    @AfterEach
    void after_each(){}

    @Test
    public void test_mapper_entity_to_dto() {
        exampleClients.forEach(clientEntity -> {
            client = clientEntity;
            dto = mapper.clientToDto(clientEntity);

            assertThat(dto.getFirstName().equals(client.getFirstName())).isTrue();
            assertThat(dto.getSecondName().equals(client.getSecondName())).isTrue();
            assertThat(dto.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
            assertThat(dto.getLoans().equals(client.getLoans())).isTrue();
            assertThat(dto.getDeposits().equals(client.getDeposits())).isTrue();
            assertThat(dto.getAccounts().equals(client.getAccounts())).isTrue();
        });
    }

    @Test
    public void test_mapper_dto_to_entity() {
        exampleClientsDTOs.forEach(clientDTO -> {
            client = mapper.dtoToClient(clientDTO);
            dto = clientDTO;

            assertThat(dto.getFirstName().equals(client.getFirstName())).isTrue();
            assertThat(dto.getSecondName().equals(client.getSecondName())).isTrue();
            assertThat(dto.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
            assertThat(dto.getLoans().equals(client.getLoans())).isTrue();
            assertThat(dto.getDeposits().equals(client.getDeposits())).isTrue();
            assertThat(dto.getAccounts().equals(client.getAccounts())).isTrue();
        });
    }

    @Test
    public void test_mapper_entity_list_to_dto_list(){
        clients = exampleClients;
        clientDTOs = mapper.clientListToDto(clients);
        assertThat(clientDTOs.containsAll(exampleClientsDTOs)).isTrue();
    }

    @Test
    public void test_mapper_dto_list_to_entity_list(){
        clients = exampleClients;
        clientDTOs = mapper.clientListToDto(clients);
        assertThat(clientDTOs.containsAll(exampleClientsDTOs)).isTrue();
    }


}
