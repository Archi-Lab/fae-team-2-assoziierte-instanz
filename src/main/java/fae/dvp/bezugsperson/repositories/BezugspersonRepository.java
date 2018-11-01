package fae.dvp.bezugsperson.repositories;

import fae.dvp.bezugsperson.models.Bezugsperson;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BezugspersonRepository extends CrudRepository<Bezugsperson, Long> {

    Iterable<Bezugsperson> findAllById(int id);

}


