package fae.dvp.bezugsperson.repositories;

import fae.dvp.bezugsperson.models.DementiellVeraendertePerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DementiellVeraendertePersonRepository extends CrudRepository<DementiellVeraendertePerson, Long> {

    Iterable<DementiellVeraendertePerson> findAllById(int id);

}
