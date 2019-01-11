package fae.dvp.bezugsperson.repositories;

import fae.dvp.bezugsperson.models.DementiellVeraendertePerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(path = "dvps")
public interface DementiellVeraendertePersonRepository extends CrudRepository<DementiellVeraendertePerson, String> {

}