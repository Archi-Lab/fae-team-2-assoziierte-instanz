package fae.dvp.bezugsperson.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import fae.dvp.bezugsperson.repositories.AssoziierteInstanzRepository;
import fae.dvp.bezugsperson.models.AssoziierteInstanz;

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

}
