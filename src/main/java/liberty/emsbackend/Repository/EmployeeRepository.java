package liberty.emsbackend.Repository;

import liberty.emsbackend.Entity.*;

import java.util.Collection;

import org.springframework.data.jpa.repository.*;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	@Query(
			  value = "SELECT * FROM EMPLOYEES u WHERE u.status = 'accepted'", 
			  nativeQuery = true)
			Collection<Employee> findData();

}
