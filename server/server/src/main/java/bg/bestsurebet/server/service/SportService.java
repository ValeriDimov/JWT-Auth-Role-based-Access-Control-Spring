package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Sport;
import bg.bestsurebet.server.repository.SportRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SportService {

    private final SportRepository sportRepository;

    public SportService(SportRepository sportRepository) {
        this.sportRepository = sportRepository;
    }

    public Optional<Sport> findSportByType(String type) {
        return this.sportRepository.findByType(type);
    }

    public Sport save(Sport newSport) {
        return this.sportRepository.save(newSport);
    }
}
