package de.kirils.ghostnet.ghostnetfallstudie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class GhostnetFallstudieApplication {

    public static void main(String[] args) {
        SpringApplication.run(GhostnetFallstudieApplication.class, args);
    }
}
