package br.com.joao.ms_joao.infrastructure.db.out.person.repository;

import br.com.joao.ms_joao.domain.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {
    public Optional<List<PersonEntity>> findAllByAge(String age);
    public Optional<PersonEntity> findByEmail(String email);
}
