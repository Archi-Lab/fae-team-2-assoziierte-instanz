package de.th.koeln.fae.microservice_assoziierte_instanz.repositories;

import de.th.koeln.fae.microservice_assoziierte_instanz.models.AssoziierteInstanz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "asis")
public interface AssoziierteInstanzRepository extends CrudRepository<AssoziierteInstanz, Long> {

    Iterable<AssoziierteInstanz> findAllById(int id);
    @Override
    void deleteById(Long aLong);
}


