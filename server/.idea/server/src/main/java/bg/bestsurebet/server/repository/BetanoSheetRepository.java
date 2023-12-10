package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.sheet.BetanoSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetanoSheetRepository extends JpaRepository<BetanoSheet, Long> {

}
