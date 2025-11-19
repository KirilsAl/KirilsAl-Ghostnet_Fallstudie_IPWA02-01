package de.kirils.ghostnet.ghostnetfallstudie.controller;

import de.kirils.ghostnet.ghostnetfallstudie.dto.CreateGhostNetRequest;
import de.kirils.ghostnet.ghostnetfallstudie.model.GhostNet;
import de.kirils.ghostnet.ghostnetfallstudie.model.NetStatus;
import de.kirils.ghostnet.ghostnetfallstudie.model.Person;
import de.kirils.ghostnet.ghostnetfallstudie.model.PersonRole;
import de.kirils.ghostnet.ghostnetfallstudie.repo.GhostNetRepository;
import de.kirils.ghostnet.ghostnetfallstudie.repo.PersonRepository;
import de.kirils.ghostnet.ghostnetfallstudie.service.GhostNetService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api/nets")

public class GhostNetController {
    private final GhostNetRepository ghostNetRepository;
    private final PersonRepository personRepository;

    public GhostNetController(GhostNetRepository ghostNetRepository,
                              PersonRepository personRepository) {
        this.ghostNetRepository = ghostNetRepository;
        this.personRepository = personRepository;
    }

    @PostMapping
    public GhostNet createGhostNet(@RequestBody CreateGhostNetRequest dto) {
        Person meldendePerson = new Person(
                dto.name(),
                dto.phone(),
                PersonRole.MELDEND
        );
        personRepository.save(meldendePerson);

        GhostNet ghostNet = new GhostNet(
                dto.gpsLat(),
                dto.gpsLon(),
                dto.sizeEstimate(),
                LocalDateTime.now(),
                null,
                NetStatus.GEMELDET
        );
        return ghostNetRepository.save(ghostNet);
    }

    @GetMapping("/open")
    public List<GhostNet> getOpenNets() {
        List<NetStatus> statuses = List.of(
                NetStatus.GEMELDET,
                NetStatus.BERGUNG_BEVORSTEHEND
        );
        return ghostNetRepository.findByNetStatusIn((statuses));
    }
}
