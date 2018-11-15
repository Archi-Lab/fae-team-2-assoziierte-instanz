package fae.dvp.bezugsperson.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import fae.dvp.bezugsperson.models.DvpAsi;


@RepositoryRestResource(path = "/dvpasis")
public interface DvpAsiRepository extends CrudRepository<DvpAsi, Long> {

    Iterable<DvpAsi> findAllById(int id);

}