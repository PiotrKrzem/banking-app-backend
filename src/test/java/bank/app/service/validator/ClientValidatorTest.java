package bank.app.service.validator;

import bank.app.api.error_handler.errors.ObjectValidationFailedException;
import bank.app.entity.ClientEntity;
import bank.app.examples.ExampleClients;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
public class ClientValidatorTest {

    final List<ClientEntity> exampleClients = ExampleClients.getExampleClients();


    @BeforeEach
    void before_each(){
    }

    @AfterEach
    void after_each(){
    }

    @Test
    public void test_validator_optimistic_case(){
        ClientValidator.validateClient(exampleClients.get(0));
    }

    @Test
    public void test_validator_id_empty(){
        ClientEntity client = new ClientEntity("");
        assertThrows(ObjectValidationFailedException.class, () -> ClientValidator.validateClient(client));
    }

    @Test
    public void test_validator_id_null(){
        ClientEntity client = new ClientEntity();
        assertThrows(ObjectValidationFailedException.class, () -> ClientValidator.validateClient(client));
    }



}
