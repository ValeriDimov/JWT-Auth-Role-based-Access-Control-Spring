package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Bookmaker;
import bg.bestsurebet.server.model.entity.Event;
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

    public void generateMarketOverUnder2PointFiveProcedure(String identifier, double coefficientOver, double coefficientUnder,
                                                                                     Bookmaker bookmaker, Event event) {

        MarketOverUnder2PointFiveGoals marketOverUnder2PointFiveGoals = new MarketOverUnder2PointFiveGoals();
        double marginCoefOver = 0.00;
        double marginCoefUnder = 0.00;

        Optional<MarketOverUnder2PointFiveGoals> optionalMarketOverUnder2PointFiveGoals =
                this.marketOverUnder2PointFiveGoalsRepository.findByEventIdentifier(identifier);

        if (optionalMarketOverUnder2PointFiveGoals.isPresent()) {
            marketOverUnder2PointFiveGoals = optionalMarketOverUnder2PointFiveGoals.get();

            if (marketOverUnder2PointFiveGoals.getCoefficientOver() < coefficientOver) {
                marginCoefOver = coefficientOver;

                marketOverUnder2PointFiveGoals
                        .setCoefficientOver(coefficientOver)
                        .setCoefficientOverBookmaker(bookmaker);

            } else {
                marginCoefOver = marketOverUnder2PointFiveGoals.getCoefficientOver();
            }

            if (marketOverUnder2PointFiveGoals.getCoefficientUnder() < coefficientUnder) {
                marginCoefUnder = coefficientUnder;

                marketOverUnder2PointFiveGoals
                        .setCoefficientUnder(coefficientUnder)
                        .setCoefficientUnderBookmaker(bookmaker);

            } else {
                marginCoefUnder = marketOverUnder2PointFiveGoals.getCoefficientUnder();
            }

            marketOverUnder2PointFiveGoals.setMargin(calcMarginOverUnder(marginCoefOver, marginCoefUnder));

            this.marketOverUnder2PointFiveGoalsRepository.save(marketOverUnder2PointFiveGoals);

        } else {
            marketOverUnder2PointFiveGoals
                    .setCoefficientOver(coefficientOver)
                    .setCoefficientOverBookmaker(bookmaker)
                    .setCoefficientUnder(coefficientUnder)
                    .setCoefficientUnderBookmaker(bookmaker)
                    .setMargin(calcMarginOverUnder(coefficientOver, coefficientUnder))
                    .setEvent(event);

            this.marketOverUnder2PointFiveGoalsRepository.save(marketOverUnder2PointFiveGoals);
        }
    }

    private double calcMarginOverUnder(double marginCoefOver, double marginCoefUnder) {
        return 100 / marginCoefOver / (1 / marginCoefOver + 1 / marginCoefUnder) *  marginCoefOver - 100;
    }
}
