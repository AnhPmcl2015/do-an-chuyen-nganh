package topfactors.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import topfactors.dao.entity.AppRole;

@Repository
public interface RoleRepository extends JpaRepository<AppRole, Long> {
	Optional<AppRole> findByRoleName(String roleName);
}
