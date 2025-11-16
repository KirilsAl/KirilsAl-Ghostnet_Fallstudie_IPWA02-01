package de.kirils.ghostnet.ghostnetfallstudie;

import de.kirils.ghostnet.ghostnetfallstudie.model.GhostNet;
import de.kirils.ghostnet.ghostnetfallstudie.model.NetStatus;
import de.kirils.ghostnet.ghostnetfallstudie.model.Person;
import de.kirils.ghostnet.ghostnetfallstudie.model.PersonRole;
import de.kirils.ghostnet.ghostnetfallstudie.repo.GhostNetRepository;
import de.kirils.ghostnet.ghostnetfallstudie.repo.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GhostnetFallstudieApplication {

    public static void main(String[] args) {

        SpringApplication.run(GhostnetFallstudieApplication.class, args);
    }

    // Test, ob der Datenbankeintrag funktioniert. Später automatisch über WebApp
    @Bean
    CommandLineRunner commandLineRunner(GhostNetRepository ghostNetRepository){
        return args -> {
            GhostNet erstesNetz = new GhostNet(
                    -3.07040,
                    -124.75726,
                    10,
                    "Pazifischer Ozean",
                    13L,
                    NetStatus.GEBORGEN
            );
        };
    }
}


    /*@Bean
    CommandLineRunner commandLineRunner(PersonRepository personRepository){
        return args -> {
            Person erstesPerson = new Person(
                    "Kirils Aleksejevs",
                    "015734315624",
                    PersonRole.BERGEND
            );
            personRepository.save(erstesPerson);
        };
    }

     */

