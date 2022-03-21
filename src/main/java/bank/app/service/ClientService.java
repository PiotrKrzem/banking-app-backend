package bank.app.service;

import bank.app.api.dto.ClientDTO;
import bank.app.api.dto.DepositDTO;
import bank.app.api.dto.LoanDTO;
import bank.app.entity.ClientEntity;
import bank.app.entity.DepositEntity;
import bank.app.entity.LoanEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClientService {
    public List<ClientEntity> getClients(){
        return List.of();
    }

    public ClientEntity getClientById(String id) {
        return new ClientEntity();
    }

    public List<LoanEntity> getClientLoansById(String id) {
        return List.of();
    }

    public LoanEntity getClientLoanById(String client_id, String loan_id) {
        return new LoanEntity();
    }

    public List<DepositEntity> getClientDepositsById(String id) {
        return List.of();
    }

    public DepositEntity getClientDepositById(String client_id, String deposit_id) {
        return new DepositEntity();
    }

    public ClientEntity addNewClient(ClientDTO dto) {
        return new ClientEntity();
    }

    public LoanEntity addNewLoanForClient(String id, LoanDTO dto) {
        return new LoanEntity();
    }

    public DepositEntity addNewDepositForClient(String id, DepositDTO dto) {
        return new DepositEntity();
    }

    public ClientEntity updateClient(String id, ClientDTO dto) {
        return new ClientEntity();
    }

    public LoanEntity updateLoan(String client_id, String loan_id, LoanDTO dto) {
        return new LoanEntity();
    }

    public DepositEntity updateDeposit(String client_id, String deposit_id, DepositDTO dto) {
        return new DepositEntity();
    }

    public void deleteClient(String id) {
    }

    public void deleteLoan(String client_id, String loan_id) {
    }

    public void deleteDeposit(String client_id, String deposit_id) {
    }
}
