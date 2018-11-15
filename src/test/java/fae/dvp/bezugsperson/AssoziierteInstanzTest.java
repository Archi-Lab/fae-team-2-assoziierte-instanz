package fae.dvp.bezugsperson;

import static org.junit.Assert.*;

import fae.dvp.bezugsperson.models.AssoziierteInstanz;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fae.dvp.bezugsperson.repositories.AssoziierteInstanzRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class AssoziierteInstanzTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssoziierteInstanzTest.class);

    @Autowired
    private AssoziierteInstanzRepository assoziierteInstanzRepository;

    @Test
    public void createBezugspersonExpectCreated(){
        final AssoziierteInstanz person = new AssoziierteInstanz();

        //person.setRolle("Tochter");
        //person.setUsername("Egal");
        //person.setPasswort("hunter1");


        final AssoziierteInstanz savedPerson = this.assoziierteInstanzRepository.save(person);

        assertNotNull(savedPerson);
        assertNotNull(savedPerson.getId());
        assertEquals(person.getRolle(), savedPerson.getRolle());
        assertEquals(person.getUsername(), savedPerson.getUsername());
        assertEquals(person.getPasswort(), savedPerson.getPasswort());

        LOGGER.info("Person was saved:");
        LOGGER.info(savedPerson.toString());

    }

}
