package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.sheet.WinbetSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WinbetSheetRepository extends JpaRepository<WinbetSheet, Long> {
    Optional<WinbetSheet> findByIdentifier(String identifier);

    @Override
    void deleteAll();
}
