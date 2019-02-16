package de.th.koeln.fae.microservice_assoziierte_instanz.repositories;

import de.th.koeln.fae.microservice_assoziierte_instanz.models.Asi.AssoziierteInstanz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;


@RepositoryRestResource(path = "asis")
public interface AssoziierteInstanzRepository extends CrudRepository<AssoziierteInstanz, UUID> {
}


