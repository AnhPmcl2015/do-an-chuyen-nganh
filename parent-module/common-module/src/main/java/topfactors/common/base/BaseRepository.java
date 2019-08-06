/** Copyright Aug 4, 2019 TopFactors To Present
All right reserved.
Developed By:
** Phan Thế Anh - AnhPT
** Vũ Mạnh Cường - CuongVM
*/
package topfactors.common.base;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID>{
	Optional<T> findByIdAndIsDeletedFalse(ID id);
	List<T> findByIsDeletedFalse();
	List<T> findByIsDeletedTrue();
	long count();
	long countByIsDeletedFalse();
	long countByIsDeletedTrue();
}
