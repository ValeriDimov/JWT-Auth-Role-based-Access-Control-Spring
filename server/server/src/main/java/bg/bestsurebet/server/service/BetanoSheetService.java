package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Event;
import bg.bestsurebet.server.model.entity.sheet.BetanoSheet;
import bg.bestsurebet.server.repository.BetanoSheetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BetanoSheetService {

    private final BetanoSheetRepository betanoSheetRepository;

    public BetanoSheetService(BetanoSheetRepository betanoSheetRepository) {
        this.betanoSheetRepository = betanoSheetRepository;
    }

    public void saveOrUpdateBetanoSheet(Event event, String identifier, String oneXTwoMarketBetano, String overUnderMarketBetano, String goalNoGoalMarketBetano) {
        Optional<BetanoSheet> optionalBetanoSheet = this.betanoSheetRepository.findByIdentifier(identifier);

        if (optionalBetanoSheet.isPresent()) {
            this.betanoSheetRepository.save(optionalBetanoSheet.get()
                    .setEvent(event)
                    .setIdentifier(identifier)
                    .setOneXTwo(oneXTwoMarketBetano)
                    .setOverUnder(overUnderMarketBetano)
                    .setGoalNoGoal(goalNoGoalMarketBetano));

        } else {
            this.betanoSheetRepository.save(new BetanoSheet()
                    .setEvent(event)
                    .setIdentifier(identifier)
                    .setOneXTwo(oneXTwoMarketBetano)
                    .setOverUnder(overUnderMarketBetano)
                    .setGoalNoGoal(goalNoGoalMarketBetano));
        }
    }

    public void deleteAllBetanoSheet() {
        this.betanoSheetRepository.deleteAll();
    }
}
