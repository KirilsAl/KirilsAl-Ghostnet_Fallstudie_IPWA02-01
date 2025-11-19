package de.kirils.ghostnet.ghostnetfallstudie.repo;

import de.kirils.ghostnet.ghostnetfallstudie.model.GhostNet;
import de.kirils.ghostnet.ghostnetfallstudie.model.NetStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GhostNetRepository extends JpaRepository<GhostNet,Long> {

    List<GhostNet> findByNetStatusIn(List<NetStatus> statuses);
}
