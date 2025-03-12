package br.com.joao.ms_joao.application.useCase;

import br.com.joao.ms_joao.domain.dto.PersonDTO;
import br.com.joao.ms_joao.domain.dto.PersonResponseDTO;

public interface DeleteUseCase {
    public PersonResponseDTO deleteData(String id);
}
