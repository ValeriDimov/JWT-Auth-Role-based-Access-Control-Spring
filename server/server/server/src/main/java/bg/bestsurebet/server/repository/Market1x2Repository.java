package bg.bestsurebet.server.repository;

import bg.bestsurebet.server.model.entity.Market1x2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Market1x2Repository extends JpaRepository<Market1x2, Long> {

    Optional<Market1x2> findByEventIdentifier(String identifier);
}
