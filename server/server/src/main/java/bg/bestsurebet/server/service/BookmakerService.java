package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Bookmaker;
import bg.bestsurebet.server.repository.BookmakerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookmakerService {

    private final BookmakerRepository bookmakerRepository;

    public BookmakerService(BookmakerRepository bookmakerRepository) {
        this.bookmakerRepository = bookmakerRepository;
    }

    public Bookmaker findBookmakerByName(String name, String bookmaker) {
        Optional<Bookmaker> optionalBookmaker = this.bookmakerRepository.findByName(name);

        return optionalBookmaker.isPresent() ?
                optionalBookmaker.get() : this.bookmakerRepository.save(new Bookmaker().setName(bookmaker));
    }

    public Bookmaker save(Bookmaker newBookmaker) {
        return this.bookmakerRepository.save(newBookmaker);
    }
}
