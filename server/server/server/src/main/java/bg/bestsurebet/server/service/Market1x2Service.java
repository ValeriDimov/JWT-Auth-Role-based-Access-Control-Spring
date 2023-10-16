package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Bookmaker;
import bg.bestsurebet.server.model.entity.Event;
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

    public void generateMarket1x2Procedure(String identifier, double coefficient1, double coefficientX,
                                                double coefficient2, Bookmaker bookmaker, Event event) {
        Market1x2 market1x2 = new Market1x2();
        double marginCoef1 = 0.00;
        double marginCoefX = 0.00;
        double marginCoef2 = 0.00;

        Optional<Market1x2> optionalMarket1x2 = this.market1x2Repository.findByEventIdentifier(identifier);

        if (optionalMarket1x2.isPresent()) {
            market1x2 = optionalMarket1x2.get();

            if (market1x2.getCoefficient1() < coefficient1) {
                marginCoef1 = coefficient1;

                market1x2
                        .setCoefficient1(coefficient1)
                        .setCoef1Bookmaker(bookmaker);

            } else {
                marginCoef1 = market1x2.getCoefficient1();
            }

            if (market1x2.getCoefficientX() < coefficientX) {
                marginCoefX = coefficientX;

                market1x2
                        .setCoefficientX(coefficientX)
                        .setCoefXBookmaker(bookmaker);

            } else {
                marginCoefX = market1x2.getCoefficientX();
            }

            if (market1x2.getCoefficient2() < coefficient2) {
                marginCoef2 = coefficient2;

                market1x2
                        .setCoefficient2(coefficient2)
                        .setCoef2Bookmaker(bookmaker);

            } else {
                marginCoef2 = market1x2.getCoefficient2();
            }

            market1x2.setMargin(calcMargin1x2(marginCoef1, marginCoefX, marginCoef2));

            this.market1x2Repository.save(market1x2);

        } else {
            market1x2
                    .setCoefficient1(coefficient1)
                    .setCoef1Bookmaker(bookmaker)
                    .setCoefficientX(coefficientX)
                    .setCoefXBookmaker(bookmaker)
                    .setCoefficient2(coefficient2)
                    .setCoef2Bookmaker(bookmaker)
                    .setMargin(calcMargin1x2(coefficient1, coefficientX, coefficient2))
                    .setEvent(event);

            this.market1x2Repository.save(market1x2);
        }
    }

    private double calcMargin1x2(double coefficient1, double coefficientX, double coefficient2) {
        return 100 / coefficient1 / (1 / coefficient1 + 1 / coefficientX + 1 / coefficient2) * coefficient1 - 100;
    }
}