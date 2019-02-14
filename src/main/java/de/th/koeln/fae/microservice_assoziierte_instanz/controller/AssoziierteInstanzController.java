package de.th.koeln.fae.microservice_assoziierte_instanz.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import de.th.koeln.fae.microservice_assoziierte_instanz.repositories.AssoziierteInstanzRepository;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.AssoziierteInstanz;

@RepositoryRestController
public class AssoziierteInstanzController {

    private final AssoziierteInstanzRepository assoziierteInstanzRepository;

    @Autowired
    public AssoziierteInstanzController(AssoziierteInstanzRepository assoziierteInstanzRepository){
        this.assoziierteInstanzRepository = assoziierteInstanzRepository;
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

/*    @PutMapping(path = "/asis/{id}")
    AssoziierteInstanz ersetzeAssozierteInstanz(@RequestBody AssoziierteInstanz neueAsi, @PathVariable int id){
        return assoziierteInstanzRepository.findAllById(id)
        .map(assozierteInstanz -> {
            assozierteInstanz.set
        }
        )
    }*/

    @DeleteMapping("/asis/{id}")
    void loescheAsi(@PathVariable Long id){
        assoziierteInstanzRepository.deleteById(id);
    }

}
