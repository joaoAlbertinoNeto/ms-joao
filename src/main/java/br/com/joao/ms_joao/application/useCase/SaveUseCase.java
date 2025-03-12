package br.com.joao.ms_joao.application.useCase;

import br.com.joao.ms_joao.domain.dto.PersonDTO;
import br.com.joao.ms_joao.domain.dto.PersonResponseDTO;
import org.apache.coyote.BadRequestException;

public interface SaveUseCase {
    public PersonResponseDTO saveData(PersonDTO personDTO) throws BadRequestException;
}
