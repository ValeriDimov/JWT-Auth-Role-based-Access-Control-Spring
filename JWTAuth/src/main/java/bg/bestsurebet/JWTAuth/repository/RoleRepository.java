package bg.bestsurebet.JWTAuth.repository;

import bg.bestsurebet.JWTAuth.entity.Role;
import bg.bestsurebet.JWTAuth.entity.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleEnum name);
}
