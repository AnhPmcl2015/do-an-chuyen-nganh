package jobcentral.dao.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobcentral.dao.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);
	Optional<User> findByUsernameOrEmail(String username, String email);
	List<User> findByIdIn(List<Long> ids);
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	
}
