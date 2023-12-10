package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.MarketGoalNoGoal;
import bg.bestsurebet.server.repository.MarketGoalNoGoalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketGoalNoGoalService {

    private final MarketGoalNoGoalRepository marketGoalNoGoalRepository;

    public MarketGoalNoGoalService(MarketGoalNoGoalRepository marketGoalNoGoalRepository) {
        this.marketGoalNoGoalRepository = marketGoalNoGoalRepository;
    }

    public Optional<MarketGoalNoGoal> findMarketGoalNoGoalByEventIdentifier(String identifier) {
        return this.marketGoalNoGoalRepository.findByEventIdentifier(identifier);
    }

    public MarketGoalNoGoal save(MarketGoalNoGoal newMarketGoalNoGoal) {
        return this.marketGoalNoGoalRepository.save(newMarketGoalNoGoal);
    }
}
