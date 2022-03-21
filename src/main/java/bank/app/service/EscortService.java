package bank.app.service;

import bank.app.api.dto.EscortDTO;
import bank.app.entity.EscortEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class EscortService {
    public List<EscortEntity> getEscorts() {
        return List.of();
    }

    public EscortEntity getEscortById(String id) {
        return new EscortEntity();
    }

    public EscortEntity addNewEscort(EscortDTO dto) {
        return new EscortEntity();
    }

    public EscortEntity updateEscort(String id, EscortDTO dto) {
        return new EscortEntity();
    }

    public void deleteEscort(String id) {
    }
}
