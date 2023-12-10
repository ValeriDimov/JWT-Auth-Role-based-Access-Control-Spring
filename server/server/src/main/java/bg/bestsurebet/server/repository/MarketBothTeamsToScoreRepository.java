package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.MarketBothTeamsToScore;
import bg.bestsurebet.server.model.entity.MarketGoalNoGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarketBothTeamsToScoreRepository extends JpaRepository<MarketBothTeamsToScore, Long> {

    Optional<MarketBothTeamsToScore> findByEventIdentifier(String identifier);

    @Override
    void deleteAll();
}
