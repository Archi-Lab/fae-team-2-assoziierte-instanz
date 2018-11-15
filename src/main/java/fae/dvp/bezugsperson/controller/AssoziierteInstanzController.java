package fae.dvp.bezugsperson.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public class AssoziierteInstanzController {

    private final AssozierteInstanzRepository assozierteInstanzRepository;

    @Autowired
    public AssoziierteInstanzController(AssozierteInstanzRepository assoziierteInstanzRepository){
            this.assozierteInstanzRepository = assoziierteInstanzRepository;
    }

}
