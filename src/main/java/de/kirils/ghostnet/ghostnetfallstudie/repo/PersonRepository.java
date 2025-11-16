package de.kirils.ghostnet.ghostnetfallstudie.repo;

import de.kirils.ghostnet.ghostnetfallstudie.model.GhostNet;
import de.kirils.ghostnet.ghostnetfallstudie.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
