package br.com.joao.ms_joao.application.useCase;

import br.com.joao.ms_joao.domain.dto.PersonDTO;
import br.com.joao.ms_joao.domain.dto.PersonResponseDTO;
import org.apache.coyote.BadRequestException;

public interface UpdateUseCase {
    public PersonResponseDTO updateData(String id, PersonDTO personDTO) throws BadRequestException;
}
