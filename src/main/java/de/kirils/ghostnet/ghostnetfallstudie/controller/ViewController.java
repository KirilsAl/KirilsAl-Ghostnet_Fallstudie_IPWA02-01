package de.kirils.ghostnet.ghostnetfallstudie.controller;

import de.kirils.ghostnet.ghostnetfallstudie.dto.ReportNetForm;
import de.kirils.ghostnet.ghostnetfallstudie.model.GhostNet;
import de.kirils.ghostnet.ghostnetfallstudie.model.NetStatus;
import de.kirils.ghostnet.ghostnetfallstudie.model.Person;
import de.kirils.ghostnet.ghostnetfallstudie.model.PersonRole;
import de.kirils.ghostnet.ghostnetfallstudie.repo.GhostNetRepository;
import de.kirils.ghostnet.ghostnetfallstudie.repo.PersonRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

import java.time.LocalDateTime;

@Controller
public class ViewController {

    private final GhostNetRepository ghostNetRepository;
    private final PersonRepository personRepository;

    public ViewController(GhostNetRepository ghostNetRepository,
                          PersonRepository personRepository) {
        this.ghostNetRepository = ghostNetRepository;
        this.personRepository = personRepository;
    }

    // Startseite: einfach die Liste der Netze
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("nets", ghostNetRepository.findAll());
        return "nets/list";
    }

    // Liste aller Netze anzeigen
    @GetMapping("/nets")
    public String showNetList(Model model) {
        model.addAttribute("nets", ghostNetRepository.findAll());
        return "nets/list";
    }

    // Formular anzeigen
    @GetMapping("/nets/create")
    public String showCreateNetForm(Model model) {
        model.addAttribute("reportNetForm", new ReportNetForm());
        return "nets/create";
    }

    // Formular verarbeiten
    @PostMapping("/nets/create")
    public String handleCreateNetForm(
            @ModelAttribute("reportNetForm") ReportNetForm form
    ) {
        System.out.println("FORM SUBMITTED: " + form.getGpsLat() + " / " + form.getGpsLon());

        Person meldendePerson = null;

        if (form.getName() != null && !form.getName().isBlank()) {
            meldendePerson = new Person(
                    form.getName(),
                    form.getPhone(),
                    PersonRole.MELDEND
            );
            personRepository.save(meldendePerson);
        }

        GhostNet ghostNet = new GhostNet(
                form.getGpsLat(),
                form.getGpsLon(),
                form.getSizeEstimate(),
                LocalDateTime.now(),
                null,
                NetStatus.GEMELDET
        );

        ghostNetRepository.save(ghostNet);

        return "redirect:/nets";

    }

    @GetMapping("/nets/open")
    public String showOpenNets(Model model) {
        var statuses = List.of(NetStatus.GEMELDET, NetStatus.BERGUNG_BEVORSTEHEND);
        model.addAttribute("nets", ghostNetRepository.findByNetStatusIn(statuses));
        return "nets/list";
    }

}
