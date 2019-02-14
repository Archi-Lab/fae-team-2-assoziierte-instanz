package de.th.koeln.fae.microservice_assoziierte_instanz.repositories;

import de.th.koeln.fae.microservice_assoziierte_instanz.models.DementiellVeraendertePerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "dvps")
public interface DementiellVeraendertePersonRepository extends CrudRepository<DementiellVeraendertePerson, String> {

}