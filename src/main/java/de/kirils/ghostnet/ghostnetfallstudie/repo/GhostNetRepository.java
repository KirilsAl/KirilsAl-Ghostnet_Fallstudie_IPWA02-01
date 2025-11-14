package de.kirils.ghostnet.ghostnetfallstudie.repo;

import de.kirils.ghostnet.ghostnetfallstudie.model.GhostNet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GhostNetRepository extends JpaRepository<GhostNet,Long> {
}
