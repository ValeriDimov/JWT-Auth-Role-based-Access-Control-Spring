package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.sheet.EfbetSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfbetSheetRepository extends JpaRepository<EfbetSheet, Long> {

}