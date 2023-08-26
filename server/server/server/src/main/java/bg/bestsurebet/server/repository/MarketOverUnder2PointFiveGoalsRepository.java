package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.MarketOverUnder2PointFiveGoals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarketOverUnder2PointFiveGoalsRepository extends JpaRepository<MarketOverUnder2PointFiveGoals, Long> {

    Optional<MarketOverUnder2PointFiveGoals> findByEventIdentifier(String identifier);
}
