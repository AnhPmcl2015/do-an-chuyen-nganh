package topfactors.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import topfactors.dao.entity.AppUser;
import topfactors.dao.entity.UserOtp;

@Repository
@Transactional
public interface UserOtpRepository extends JpaRepository<UserOtp, Long>{
	
	@Query(value = "UPDATE user_otp as uo SET uo.is_enable = 0 WHERE uo.user_id = :userId", nativeQuery = true)
	boolean deleteUserOtpByUserId(@Param("userId") String userId);
	
	Optional<UserOtp> findByAppUserAndOtpAndIsEnableTrue(AppUser appUser, String otp);
}
