package bank.app.api;

import bank.app.DemoApplication;
import bank.app.api.dto.ClientDTO;
import bank.app.api.dto.DepositDTO;
import bank.app.api.dto.LoanDTO;
import bank.app.api.mapper.ClientMapper;
import bank.app.api.mapper.LoanMapper;
import bank.app.examples.ExampleClients;
import bank.app.examples.ExampleDeposits;
import bank.app.examples.ExampleLoans;
import bank.app.service.ClientService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Clients Controller Test")
@SpringBootTest(classes = DemoApplication.class)
public class ClientControllerIT {

    final ClientMapper clientMapper = ClientMapper.INSTANCE;
    final LoanMapper loanMapper = LoanMapper.INSTANCE;

    final List<ClientDTO> exampleClients = ExampleClients.getExampleClientsDTOs();
    final List<LoanDTO> exampleLoans = ExampleLoans.getExampleLoansDTOs();
    final List<DepositDTO> exampleDeposits = ExampleDeposits.getExampleDepositsDTOs();


    @Nested
    @DisplayName("A Client")
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class DeploymentTest {

        @Autowired
        private ClientService clientService;

        @Autowired
        private ClientController clientController;

        ClientDTO client, clientResponse;
        LoanDTO loan, loanResponse;
        DepositDTO deposit, depositResponse;

        List<ClientDTO> clients, clientsResponse;
        List<LoanDTO> loans, loansResponse;
        List<DepositDTO> deposits, depositsResponse;

        ResponseEntity<ClientDTO> clientResponseEntity;
        ResponseEntity<List<ClientDTO>> clientListResponseEntity;

        ResponseEntity<LoanDTO> loanResponseEntity;
        ResponseEntity<List<LoanDTO>> loanListResponseEntity;

        ResponseEntity<DepositDTO> depositResponseEntity;
        ResponseEntity<List<DepositDTO>> depositListResponseEntity;

        @BeforeAll
        void setup() {
            clientService.deleteAllClients();
        }

        @BeforeEach
        void before_each() {

        }

        @AfterEach
        void after_each() {
            clientService.deleteAllClients();
        }

        @Nested
        @DisplayName("when added via controller")
        class WhenCreatedViaController {

            @Test
            @DisplayName("has response 200")
            void deployClient() {
                exampleClients.forEach(clientDTO -> {
                    client = clientDTO;
                    client.setId(null);

                    clientResponseEntity = clientController.addNewClient(client);
                    assertThat(clientResponseEntity).isNotNull();
                    assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                    assertThat(clientResponseEntity.getBody()).isNotNull();

                    clientResponse = clientResponseEntity.getBody();
                    assertThat(clientResponse.getId()).isNotNull();
                    assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                    assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                    assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                    assertThat(clientResponse.getAccounts()).isNotNull();
                    assertThat(clientResponse.getDeposits()).isNotNull();
                    assertThat(clientResponse.getLoans()).isNotNull();
                });
            }

            @Test
            @DisplayName("has response 400 for client with ID")
            void deployClientWithID() {
                client = exampleClients.get(0);

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.BAD_REQUEST)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNull();
            }

            @Test
            @DisplayName("has response 400 for null request")
            void deployClientIncorrect() {
                client = null;

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.BAD_REQUEST)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNull();
            }
        }

        @Nested
        @DisplayName("when loan added to client via controller")
        class WhenLoanAddedViaController {

            @Test
            @DisplayName("has response 200")
            void addLoan() {
                client = exampleClients.get(0);
                client.setId(null);

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNotNull();

                clientResponse = clientResponseEntity.getBody();
                assertThat(clientResponse.getId()).isNotNull();
                assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                assertThat(clientResponse.getAccounts()).isNotNull();
                assertThat(clientResponse.getDeposits()).isNotNull();
                assertThat(clientResponse.getLoans()).isNotNull();

                exampleLoans.forEach(loanDTO -> {
                    loan = loanDTO;
                    loanResponseEntity = clientController.addNewLoan(String.valueOf(client.getId()), loan);
                    assertThat(loanResponseEntity).isNotNull();
                    assertThat(loanResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                    assertThat(loanResponseEntity.getBody()).isNotNull();

                    loanResponse = loanResponseEntity.getBody();
                    assertThat(loanResponse.getAmountToPay().equals(loan.getAmountToPay())).isTrue();
                    assertThat(loanResponse.getInterestRate().equals(loan.getInterestRate())).isTrue();
                    assertThat(loanResponse.getStartDate().equals(loan.getStartDate()) ).isTrue();
                    assertThat(loanResponse.getEndDate().equals(loan.getEndDate())).isTrue();
                });
            }

            @Test
            @DisplayName("has response 400 for null request")
            void addNullLoan() {
                client = exampleClients.get(0);
                client.setId(null);

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNotNull();

                clientResponse = clientResponseEntity.getBody();
                assertThat(clientResponse.getId()).isNotNull();
                assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                assertThat(clientResponse.getAccounts()).isNotNull();
                assertThat(clientResponse.getDeposits()).isNotNull();
                assertThat(clientResponse.getLoans()).isNotNull();

                loan = null;

                loanResponseEntity = clientController.addNewLoan(String.valueOf(client.getId()), loan);
                assertThat(loanResponseEntity).isNotNull();
                assertThat(loanResponseEntity.getStatusCode().equals(HttpStatus.BAD_REQUEST)).isTrue();
                assertThat(loanResponseEntity.getBody()).isNull();
            }
        }

        @Nested
        @DisplayName("when deposit added to client via controller")
        class WhenDepositAddedViaController {

            @Test
            @DisplayName("has response 200")
            void addDeposit() {
                client = exampleClients.get(0);
                client.setId(null);

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNotNull();

                clientResponse = clientResponseEntity.getBody();
                assertThat(clientResponse.getId()).isNotNull();
                assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                assertThat(clientResponse.getAccounts()).isNotNull();
                assertThat(clientResponse.getDeposits()).isNotNull();
                assertThat(clientResponse.getLoans()).isNotNull();

                exampleDeposits.forEach(depositDTO -> {
                    deposit = depositDTO;
                    depositResponseEntity = clientController.addNewDeposit(String.valueOf(client.getId()), deposit);
                    assertThat(depositResponseEntity).isNotNull();
                    assertThat(depositResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                    assertThat(depositResponseEntity.getBody()).isNotNull();

                    depositResponse = depositResponseEntity.getBody();
                    assertThat(depositResponse.getAssociatedAccount().equals(deposit.getAssociatedAccount())).isTrue();
                    assertThat(depositResponse.getMoneyAmount().equals(deposit.getMoneyAmount())).isTrue();
                    assertThat(depositResponse.getInterestRate().equals(deposit.getInterestRate())).isTrue();
                    assertThat(depositResponse.getStartDate().equals(deposit.getStartDate()) ).isTrue();
                    assertThat(depositResponse.getEndDate().equals(deposit.getEndDate())).isTrue();
                });
            }

            @Test
            @DisplayName("has response 400 for null request")
            void addNullDeposit() {
                client = exampleClients.get(0);
                client.setId(null);

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNotNull();

                clientResponse = clientResponseEntity.getBody();
                assertThat(clientResponse.getId()).isNotNull();
                assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                assertThat(clientResponse.getAccounts()).isNotNull();
                assertThat(clientResponse.getDeposits()).isNotNull();
                assertThat(clientResponse.getLoans()).isNotNull();

                deposit = null;

                depositResponseEntity = clientController.addNewDeposit(String.valueOf(client.getId()), deposit);
                assertThat(depositResponseEntity).isNotNull();
                assertThat(depositResponseEntity.getStatusCode().equals(HttpStatus.BAD_REQUEST)).isTrue();
                assertThat(depositResponseEntity.getBody()).isNull();

            }
        }

        @Nested
        @DisplayName("when requested via controller")
        class WhenRequestedViaController {

            @Test
            @DisplayName("has response 200")
            void deployAndRequestClient() {
                client = exampleClients.get(0);
                client.setId(null);

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNotNull();

                clientResponse = clientResponseEntity.getBody();
                assertThat(clientResponse.getId()).isNotNull();
                assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                assertThat(clientResponse.getAccounts()).isNotNull();
                assertThat(clientResponse.getDeposits()).isNotNull();
                assertThat(clientResponse.getLoans()).isNotNull();


                clientResponseEntity = clientController.getClientById(String.valueOf(clientResponse.getId()));
                assertThat(clientResponse.getId()).isNotNull();
                assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                assertThat(clientResponse.getAccounts().equals(client.getAccounts())).isNotNull();
                assertThat(clientResponse.getDeposits().equals(client.getDeposits())).isNotNull();
                assertThat(clientResponse.getLoans().equals(client.getLoans())).isNotNull();
            }
        }

        @Nested
        @DisplayName("when ALL requested via controller")
        class WhenAllRequestedViaController {

            @Test
            @DisplayName("has response 200")
            void deployAndRequestClient() {
                exampleClients.forEach(clientDTO -> {
                    client = exampleClients.get(0);
                    client.setId(null);

                    clientResponseEntity = clientController.addNewClient(client);
                    assertThat(clientResponseEntity).isNotNull();
                    assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                    assertThat(clientResponseEntity.getBody()).isNotNull();

                    clientResponse = clientResponseEntity.getBody();
                    assertThat(clientResponse.getId()).isNotNull();
                    assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                    assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                    assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                    assertThat(clientResponse.getAccounts()).isNotNull();
                    assertThat(clientResponse.getDeposits()).isNotNull();
                    assertThat(clientResponse.getLoans()).isNotNull();
                });

                clientListResponseEntity = clientController.getClients();
                assertThat(clientListResponseEntity).isNotNull();
                assertThat(clientListResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientListResponseEntity.getBody()).isNotNull();

                clients = clientListResponseEntity.getBody();
                clients.forEach(clientDTO -> {
                    clientDTO.setId(null);
                    assertThat(exampleClients.contains(clientDTO));
                });
            }
        }

        @Nested
        @DisplayName("when ALL loans requested via controller")
        class WhenAllLoansRequestedViaController {

            @Test
            @DisplayName("has response 200")
            void deployAndRequestLoansClient() {
                client = exampleClients.get(0);
                client.setId(null);

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNotNull();

                clientResponse = clientResponseEntity.getBody();
                assertThat(clientResponse.getId()).isNotNull();
                assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                assertThat(clientResponse.getAccounts()).isNotNull();
                assertThat(clientResponse.getDeposits()).isNotNull();
                assertThat(clientResponse.getLoans()).isNotNull();


                loanListResponseEntity = clientController.getClientLoansById(String.valueOf(clientResponse.getId()));
                assertThat(loanListResponseEntity).isNotNull();
                assertThat(loanListResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(loanListResponseEntity.getBody()).isNotNull();

                loans = loanListResponseEntity.getBody();
                assertThat(clientResponse.getLoans().containsAll(loans));
            }
        }

        @Nested
        @DisplayName("when ALL deposits requested via controller")
        class WhenAllDepositsRequestedViaController {

            @Test
            @DisplayName("has response 200")
            void deployAndRequestDepositsClient() {
                client = exampleClients.get(0);
                client.setId(null);

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNotNull();

                clientResponse = clientResponseEntity.getBody();
                assertThat(clientResponse.getId()).isNotNull();
                assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                assertThat(clientResponse.getAccounts()).isNotNull();
                assertThat(clientResponse.getDeposits()).isNotNull();
                assertThat(clientResponse.getLoans()).isNotNull();


                depositListResponseEntity = clientController.getClientDepositsById(String.valueOf(clientResponse.getId()));
                assertThat(depositListResponseEntity).isNotNull();
                assertThat(depositListResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(depositListResponseEntity.getBody()).isNotNull();

                deposits = depositListResponseEntity.getBody();
                assertThat(clientResponse.getDeposits().containsAll(deposits));
            }
        }

        @Nested
        @DisplayName("when client DELETED via controller")
        class WhenClientDeletedViaController {

            @Test
            @DisplayName("has response 200")
            void deployAndDeleteClient() {
                client = exampleClients.get(0);
                client.setId(null);

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNotNull();

                clientResponse = clientResponseEntity.getBody();
                assertThat(clientResponse.getId()).isNotNull();
                assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                assertThat(clientResponse.getAccounts()).isNotNull();
                assertThat(clientResponse.getDeposits()).isNotNull();
                assertThat(clientResponse.getLoans()).isNotNull();


                clientController.deleteClientById(String.valueOf(clientResponse.getId()));

                clientListResponseEntity = clientController.getClients();
                assertThat(clientListResponseEntity).isNotNull();
                assertThat(clientListResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientListResponseEntity.getBody()).isNotNull();
                assertThat(clientListResponseEntity.getBody().isEmpty()).isTrue();
            }
        }

        @Nested
        @DisplayName("when loan DELETED via controller")
        class WhenLoanDeletedViaController {

            @Test
            @DisplayName("has response 200")
            void deployAndDeleteLoan() {
                client = exampleClients.get(0);
                client.setId(null);

                clientResponseEntity = clientController.addNewClient(client);
                assertThat(clientResponseEntity).isNotNull();
                assertThat(clientResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(clientResponseEntity.getBody()).isNotNull();

                clientResponse = clientResponseEntity.getBody();
                assertThat(clientResponse.getId()).isNotNull();
                assertThat(clientResponse.getFirstName().equals(client.getFirstName())).isTrue();
                assertThat(clientResponse.getSecondName().equals(client.getSecondName())).isTrue();
                assertThat(clientResponse.getDateOfBirth().equals(client.getDateOfBirth())).isTrue();
                assertThat(clientResponse.getAccounts()).isNotNull();
                assertThat(clientResponse.getDeposits()).isNotNull();
                assertThat(clientResponse.getLoans()).isNotNull();

                loan = exampleLoans.get(0);
                clientController.addNewLoan(String.valueOf(clientResponse.getId()), loan);
                assertThat(loanResponseEntity).isNotNull();
                assertThat(loanResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(loanResponseEntity.getBody()).isNotNull();

                loanResponse = loanResponseEntity.getBody();
                assertThat(loanResponse.getAmountToPay().equals(loan.getAmountToPay())).isTrue();
                assertThat(loanResponse.getInterestRate().equals(loan.getInterestRate())).isTrue();
                assertThat(loanResponse.getStartDate().equals(loan.getStartDate()) ).isTrue();
                assertThat(loanResponse.getEndDate().equals(loan.getEndDate())).isTrue();

                //TODO
                //delete
                //clientController.deleteLoanById()
                //

                loanListResponseEntity = clientController.getClientLoansById(String.valueOf(clientResponse.getId()));
                assertThat(loanListResponseEntity).isNotNull();
                assertThat(loanListResponseEntity.getStatusCode().equals(HttpStatus.OK)).isTrue();
                assertThat(loanListResponseEntity.getBody()).isNotNull();
                assertThat(loanListResponseEntity.getBody().isEmpty()).isTrue();

            }
        }

    }
}
