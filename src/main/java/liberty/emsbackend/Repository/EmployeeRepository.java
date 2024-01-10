package liberty.emsbackend.Repository;

import liberty.emsbackend.Entity.*;

import java.util.Collection;

import org.springframework.data.jpa.repository.*;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	@Query(
			  value = "select * from railway.employees  where status = 'accepted'", 
			  nativeQuery = true)
			Collection<Employee> findData();

}
