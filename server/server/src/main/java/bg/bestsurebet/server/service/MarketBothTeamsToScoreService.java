package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Bookmaker;
import bg.bestsurebet.server.model.entity.Event;
import bg.bestsurebet.server.model.entity.MarketBothTeamsToScore;
import bg.bestsurebet.server.repository.MarketBothTeamsToScoreRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarketBothTeamsToScoreService {

    private final MarketBothTeamsToScoreRepository marketBothTeamsToScoreRepository;

    public MarketBothTeamsToScoreService(MarketBothTeamsToScoreRepository marketBothTeamsToScoreRepository) {
        this.marketBothTeamsToScoreRepository = marketBothTeamsToScoreRepository;
    }

    public Optional<MarketBothTeamsToScore> findMarketBothTeamsToScoreByEventIdentifier(String identifier) {
        return this.marketBothTeamsToScoreRepository.findByEventIdentifier(identifier);
    }

    public MarketBothTeamsToScore save(MarketBothTeamsToScore newMarketBothTeamsToScore) {
        return this.marketBothTeamsToScoreRepository.save(newMarketBothTeamsToScore);
    }

    public void generateMarketBothTeamsToScoreProcedure(String identifier, double coefficientYes, double coefficientNo,
                                                  Bookmaker bookmaker, Event event) {

        MarketBothTeamsToScore marketBothTeamsToScore = new MarketBothTeamsToScore();
        double marginCoefYes = 0.00;
        double marginCoefNo = 0.00;

        Optional<MarketBothTeamsToScore> optionalMarketBothTeamsToScore = this.marketBothTeamsToScoreRepository.findByEventIdentifier(identifier);

        if (optionalMarketBothTeamsToScore.isPresent()) {
            marketBothTeamsToScore = optionalMarketBothTeamsToScore.get();

            if(marketBothTeamsToScore.getCoefficientYes() < coefficientYes) {
                marginCoefYes = coefficientYes;

                marketBothTeamsToScore
                        .setCoefficientYes(coefficientYes)
                        .setCoefficientYesBookmaker(bookmaker);

            } else {
                marginCoefYes = marketBothTeamsToScore.getCoefficientYes();
            }

            if(marketBothTeamsToScore.getCoefficientNo() < coefficientNo) {
                marginCoefNo = coefficientNo;

                marketBothTeamsToScore
                        .setCoefficientNo(coefficientNo)
                        .setCoefficientNoBookmaker(bookmaker);

            } else {
                marginCoefNo = marketBothTeamsToScore.getCoefficientNo();
            }

            marketBothTeamsToScore.setMargin(calcMarginBothTeamsToScore(marginCoefYes, marginCoefNo));

            this.marketBothTeamsToScoreRepository.save(marketBothTeamsToScore);

        } else {
            marketBothTeamsToScore
                    .setCoefficientYes(coefficientYes)
                    .setCoefficientYesBookmaker(bookmaker)
                    .setCoefficientNo(coefficientNo)
                    .setCoefficientNoBookmaker(bookmaker)
                    .setMargin(calcMarginBothTeamsToScore(coefficientYes, coefficientNo))
                    .setEvent(event);

            this.marketBothTeamsToScoreRepository.save(marketBothTeamsToScore);
        }
    }

    public void deleteAllMarketsBothTeamsToScore() {
        this.marketBothTeamsToScoreRepository.deleteAll();
    }

    private double calcMarginBothTeamsToScore(double coefficientYes, double coefficientNo) {
        return 100 / coefficientYes / (1 / coefficientYes + 1 / coefficientNo) * coefficientYes - 100;
    }
}
