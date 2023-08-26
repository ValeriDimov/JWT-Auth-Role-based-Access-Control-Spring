package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Event;
import bg.bestsurebet.server.model.entity.sheet.EfbetSheet;
import bg.bestsurebet.server.repository.EfbetSheetRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EfbetSheetService {

    private final EfbetSheetRepository efbetSheetRepository;

    public EfbetSheetService(EfbetSheetRepository efbetSheetRepository) {
        this.efbetSheetRepository = efbetSheetRepository;
    }

    public void saveOrUpdateEfbetSheet(Event event, String identifier, String oneXTwoMarketEfbet) {
        Optional<EfbetSheet> optionalEfbetSheet = this.efbetSheetRepository.findByIdentifier(identifier);

        if (optionalEfbetSheet.isPresent()) {
            this.efbetSheetRepository.save(optionalEfbetSheet.get()
                    .setEvent(event)
                    .setIdentifier(identifier)
                    .setOneXTwo(oneXTwoMarketEfbet));

        } else {
            this.efbetSheetRepository.save(new EfbetSheet()
                    .setEvent(event)
                    .setIdentifier(identifier)
                    .setOneXTwo(oneXTwoMarketEfbet));
        }
    }
}
