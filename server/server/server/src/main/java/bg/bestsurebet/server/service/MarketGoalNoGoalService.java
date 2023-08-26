package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Bookmaker;
import bg.bestsurebet.server.model.entity.Event;
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

    public void generateMarketGoalNoGoalProcedure(String identifier, double coefficientGoal, double coefficientNoGoal,
                                                  Bookmaker bookmaker, Event event) {

        MarketGoalNoGoal marketGoalNoGoal = new MarketGoalNoGoal();
        double marginCoefGoal = 0.00;
        double marginCoefNoGoal = 0.00;

        Optional<MarketGoalNoGoal> optionalMarketGoalNoGoal = this.marketGoalNoGoalRepository.findByEventIdentifier(identifier);

        if (optionalMarketGoalNoGoal.isPresent()) {
            marketGoalNoGoal = optionalMarketGoalNoGoal.get();

            if(marketGoalNoGoal.getCoefficientGoal() < coefficientGoal) {
                marginCoefGoal = coefficientGoal;

                marketGoalNoGoal
                        .setCoefficientGoal(coefficientGoal)
                        .setCoefficientGoalBookmaker(bookmaker);

            } else {
                marginCoefGoal = marketGoalNoGoal.getCoefficientGoal();
            }

            if(marketGoalNoGoal.getCoefficientNoGoal() < coefficientNoGoal) {
                marginCoefNoGoal = coefficientNoGoal;

                marketGoalNoGoal
                        .setCoefficientNoGoal(coefficientNoGoal)
                        .setCoefficientNoGoalBookmaker(bookmaker);

            } else {
                marginCoefNoGoal = marketGoalNoGoal.getCoefficientNoGoal();
            }

            marketGoalNoGoal.setMargin(calcMarginGoalNoGoal(marginCoefGoal, marginCoefNoGoal));

            this.marketGoalNoGoalRepository.save(marketGoalNoGoal);

        } else {
            marketGoalNoGoal
                    .setCoefficientGoal(coefficientGoal)
                    .setCoefficientGoalBookmaker(bookmaker)
                    .setCoefficientNoGoal(coefficientNoGoal)
                    .setCoefficientNoGoalBookmaker(bookmaker)
                    .setMargin(calcMarginGoalNoGoal(coefficientGoal, coefficientNoGoal))
                    .setEvent(event);

            this.marketGoalNoGoalRepository.save(marketGoalNoGoal);
        }
    }

    private double calcMarginGoalNoGoal(double coefficientGoal, double coefficientNoGoal) {
        return 100 / coefficientGoal / (1 / coefficientGoal + 1 / coefficientNoGoal) * coefficientGoal - 100;
    }
}
