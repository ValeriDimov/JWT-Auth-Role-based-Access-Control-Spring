package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.MarketOverUnder2PointFiveGoals;
import bg.bestsurebet.server.repository.MarketOverUnder2PointFiveGoalsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketOverUnder2PointFiveGoalsService {

    private final MarketOverUnder2PointFiveGoalsRepository marketOverUnder2PointFiveGoalsRepository;

    public MarketOverUnder2PointFiveGoalsService(MarketOverUnder2PointFiveGoalsRepository marketOverUnder2PointFiveGoalsRepository) {
        this.marketOverUnder2PointFiveGoalsRepository = marketOverUnder2PointFiveGoalsRepository;
    }

    public Optional<MarketOverUnder2PointFiveGoals> findMarketOverUnder2PointFiveGoalsByEventIdentifier(String identifier) {
        return this.marketOverUnder2PointFiveGoalsRepository.findByEventIdentifier(identifier);
    }

    public MarketOverUnder2PointFiveGoals save(MarketOverUnder2PointFiveGoals newMarketOverUnder2PointFiveGoals) {
        return this.marketOverUnder2PointFiveGoalsRepository.save(newMarketOverUnder2PointFiveGoals);
    }
}
