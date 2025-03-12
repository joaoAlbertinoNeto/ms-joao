package br.com.joao.ms_joao.infrastructure.rest.in.person;


import br.com.joao.ms_joao.application.useCase.DeleteUseCase;
import br.com.joao.ms_joao.application.useCase.ListUseCase;
import br.com.joao.ms_joao.application.useCase.SaveUseCase;
import br.com.joao.ms_joao.application.useCase.UpdateUseCase;
import br.com.joao.ms_joao.domain.dto.PersonDTO;
import br.com.joao.ms_joao.domain.dto.PersonResponseDTO;
import br.com.joao.ms_joao.infrastructure.rest.in.person.swagger.PersonApi;
import jakarta.websocket.server.PathParam;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class PersonController implements PersonApi {
    private final SaveUseCase saveUseCase;
    private final DeleteUseCase deleteUseCase;
    private final ListUseCase listUseCase;

    private final UpdateUseCase updateUseCase;

    public PersonController(SaveUseCase saveUseCase, DeleteUseCase deleteUseCase, ListUseCase listUseCase, UpdateUseCase updateUseCase) {
        this.saveUseCase = saveUseCase;
        this.deleteUseCase = deleteUseCase;
        this.listUseCase = listUseCase;
        this.updateUseCase = updateUseCase;
    }


    @PostMapping(value = "/create" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponseDTO> createPerson(@RequestBody PersonDTO personDTO) throws BadRequestException {
        var response = saveUseCase.saveData(personDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping(value = "/update/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponseDTO> updatePerson(@RequestBody PersonDTO personDTO , @PathVariable("id") String id) throws BadRequestException {
        var response = updateUseCase.updateData(id , personDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<PersonResponseDTO> deletePerson(@PathVariable("id") String id){
        var response = deleteUseCase.deleteData(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PersonResponseDTO> getPersonById(@PathVariable("id") String id){
        var response = listUseCase.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<PersonResponseDTO> getPersonByEmail(@PathVariable("email") String email){
        var response = listUseCase.findByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<PersonResponseDTO>> getPersonByAge(@PathVariable("age") String age){
        var response = listUseCase.findByAge(age);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
