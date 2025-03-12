package br.com.joao.ms_joao.infrastructure.rest.in.person.swagger;

import br.com.joao.ms_joao.domain.dto.PersonDTO;
import br.com.joao.ms_joao.domain.dto.PersonResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/personOperations")
public interface PersonApi {

    @Operation(summary = "Create a new person")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Person created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping("/create")
    ResponseEntity<PersonResponseDTO> createPerson(@RequestBody PersonDTO personDTO) throws BadRequestException;

    @Operation(summary = "Delete a person by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Person deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    @DeleteMapping("/delete/{id}")
    ResponseEntity<PersonResponseDTO> deletePerson(@PathVariable("id") String id);

    @Operation(summary = "Find a person by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person found"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    @GetMapping("/id/{id}")
    ResponseEntity<PersonResponseDTO> getPersonById(@PathVariable("id") String id);

    @Operation(summary = "Find a person by Email")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person found"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    @GetMapping("/email/{email}")
    ResponseEntity<PersonResponseDTO> getPersonByEmail(@PathVariable("email") String email);

    @Operation(summary = "Find a person by Age")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Person found"),
            @ApiResponse(responseCode = "404", description = "Person not found")
    })
    @GetMapping("/age/{age}")
    ResponseEntity<List<PersonResponseDTO>> getPersonByAge(@PathVariable("age") String age);
}
