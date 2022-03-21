package bank.app.api;


import bank.app.api.dto.EscortDTO;
import bank.app.api.error_handler.errors.AccessForbiddenException;
import bank.app.api.error_handler.errors.ObjectNotFoundException;
import bank.app.api.error_handler.errors.ObjectValidationFailedException;
import bank.app.api.mapper.EscortMapper;
import bank.app.service.EscortService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
@RequiredArgsConstructor
public class EscortController {

    private final EscortMapper escortMapper = EscortMapper.INSTANCE;
    private final EscortService service;


    @GetMapping("/escorts")
    public ResponseEntity<List<EscortDTO>> getEscorts()
            throws AccessForbiddenException {

        List<EscortDTO> escorts = escortMapper.escortListToDto(service.getEscorts());

        return ResponseEntity.ok(escorts);
    }

    @GetMapping("/escorts/{escort_id}")
    public ResponseEntity<EscortDTO> getEscortById(@PathVariable("escort_id") String id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException {

        EscortDTO escort = escortMapper.escortToDto(service.getEscortById(id));

        return ResponseEntity.ok(escort);
    }

    @PostMapping("/escorts")
    public ResponseEntity<EscortDTO> addNewEscort(@RequestBody EscortDTO dto)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException{

        EscortDTO escort = escortMapper.escortToDto(service.addNewEscort(dto));

        return ResponseEntity.ok(escort);
    }

    @PutMapping("/escorts/{escort_id}")
    public ResponseEntity<Void> updateEscortById(@PathVariable("escort_id") String id,
                                                 @RequestBody EscortDTO dto)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException{

        EscortDTO escort = escortMapper.escortToDto(service.updateEscort(id, dto));

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/escorts/{escort_id}")
    public ResponseEntity<Void> deleteEscortById(@PathVariable("escort_id") String id)
            throws AccessForbiddenException, ObjectNotFoundException, ObjectValidationFailedException{

        service.deleteEscort(id);

        return ResponseEntity.noContent().build();
    }
}
