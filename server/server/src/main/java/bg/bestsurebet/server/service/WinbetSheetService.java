package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Event;
import bg.bestsurebet.server.model.entity.sheet.WinbetSheet;
import bg.bestsurebet.server.repository.WinbetSheetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WinbetSheetService {

    private final WinbetSheetRepository winbetSheetRepository;

    public WinbetSheetService(WinbetSheetRepository winbetSheetRepository) {
        this.winbetSheetRepository = winbetSheetRepository;
    }

    public void saveOrUpdateWinbetSheet(Event event, String identifier, String oneXTwoMarketWinbet, String overUnderMarketWinbet, String bothTeamsToScoreMarketWinbet) {
        Optional<WinbetSheet> optionalWinbetSheet = this.winbetSheetRepository.findByIdentifier(identifier);

        if (optionalWinbetSheet.isPresent()) {
            this.winbetSheetRepository.save(optionalWinbetSheet.get()
                    .setEvent(event)
                    .setIdentifier(identifier)
                    .setOneXTwo(oneXTwoMarketWinbet)
                    .setOverUnder(overUnderMarketWinbet)
                    .setBothTeamsToScore(bothTeamsToScoreMarketWinbet));

        } else {
            this.winbetSheetRepository.save(new WinbetSheet()
                    .setEvent(event)
                    .setIdentifier(identifier)
                    .setOneXTwo(oneXTwoMarketWinbet)
                    .setOverUnder(overUnderMarketWinbet)
                    .setBothTeamsToScore(bothTeamsToScoreMarketWinbet));
        }
    }

    public void saveOrUpdateWinbetSheet(Event event, String identifier, String overUnderMarketWinbet) {
        Optional<WinbetSheet> optionalWinbetSheet = this.winbetSheetRepository.findByIdentifier(identifier);

        if (optionalWinbetSheet.isPresent()) {
            this.winbetSheetRepository.save(optionalWinbetSheet.get()
                    .setEvent(event)
                    .setIdentifier(identifier)
                    .setOverUnder(overUnderMarketWinbet));
        }
    }

    public void saveOrUpdateWinbetSheet(String identifier, String oneXTwoMarketWinbet) {
        Optional<WinbetSheet> optionalWinbetSheet = this.winbetSheetRepository.findByIdentifier(identifier);

        if (optionalWinbetSheet.isPresent()) {
            this.winbetSheetRepository.save(optionalWinbetSheet.get()
                    .setOneXTwo(oneXTwoMarketWinbet));
        }
    }

    public void saveOrUpdateWinbetSheet(String identifier, String marketBothTeamsToScore, boolean isBothTeamsToScore) {
        Optional<WinbetSheet> optionalWinbetSheet = this.winbetSheetRepository.findByIdentifier(identifier);

        if (optionalWinbetSheet.isPresent()) {
            if (isBothTeamsToScore) {
                this.winbetSheetRepository.save(optionalWinbetSheet.get()
                        .setBothTeamsToScore(marketBothTeamsToScore));
            }
        }
    }

    public void deleteAllWinbetSheet() {
        this.winbetSheetRepository.deleteAll();
    }
}
