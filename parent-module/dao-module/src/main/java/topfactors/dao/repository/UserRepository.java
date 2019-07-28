package topfactors.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import topfactors.dao.entity.AppUser;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<AppUser, String>{
	Optional<AppUser> findByPhoneNumber(String phoneNumber);
	Optional<AppUser> findByPhoneNumberOrUsername(String phoneNumber, String username);
	Optional<AppUser> findByEmailOrUsername(String email, String username);
	Optional<AppUser> findByEmail(String email);
	Optional<AppUser> findByUsername(String username);
	boolean existsByPhoneNumberAndUsername(String phoneNumber, String username);
	boolean existsByUsernameOrEmail(String username, String email);
	boolean existsByUsernameOrPhoneNumber(String username, String phoneNumber);
	boolean existsByUsername(String username);
	boolean existsByPhoneNumber(String phoneNumber);
	boolean existsByEmail(String email);
	long countByIsDeletedFalse();
	Optional<AppUser> findByUsernameOrEmailOrPhoneNumber(String username, String email, String phoneNumber);
}
