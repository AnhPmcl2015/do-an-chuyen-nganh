/** Copyright Jul 21, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.dao.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import topfactors.dao.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String>{
	Optional<Company> findByAbbreviation(String abbreviation);
}
