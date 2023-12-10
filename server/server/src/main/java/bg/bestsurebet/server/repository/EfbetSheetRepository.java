package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.sheet.EfbetSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EfbetSheetRepository extends JpaRepository<EfbetSheet, Long> {

    Optional<EfbetSheet> findByIdentifier(String identifier);

    @Override
    void deleteAll();

}
