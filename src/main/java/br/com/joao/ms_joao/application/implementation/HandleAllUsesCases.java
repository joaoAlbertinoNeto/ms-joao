package br.com.joao.ms_joao.application.implementation;

import br.com.joao.ms_joao.application.useCase.DeleteUseCase;
import br.com.joao.ms_joao.application.useCase.ListUseCase;
import br.com.joao.ms_joao.application.useCase.SaveUseCase;
import br.com.joao.ms_joao.application.useCase.UpdateUseCase;
import br.com.joao.ms_joao.domain.dto.PersonDTO;
import br.com.joao.ms_joao.domain.dto.PersonResponseDTO;
import br.com.joao.ms_joao.domain.exceptions.BadRequestException;
import br.com.joao.ms_joao.infrastructure.db.out.person.PersonDb;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class HandleAllUsesCases implements SaveUseCase , DeleteUseCase , ListUseCase , UpdateUseCase {
    private final PersonDb personDb;
    private Logger log = LoggerFactory.getLogger(HandleAllUsesCases.class);

    private final ModelMapper modelMapper;

    public HandleAllUsesCases(PersonDb personDb, ModelMapper modelMapper) {
        this.personDb = personDb;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonResponseDTO deleteData(String id) {
        log.info("INIT - [ALL-USES-CASES] [DELETE-OPERATION]  - {} ", id);
        var response = personDb.delete(id);
        log.info("END - [ALL-USES-CASES] [DELETE-OPERATION]  - {} ", response.toString());
        return response;
    }

    @Override
    public PersonResponseDTO findById(String id) {
        log.info("INIT - [ALL-USES-CASES] [LIST-OPERATION] [ID] - {} ", id);
        var response = personDb.getById(id);
        log.info("END - [ALL-USES-CASES] [LIST-OPERATION] [ID] - {} ", response.toString());
        return response;
    }

    @Override
    public List<PersonResponseDTO> findByAge(String age) {
        log.info("INIT - [ALL-USES-CASES] [LIST-OPERATION] [AGE] - {} ", age);
        var response = personDb.getByAge(age);
        log.info("END - [ALL-USES-CASES] [LIST-OPERATION] [AGE] - {} ", response.toString());
        return response;
    }

    @Override
    public PersonResponseDTO findByEmail(String email) {
        log.info("INIT - [ALL-USES-CASES] [LIST-OPERATION] [EMAIL] - {} ", email);
        var response = personDb.getByEmail(email);
        log.info("END - [ALL-USES-CASES] [LIST-OPERATION] [EMAIL] - {} ", response.toString());
        return response;
    }

    @Override
    public PersonResponseDTO saveData(PersonDTO personDTO) throws BadRequestException {
        log.info("INIT - [ALL-USES-CASES] [SAVE-OPERATION] [SAVE] - {} ", personDTO.toString());

        if(Objects.nonNull(personDb.getByEmail(personDTO.getEmail()))){
            log.error("ERROR - EMAIL JA CADASTRADO - {} ",personDTO.getEmail());
            throw new BadRequestException("EMAIL ALREADY CREATED","BAD_REQUEST");
        }
        var response = personDb.save(personDTO);
        log.info("END - [ALL-USES-CASES] [SAVE-OPERATION] [SAVE] - {} ", response.toString());
        return response;
    }

    @Override
    public PersonResponseDTO updateData(String id, PersonDTO personDTO) throws BadRequestException {
        log.info("INIT - [ALL-USES-CASES] [UPDATE-OPERATION] [UPDATE] - {} ", personDTO.toString());
        var personFromDb = personDb.getById(id);

        if(Objects.isNull(personFromDb)){
            log.error("ERROR - PERSON NAO ENCONTRADA - {} ",id);
            throw new BadRequestException("ACTUAL PERSON NOT EXISTS","BAD_REQUEST");
        }

        if(Objects.nonNull(personDb.getByEmail(personDTO.getEmail())) && !personFromDb.getEmail().equalsIgnoreCase(personDTO.getEmail())){
            log.error("ERROR - EMAIL JA CADASTRADO - {} ",personDTO.getEmail());
            throw new BadRequestException("EMAIL ALREADY CREATED","BAD_REQUEST");
        }

        personFromDb.setName(personDTO.getName());
        personFromDb.setAge(personDTO.getAge());
        personFromDb.setStatus(personDTO.getStatus());
        personFromDb.setEmail(personDTO.getEmail());

        var personDtoToUpdate = modelMapper.map(personFromDb , PersonDTO.class);
        var response = personDb.update(personDtoToUpdate,personFromDb.getId());

        log.info("END - [ALL-USES-CASES] [UPDATE-OPERATION] [UPDATE] - {} ", response.toString());
        return response;
    }
}
