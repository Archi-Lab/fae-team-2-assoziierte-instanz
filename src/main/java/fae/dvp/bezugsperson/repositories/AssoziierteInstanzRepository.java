package fae.dvp.bezugsperson.repositories;

import fae.dvp.bezugsperson.models.AssoziierteInstanz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssoziierteInstanzRepository extends CrudRepository<AssoziierteInstanz, Long> {

    Iterable<AssoziierteInstanz> findAllById(int id);

}


