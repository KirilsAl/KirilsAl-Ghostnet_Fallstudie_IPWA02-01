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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

    @PostMapping("/{netId}/assign/{personId}")
    public GhostNet assignBergendePerson(@PathVariable Long netId,
                                         @PathVariable Long personId) {
        GhostNet ghostNet = ghostNetRepository.findById(netId).orElseThrow(() -> new RuntimeException("GhostNet mit ID" + netId + " nicht gefunden"));

        Person person = personRepository.findById(personId).orElseThrow(() -> new RuntimeException("Person mit der ID" + personId + " nicht gefunden"));

        person.setpersonRole(PersonRole.BERGEND);
        personRepository.save(person);

        ghostNet.setbergendePersonID(person);

        ghostNet.setNetStatus(NetStatus.GEMELDET);

        return ghostNetRepository.save(ghostNet);
    }

    @PostMapping("/{netId/complete")
    public GhostNet markNetAsComplete(@PathVariable Long netId) {
        GhostNet ghostNet = ghostNetRepository.findById(netId).orElseThrow(() -> new RuntimeException("GhostNet mit der ID " +  netId + " nicht gefunden"));

        if (ghostNet.getBergendePersonID() == null) {
            throw new RuntimeException("Netz " + netId + "kann nicht als geborgen markiert werden, keine bergende Person eingetragen");
        }

        ghostNet.setNetStatus(NetStatus.GEMELDET);

        return ghostNetRepository.save(ghostNet);
    }

    @PostMapping("/{netId}/lost")
    public GhostNet markNetAsLost(@PathVariable Long netId) {
        GhostNet ghostNet = ghostNetRepository.findById(netId).orElseThrow(() -> new RuntimeException("Netz " + netId + " nicht gefunden"));

        ghostNet.setNetStatus(NetStatus.VERSCHOLLEN);

        return ghostNetRepository.save(ghostNet);
    }
}
