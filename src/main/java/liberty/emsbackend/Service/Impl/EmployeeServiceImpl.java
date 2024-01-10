package liberty.emsbackend.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import liberty.emsbackend.Dto.EmployeeDto;
import liberty.emsbackend.Entity.Employee;
import liberty.emsbackend.Exception.ResourceNotFoundException;
import liberty.emsbackend.Mapper.EmployeeMapper;
import liberty.emsbackend.Service.EmployeeService;
import liberty.emsbackend.Repository.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		// TODO Auto-generated method stub
		
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
		Employee savedEmployee = employeeRepository.save(employee);
		
		return EmployeeMapper.mapToEmpoyeeDto(savedEmployee);
	}

	@Override
	@Transactional
	public EmployeeDto getEmployeeById(Long employeeId) {
		// TODO Auto-generated method stub
		Employee employee = employeeRepository.findById(employeeId)
		.orElseThrow(() -> 
		         new ResourceNotFoundException("Employee is not exist with given id :" + employeeId));
		
		return EmployeeMapper.mapToEmpoyeeDto(employee);
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		// TODO Auto-generated method stub
		//use database.table name
		List<Employee> employees = (List<Employee>) employeeRepository.findData();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmpoyeeDto(employee))
				.collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDto> getPendingEmp() {
		// TODO Auto-generated method stub
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		return employees.stream().map((employee) -> EmployeeMapper.mapToEmpoyeeDto(employee))
				.collect(Collectors.toList());
	}
	
	
	

}
