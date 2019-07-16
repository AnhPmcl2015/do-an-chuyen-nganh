package jobcentral.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jobcentral.dao.entity.AppUser;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<AppUser, String>{
	Optional<AppUser> findByPhoneNumber(String phoneNumber);
	Optional<AppUser> findByPhoneNumberOrUsername(String phoneNumber, String username);
	Optional<AppUser> findByEmailOrUsername(String email, String username);
	Optional<AppUser> findByEmail(String email);
	Optional<AppUser> findByUsername(String username);
	boolean existsByPhoneNumberAndUsername(String phoneNumber, String username);
	boolean existsByUsername(String username);
	boolean existsByPhoneNumber(String phoneNumber);
	long countByIsDeletedFalse();
	Optional<AppUser> findByUsernameOrEmailOrPhoneNumber(String username, String email, String phoneNumber);
}
