package br.com.joao.ms_joao.infrastructure.db.out.person;

import br.com.joao.ms_joao.domain.dto.PersonDTO;
import br.com.joao.ms_joao.domain.dto.PersonResponseDTO;
import br.com.joao.ms_joao.domain.entity.PersonEntity;
import br.com.joao.ms_joao.domain.ports.out.PersonOut;
import br.com.joao.ms_joao.infrastructure.db.out.person.repository.PersonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonDb implements PersonOut {

    private final PersonRepository personRepository;

    private final ModelMapper modelMapper;

    public PersonDb(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PersonResponseDTO save(PersonDTO personDTO) {
        var personEntity = modelMapper.map(personDTO, PersonEntity.class);
        return modelMapper.map(personRepository.save(personEntity), PersonResponseDTO.class);
    }

    @Override
    public PersonResponseDTO update(PersonDTO personDTO , String id) {
        var personEntity = modelMapper.map(personDTO, PersonEntity.class);
        personEntity.setId(Long.valueOf(id));
        return modelMapper.map(personRepository.save(personEntity), PersonResponseDTO.class);
    }

    @Override
    public PersonResponseDTO delete(String id) {
        var response = personRepository.findById(Long.valueOf(id)).orElseThrow(EntityNotFoundException::new);
        personRepository.delete(response);
        return new PersonResponseDTO();
    }

    @Override
    public PersonResponseDTO getById(String id) {
        var response = personRepository.findById(Long.valueOf(id)).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(personRepository.save(response), PersonResponseDTO.class);
    }

    @Override
    public List<PersonResponseDTO> getByAge(String age) {
        List<PersonResponseDTO> listResponse = new ArrayList<>();
        var response = personRepository.findAllByAge(age).orElse(new ArrayList<PersonEntity>());
        for(var item : response){
            listResponse.add(modelMapper.map(item, PersonResponseDTO.class));
        }
        return listResponse;
    }

    @Override
    public PersonResponseDTO getByEmail(String email) {
        var response = personRepository.findByEmail(email).orElse(null);
        return modelMapper.map(personRepository.findByEmail(email), PersonResponseDTO.class);
    }
}
