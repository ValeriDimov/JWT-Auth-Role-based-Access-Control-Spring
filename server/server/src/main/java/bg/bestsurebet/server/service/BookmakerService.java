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

    public Optional<Bookmaker> findBookmakerByName(String name) {
        return this.bookmakerRepository.findByName(name);
    }

    public Bookmaker save(Bookmaker newBookmaker) {
        return this.bookmakerRepository.save(newBookmaker);
    }
}
