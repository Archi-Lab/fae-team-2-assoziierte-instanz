package de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import de.th.koeln.fae.microservice_assoziierte_instanz.models.dvp.DementiellVeraendertePerson;
import de.th.koeln.fae.microservice_assoziierte_instanz.repositories.DementiellVeraendertePersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import de.th.koeln.fae.microservice_assoziierte_instanz.repositories.AssoziierteInstanzRepository;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.Asi.AssoziierteInstanz;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RepositoryRestController
public class AssoziierteInstanzController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssoziierteInstanzController.class);
    private final AssoziierteInstanzRepository assoziierteInstanzRepository;
    private final DementiellVeraendertePersonRepository dvpRepo;

    @Autowired
    public AssoziierteInstanzController(AssoziierteInstanzRepository assoziierteInstanzRepository,
                                        DementiellVeraendertePersonRepository dvpRepo){
        this.assoziierteInstanzRepository = assoziierteInstanzRepository;
        this.dvpRepo = dvpRepo;
    }

    private ResponseEntity<?> returnStandardAsiResponse(final UUID asiid){
        final Optional<AssoziierteInstanz> asi = assoziierteInstanzRepository.findById(asiid);
        Resource<AssoziierteInstanz> resource = new Resource<>(asi.get());
        resource.add(linkTo(methodOn(AssoziierteInstanzController.class).getAssoziierteInstanz(asiid)).withSelfRel());
        resource.add(linkTo(methodOn(AssoziierteInstanzController.class).getPossibleDVPsForAdding(asiid)).withRel("add-DVPs"));
        resource.add(linkTo(methodOn(AssoziierteInstanzController.class).getPossibleDVPsForDeletion(asiid)).withRel("delete-DVPs"));
        return ResponseEntity.ok(resource);
    }

    /**
     * Simple Get Methode für die Asi
     *
     * @param asiid Die anzuzeigende assoziierte Instanz
     * @return Das asi Objekt mit dem self-link und den links um eine DVP Verknüpung herzustellen oder zu lösen
     */
    @GetMapping(path="/asis/{asiid}")
    public ResponseEntity<?> getAssoziierteInstanz(@PathVariable("asiid") final UUID asiid){
        final Optional<AssoziierteInstanz> asi = assoziierteInstanzRepository.findById(asiid);
        if(asi.isPresent()){
            return returnStandardAsiResponse(asiid);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Diese Methode ermöglicht einem Clienten, alle mit der asi {asiid} NICHT verknüpften DVPs zu identifizieren und stellt
     * links bereit, um die Verknüpfung herzustellen.
     *
     * @param asiid Die asi, für die mögliche Verknüpfungen bereit gestellt werden sollen.
     * @return Die Assoziierte Instanz und die möglichen Verknüpfungen als Links
     */
    @GetMapping(path="/asis/{asiid}/adddvp")
    public ResponseEntity<?> getPossibleDVPsForAdding(@PathVariable("asiid") final UUID asiid){
        final Optional<AssoziierteInstanz> asi = assoziierteInstanzRepository.findById(asiid);
        final Iterable<DementiellVeraendertePerson> dvpList = dvpRepo.findAll();
        if(asi.isPresent()){
            Resource<AssoziierteInstanz> resource = new Resource<>(asi.get());
            resource.add(linkTo(methodOn(AssoziierteInstanzController.class).getAssoziierteInstanz(asiid)).withSelfRel());
            resource.add(linkTo(methodOn(AssoziierteInstanzController.class).getAssoziierteInstanz(asiid)).withRel("cancel"));
            for(DementiellVeraendertePerson person:dvpList){
                if (!asi.get().getDvps().contains(person)){
                    resource.add(linkTo(methodOn(AssoziierteInstanzController.class).verknupfeDVP(asiid,person.getId(),false))
                            .withRel("add-"+person.getId()));
                }
            }
            return ResponseEntity.ok(resource);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Diese Methode ermöglicht einem Clienten, alle mit der asi {asiid} verknüpften DVPs zu identifizieren und stellt
     * links bereit, um die Verknüpfung aufzuheben.
     *
     * @param asiid Die asi, für die alle Verknüpfungen gelten
     * @return Die Assoziierte Instanz und die möglichen Löschungen als Links
     */
    @GetMapping(path="/asis/{asiid}/deletedvp")
    public ResponseEntity<?> getPossibleDVPsForDeletion(@PathVariable("asiid") final UUID asiid){
        final Optional<AssoziierteInstanz> asi = assoziierteInstanzRepository.findById(asiid);
        final Iterable<DementiellVeraendertePerson> dvpList = dvpRepo.findAll();
        if(asi.isPresent()){
            Resource<AssoziierteInstanz> resource = new Resource<>(asi.get());
            resource.add(linkTo(methodOn(AssoziierteInstanzController.class).getAssoziierteInstanz(asiid)).withSelfRel());
            resource.add(linkTo(methodOn(AssoziierteInstanzController.class).getAssoziierteInstanz(asiid)).withRel("cancel"));
            for(DementiellVeraendertePerson person:dvpList){
                if (asi.get().getDvps().contains(person)){
                    resource.add(linkTo(methodOn(AssoziierteInstanzController.class).verknupfeDVP(asiid,person.getId(),true))
                            .withRel("del-"+person.getId()));
                }
            }
            return ResponseEntity.ok(resource);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Die Methode soll mithilfe eines Parameters dvpid das verknüpfen von asi und dvp vereinfachen
     * /asis/{asiid}/{dvpid}
     *
     * Beispiel: /asis/1e6fddd7-212b-48c0-8811-522b64e17dc7/e2bfc98d-2d1f-4448-b024-8fc7b1b44f90
     *
     * @param dvpid Die UUID der dvp, die mit der assoziierten Instanz verknüpft werden soll
     * @param asiid Die UUID der assoziierten Instanz, die mit der dvp verknüpft werden soll
     * @param delete Wenn dieser wert "true" ist, wird die angegebene dvpid gelöscht, wenn vorhanden
     * @return ok mit resource, bei erfolgreichem Update, not found, wenn asi oder dvp nicht gefunden werden konnte
     */
    @PutMapping(path = "/asis/{asiid}/{dvpid}")
    public ResponseEntity<?> verknupfeDVP(@PathVariable UUID asiid,
                                          @PathVariable UUID dvpid,
                                          @RequestParam(value="delete", required=false,defaultValue = "false") boolean delete){
        Optional<DementiellVeraendertePerson> dvp = dvpRepo.findById(dvpid);
        Optional<AssoziierteInstanz> asi = assoziierteInstanzRepository.findById(asiid);
        if(delete){
            List<DementiellVeraendertePerson> dvpList = asi.get().getDvps();
            if(dvpList.contains(dvp.get())) {
                dvpList.remove(dvp.get());
                assoziierteInstanzRepository.save(asi.get());
                LOGGER.info("Deleted DVP " + dvpid + " from asi " + asiid);
                return returnStandardAsiResponse(asiid);
            }
            LOGGER.info(dvpid + " not found. Deletion not possible");
            return returnStandardAsiResponse(asiid);
        }
        if(dvp.isPresent()){
            if(asi.isPresent()){
                asi.get().getDvps().add(dvp.get());
                assoziierteInstanzRepository.save(asi.get());
                LOGGER.info("Added DVP " + dvpid + " to asi " + asiid);
                return returnStandardAsiResponse(asiid);
            }
            else{
                LOGGER.error("ASI " + asiid + " not found");
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("ASI " + asiid + "doesn't exist");
            }
        }
        else {
            LOGGER.error("DVP " + dvpid+ " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("DVP " + dvpid + "doesn't exist");
        }
    }

    /**
     * Diese Methode kann dazu verwendet werden, alle Informationen einer Asi zu ändern.
     * Ausnahme: Die Liste der DVPs, die wird durch die Methode "verknupfeDVP" bearbeitet
     * @param rbAsi
     * @param asiid
     * @return ok mit resource, bei erfolgreichem Update, not found, wenn asi oder dvp nicht gefunden werden konnte
     */
    @PutMapping(path = "/asis/{asiid}")
    public ResponseEntity<?> putAsi(@RequestBody AssoziierteInstanz rbAsi,
                                          @PathVariable UUID asiid){
        final Optional<AssoziierteInstanz> asi = assoziierteInstanzRepository.findById(asiid);

        if(asi.isPresent()){
            rbAsi.setDvps(asi.get().getDvps());
            rbAsi.setId(asi.get().getId());
            assoziierteInstanzRepository.save(rbAsi);
            LOGGER.info("updated asi "+asiid);
            return returnStandardAsiResponse(asiid);
        }
        else{
            LOGGER.error("Asi " + asiid + " not found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
