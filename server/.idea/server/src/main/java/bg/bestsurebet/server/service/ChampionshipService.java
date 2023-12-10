package bg.bestsurebet.server.service;

import bg.bestsurebet.server.model.entity.Championship;
import bg.bestsurebet.server.repository.ChampionshipRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChampionshipService {

    private final ChampionshipRepository championshipRepository;

    public ChampionshipService(ChampionshipRepository championshipRepository) {
        this.championshipRepository = championshipRepository;
    }

    public Optional<Championship> findChampionshipByName(String name) {
        return this.championshipRepository.findByName(name);
    }

    public Championship save(Championship newChampionship) {
        return this.championshipRepository.save(newChampionship);
    }
}
