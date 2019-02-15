package de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import de.th.koeln.fae.microservice_assoziierte_instanz.models.DementiellVeraendertePerson;
import de.th.koeln.fae.microservice_assoziierte_instanz.repositories.DementiellVeraendertePersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import de.th.koeln.fae.microservice_assoziierte_instanz.repositories.AssoziierteInstanzRepository;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.AssoziierteInstanz;

import java.util.UUID;

@RepositoryRestController
public class AssoziierteInstanzController {

    private final AssoziierteInstanzRepository assoziierteInstanzRepository;
    private final DementiellVeraendertePersonRepository dvpRepo;

    @Autowired
    public AssoziierteInstanzController(AssoziierteInstanzRepository assoziierteInstanzRepository, DementiellVeraendertePersonRepository dvpRepo){
        this.assoziierteInstanzRepository = assoziierteInstanzRepository;
        this.dvpRepo = dvpRepo;
    }


    @GetMapping(path = "/asis")
    public ResponseEntity<?> getAssozierteInstanzen(){
        final Iterable<AssoziierteInstanz> assoziierteInstanzList = this.assoziierteInstanzRepository.findAll();

        Resources<AssoziierteInstanz> resources = new Resources<>(assoziierteInstanzList);

        resources.add(linkTo(methodOn(AssoziierteInstanzController.class).getAssozierteInstanzen()).withSelfRel());

        return  ResponseEntity.ok(resources);
    }

    @PostMapping(path = "/asis")
    AssoziierteInstanz neueAssozierteInstanz(@RequestBody AssoziierteInstanz neueAssoziirteInstanz){
        return assoziierteInstanzRepository.save(neueAssoziirteInstanz);
    }

//    @PutMapping(path = "/asis/{asiid}")
//    AssoziierteInstanz verknupfeDVP(@RequestParam(value = "dvpid", required = false) String dvpid, @PathVariable UUID asiid){
//        DementiellVeraendertePerson dvp = dvpRepo.findById(UUID.fromString(dvpid));
//
//
//    }

    @DeleteMapping("/asis/{id}")
    void loescheAsi(@PathVariable Long id){
        assoziierteInstanzRepository.deleteById(id);
    }

}
