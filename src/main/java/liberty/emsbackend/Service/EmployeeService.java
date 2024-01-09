package liberty.emsbackend.Service;

import java.util.List;

import liberty.emsbackend.Dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto employeeDto);
	
	EmployeeDto getEmployeeById(Long employeeId);
	List<EmployeeDto> getAllEmployees();
	List<EmployeeDto> getPendingEmp();

}
