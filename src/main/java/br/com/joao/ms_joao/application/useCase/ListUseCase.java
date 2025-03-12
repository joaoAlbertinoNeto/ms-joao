package br.com.joao.ms_joao.application.useCase;

import br.com.joao.ms_joao.domain.dto.PersonDTO;
import br.com.joao.ms_joao.domain.dto.PersonResponseDTO;

import java.util.List;

public interface ListUseCase {
    public PersonResponseDTO findById(String id);
    public List<PersonResponseDTO> findByAge(String age);
    public PersonResponseDTO findByEmail(String email);
}
