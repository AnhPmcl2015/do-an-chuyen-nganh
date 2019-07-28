/** Copyright Jul 21, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import topfactors.dao.entity.Nation;

public interface NationRepository extends JpaRepository<Nation, Short>{
	Optional<Nation> findByNationName(String nationName);
}
