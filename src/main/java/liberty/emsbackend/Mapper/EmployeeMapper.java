package liberty.emsbackend.Mapper;

import liberty.emsbackend.Dto.EmployeeDto;
import liberty.emsbackend.Entity.Employee;

public class EmployeeMapper {
	
	public static EmployeeDto mapToEmpoyeeDto(Employee employee) {
		return new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getImage(),
				employee.getStatus()
				
				);
	}
	
	public static Employee mapToEmployee(EmployeeDto employeeDto) {
		return new Employee(
				employeeDto.getId(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getEmail(),
				employeeDto.getImage(),
				employeeDto.getStatus()
				);
	}

}
