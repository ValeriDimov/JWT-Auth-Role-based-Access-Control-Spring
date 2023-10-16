package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.sheet.BetanoSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BetanoSheetRepository extends JpaRepository<BetanoSheet, Long> {
    Optional<BetanoSheet> findByIdentifier(String identifier);

    @Override
    void deleteAll();
}
