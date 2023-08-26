package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.TeamNomenclature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamNomenclatureRepository extends JpaRepository<TeamNomenclature, Long> {

    Optional<TeamNomenclature> findTeamNomenclatureByTeamNameBetano(String teamName);
    Optional<TeamNomenclature> findTeamNomenclatureByTeamNameEfbet(String teamName);

}
