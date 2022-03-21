package bank.app.api;


import bank.app.api.dto.ClientDTO;
import bank.app.api.dto.DepositDTO;
import bank.app.api.dto.LoanDTO;
import bank.app.api.error_handler.errors.AccessForbiddenException;
import bank.app.api.error_handler.errors.ObjectNotFoundException;
import bank.app.api.error_handler.errors.ObjectValidationFailedException;
import bank.app.api.mapper.ClientMapper;
import bank.app.api.mapper.DepositMapper;
import bank.app.api.mapper.LoanMapper;
import bank.app.service.ClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class ClientController {

    private final ClientMapper clientMapper = ClientMapper.INSTANCE;
    private final DepositMapper depositMapper = DepositMapper.INSTANCE;
    private final LoanMapper loanMapper = LoanMapper.INSTANCE;

    private final ClientService service;


    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getClients()
            throws AccessForbiddenException {

        List<ClientDTO> clients = clientMapper.clientListToDto(service.getClients());

        return ResponseEntity.ok(clients);
    }

    @GetMapping("/clients/{client_id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable("client_id") String id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        ClientDTO client = clientMapper.clientToDto(service.getClientById(id));

        return ResponseEntity.ok(client);
    }

    @GetMapping("/clients/{client_id}/loans")
    public ResponseEntity<List<LoanDTO>> getClientLoansById(@PathVariable("client_id") String id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        List<LoanDTO> loans = loanMapper.loanListToDto(service.getClientLoansById(id));

        return ResponseEntity.ok(loans);
    }

    @GetMapping("/clients/{client_id}/loans/{loan_id}")
    public ResponseEntity<LoanDTO> getClientLoanById(@PathVariable("client_id") String client_id,
                                                     @PathVariable("loan_id") String loan_id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        LoanDTO loan = loanMapper.loanToDto(service.getClientLoanById(client_id, loan_id));

        return ResponseEntity.ok(loan);
    }


    @GetMapping("/clients/{client_id}/deposits")
    public ResponseEntity<List<DepositDTO>> getClientDepositsById(@PathVariable("client_id") String id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        List<DepositDTO> deposits = depositMapper.depositListToDto(service.getClientDepositsById(id));

        return ResponseEntity.ok(deposits);
    }

    @GetMapping("/clients/{client_id}/deposits/{deposit_id}")
    public ResponseEntity<DepositDTO> getClientDepositById(@PathVariable("client_id") String client_id,
                                                           @PathVariable("deposit_id") String deposit_id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        DepositDTO deposit = depositMapper.depositToDto(service.getClientDepositById(client_id, deposit_id));

        return ResponseEntity.ok(deposit);
    }

    @PostMapping("/clients")
    public ResponseEntity<ClientDTO> addNewClient(@RequestBody ClientDTO dto)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException{

        ClientDTO client = clientMapper.clientToDto(service.addNewClient(dto));

        return ResponseEntity.ok(client);
    }

    @PostMapping("/clients/{client_id}/loans")
    public ResponseEntity<LoanDTO> addNewLoan(@PathVariable("client_id") String id,
                                              @RequestBody LoanDTO dto)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        LoanDTO loan = loanMapper.loanToDto(service.addNewLoanForClient(id, dto));

        return ResponseEntity.ok(loan);
    }

    @PostMapping("/clients/{client_id}/deposits")
    public ResponseEntity<DepositDTO> addNewDeposit(@PathVariable("client_id") String id,
                                                    @RequestBody DepositDTO dto)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        DepositDTO deposit = depositMapper.depositToDto(service.addNewDepositForClient(id, dto));

        return ResponseEntity.ok(deposit);
    }

    @PutMapping("/clients/{client_id}")
    public ResponseEntity<Void> updateClientById(@PathVariable("client_id") String id,
                                                      @RequestBody ClientDTO dto)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException{

        ClientDTO client = clientMapper.clientToDto(service.updateClient(id, dto));

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/clients/{client_id}/loans/{loan_id}")
    public ResponseEntity<Void> updateLoanById(@PathVariable("client_id") String client_id,
                                              @PathVariable("loan_id") String loan_id,
                                              @RequestBody LoanDTO dto)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        LoanDTO loan = loanMapper.loanToDto(service.updateLoan(client_id, loan_id, dto));

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/clients/{client_id}/deposits/{deposit_id}")
    public ResponseEntity<Void> updateDepositById(@PathVariable("client_id") String client_id,
                                                    @PathVariable("deposit_id") String deposit_id,
                                                    @RequestBody DepositDTO dto)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        DepositDTO deposit = depositMapper.depositToDto(service.updateDeposit(client_id, deposit_id, dto));

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/clients/{client_id}")
    public ResponseEntity<Void> deleteClientById(@PathVariable("client_id") String id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException{

        service.deleteClient(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/clients/{client_id}/loans/{loan_id}")
    public ResponseEntity<Void> deleteLoanById(@PathVariable("client_id") String client_id,
                                               @PathVariable("loan_id") String loan_id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        service.deleteLoan(client_id, loan_id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/clients/{client_id}/deposits/{deposit_id}")
    public ResponseEntity<Void> deleteDepositById(@PathVariable("client_id") String client_id,
                                                  @PathVariable("deposit_id") String deposit_id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        service.deleteDeposit(client_id, deposit_id);

        return ResponseEntity.noContent().build();
    }


}
