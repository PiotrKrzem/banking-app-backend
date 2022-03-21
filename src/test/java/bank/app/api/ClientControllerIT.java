package bank.app.api;

import bank.app.DemoApplication;
import bank.app.api.dto.ClientDTO;
import bank.app.api.mapper.ClientMapper;
import bank.app.examples.ExampleClients;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Controller Test - Deployments")
@SpringBootTest(classes = DemoApplication.class)
public class ClientControllerIT {

    final ClientMapper clientMapper = ClientMapper.INSTANCE;
    final List<ClientDTO> exampleClients = ExampleClients.getExampleClientsDTOs();


    @Nested
    @DisplayName("A Client")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class DeploymentTest {

        @Autowired
        private ClientController clientController;

        ClientDTO client;
        List<ClientDTO> clients;

        ResponseEntity<ClientDTO> clientResponseEntity;
        ResponseEntity<List<ClientDTO>> clientListResponseEntity;

        @BeforeAll
        public void setup() {

        }

        @BeforeEach
        void before_each() {

        }

        @AfterEach
        void after_each() {
        }

        @Nested
        @DisplayName("when added via controller")
        class WhenCreatedViaController {

            @Test
            @DisplayName("has response 200")
            void deployDeployment() {
                client = exampleClients.get(0);
                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();

            }
        }
    }
}
