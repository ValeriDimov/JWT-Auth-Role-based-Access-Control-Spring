package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Market1x2;
import bg.bestsurebet.server.repository.Market1x2Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Market1x2Service {

    private final Market1x2Repository market1x2Repository;

    public Market1x2Service(Market1x2Repository market1x2Repository) {
        this.market1x2Repository = market1x2Repository;
    }

    public Optional<Market1x2> findMarket1x2ByEventIdentifier(String identifier) {
        return this.market1x2Repository.findByEventIdentifier(identifier);
    }

    public Market1x2 save(Market1x2 newMarket1x2) {
        return this.market1x2Repository.save(newMarket1x2);
    }
}
