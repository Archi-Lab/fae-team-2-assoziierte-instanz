package de.th.koeln.fae.microservice_assoziierte_instanz.repositories;

import de.th.koeln.fae.microservice_assoziierte_instanz.models.dvp.DementiellVeraendertePerson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;


@RepositoryRestResource(path = "dvps")
public interface DementiellVeraendertePersonRepository extends CrudRepository<DementiellVeraendertePerson, UUID> {

}