package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.MarketGoalNoGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MarketGoalNoGoalRepository extends JpaRepository<MarketGoalNoGoal, Long> {

    Optional<MarketGoalNoGoal> findByEventIdentifier(String identifier);
}
