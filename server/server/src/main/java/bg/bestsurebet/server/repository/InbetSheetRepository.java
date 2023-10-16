package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.sheet.InbetSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InbetSheetRepository extends JpaRepository<InbetSheet, Long> {
    Optional<InbetSheet> findByIdentifier(String identifier);

    @Override
    void deleteAll();
}
