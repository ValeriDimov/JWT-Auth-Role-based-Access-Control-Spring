package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.Championship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ChampionshipRepository extends JpaRepository<Championship, Long> {

    Optional<Championship> findByName(String name);

}
