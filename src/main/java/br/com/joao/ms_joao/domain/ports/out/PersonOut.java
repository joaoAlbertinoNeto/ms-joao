package br.com.joao.ms_joao.domain.ports.out;

import br.com.joao.ms_joao.domain.dto.PersonDTO;
import br.com.joao.ms_joao.domain.dto.PersonResponseDTO;

import java.util.List;

public interface PersonOut {
    public PersonResponseDTO save(PersonDTO personDTO);

    PersonResponseDTO update(PersonDTO personDTO, String id);

    public PersonResponseDTO delete(String id);
    public PersonResponseDTO getById(String id);
    public List<PersonResponseDTO> getByAge(String age);
    public PersonResponseDTO getByEmail(String email);
}
