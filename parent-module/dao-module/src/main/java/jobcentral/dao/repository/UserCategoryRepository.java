package jobcentral.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jobcentral.dao.entity.UserCategory;

@Repository
public interface UserCategoryRepository extends JpaRepository<UserCategory, Long>{
	Optional<UserCategory> findByUserCategoryName(String userCategoryName);
}
