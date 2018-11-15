package fae.dvp.bezugsperson.repositories;

import fae.dvp.bezugsperson.models.AssoziierteInstanz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "asis")
public interface AssoziierteInstanzRepository extends CrudRepository<AssoziierteInstanz, Long> {

    Iterable<AssoziierteInstanz> findAllById(int id);
    @Override
    void deleteById(Long aLong);
}


