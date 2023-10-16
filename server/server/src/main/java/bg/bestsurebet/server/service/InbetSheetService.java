package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Event;
import bg.bestsurebet.server.model.entity.sheet.InbetSheet;
import bg.bestsurebet.server.repository.InbetSheetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InbetSheetService {

    private final InbetSheetRepository inbetSheetRepository;

    public InbetSheetService(InbetSheetRepository inbetSheetRepository) {
        this.inbetSheetRepository = inbetSheetRepository;
    }

    public void saveOrUpdateInbetSheet(Event event, String identifier, String oneXTwoMarketInbet, String overUnderMarketInbet, String bothTeamsToScoreMarketInbet) {
        Optional<InbetSheet> optionalInbetSheet = this.inbetSheetRepository.findByIdentifier(identifier);

        if (optionalInbetSheet.isPresent()) {
            this.inbetSheetRepository.save(optionalInbetSheet.get()
                    .setEvent(event)
                    .setIdentifier(identifier)
                    .setOneXTwo(oneXTwoMarketInbet)
                    .setOverUnder(overUnderMarketInbet)
                    .setBothTeamsToScore(bothTeamsToScoreMarketInbet));

        } else {
            this.inbetSheetRepository.save(new InbetSheet()
                    .setEvent(event)
                    .setIdentifier(identifier)
                    .setOneXTwo(oneXTwoMarketInbet)
                    .setOverUnder(overUnderMarketInbet)
                    .setBothTeamsToScore(bothTeamsToScoreMarketInbet));
        }
    }

    public void saveOrUpdateInbetSheet(Event event, String identifier, String overUnderMarketInbet) {
        Optional<InbetSheet> optionalInbetSheet = this.inbetSheetRepository.findByIdentifier(identifier);

        if (optionalInbetSheet.isPresent()) {
            this.inbetSheetRepository.save(optionalInbetSheet.get()
                    .setEvent(event)
                    .setIdentifier(identifier)
                    .setOverUnder(overUnderMarketInbet));
        }
    }

    public void saveOrUpdateInbetSheet(String identifier, String oneXTwoMarketInbet) {
        Optional<InbetSheet> optionalInbetSheet = this.inbetSheetRepository.findByIdentifier(identifier);

        if (optionalInbetSheet.isPresent()) {
            this.inbetSheetRepository.save(optionalInbetSheet.get()
                    .setOneXTwo(oneXTwoMarketInbet));
        }
    }

    public void saveOrUpdateInbetSheet(String identifier, String marketBothTeamsToScore, boolean isBothTeamsToScore) {
        Optional<InbetSheet> optionalInbetSheet = this.inbetSheetRepository.findByIdentifier(identifier);

        if (optionalInbetSheet.isPresent()) {
            if (isBothTeamsToScore) {
                this.inbetSheetRepository.save(optionalInbetSheet.get()
                        .setBothTeamsToScore(marketBothTeamsToScore));
            }
        }
    }

    public void deleteAllInbetSheet() {
        this.inbetSheetRepository.deleteAll();
    }
}
