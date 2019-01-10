/**package fae.dvp.bezugsperson.controller;

import fae.dvp.bezugsperson.models.DvpAsi;
import fae.dvp.bezugsperson.repositories.DvpAsiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class DvpAsiController {

    private final DvpAsiRepository dvpAsiRepository;

    @Autowired
    public DvpAsiController(DvpAsiRepository dvpAsiRepository){
        this.dvpAsiRepository = dvpAsiRepository;
    }


    @GetMapping(path = "/dvpasis")
    public ResponseEntity<?> getdvpasis(){
        final Iterable<DvpAsi> dvpAsiList = this.dvpAsiRepository.findAll();

        Resources<DvpAsi> resources = new Resources<>(dvpAsiList);

        resources.add(linkTo(methodOn(DvpAsiController.class).getdvpasis()).withSelfRel());

        return  ResponseEntity.ok(resources);
    }

    @PostMapping(path = "/dvpasis")
    DvpAsi neuedvpasi(@RequestBody DvpAsi neuedvpasi){
        return dvpAsiRepository.save(neuedvpasi);
    }


    @DeleteMapping("/dvpasis/{id}")
    void loeschedvpasi(@PathVariable Long id){
        dvpAsiRepository.deleteById(id);
    }

}**/
