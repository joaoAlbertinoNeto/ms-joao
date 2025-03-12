package br.com.joao.ms_joao.application.implementation;

import br.com.joao.ms_joao.domain.dto.PersonDTO;
import br.com.joao.ms_joao.domain.dto.PersonResponseDTO;
import br.com.joao.ms_joao.infrastructure.db.out.person.PersonDb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;


@ExtendWith(MockitoExtension.class)
class HandleAllUsesCasesTest {

    @InjectMocks
    HandleAllUsesCases handleAllUsesCases;

    @Mock
    PersonDb personDb;

    @Mock
    ModelMapper modelMapper;

    @BeforeEach
    public void setup(){
        handleAllUsesCases = new HandleAllUsesCases(personDb, modelMapper);
    }

    @Test
    void deleteData() {


    }

    @Test
    void findById() {
        var id = "1";
        var person = new PersonResponseDTO();
        person.setId(id);
        Mockito.when(personDb.getById(anyString())).thenReturn(person);
        var response = handleAllUsesCases.findById(id);
        assertThat(response.getId()).isEqualTo(id);
    }

    @Test
    void findByAge() {
        var age = "31";
        var person = new PersonResponseDTO();
        person.setAge(age);
        Mockito.when(personDb.getByAge(anyString())).thenReturn(List.of(person));
        var response = handleAllUsesCases.findByAge(age);
        assertThat(response.size()).isGreaterThan(0);
    }

    @Test
    void findByEmail() {
        var email = "email";
        var person = new PersonResponseDTO();
        person.setEmail(email);
        Mockito.when(personDb.getByEmail(anyString())).thenReturn(person);
        var response = handleAllUsesCases.findByEmail(email);
        assertThat(response.getEmail()).isEqualTo(email);
    }

    @Test
    void saveData() {
        var id = "1";
        var person = new PersonResponseDTO();
        person.setId(id);
        Mockito.when(personDb.save(any(PersonDTO.class))).thenReturn(person);
        var response = handleAllUsesCases.saveData(new PersonDTO());
        assertThat(response.getId()).isEqualTo(id);
    }

}