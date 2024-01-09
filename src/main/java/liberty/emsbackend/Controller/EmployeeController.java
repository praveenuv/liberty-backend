package liberty.emsbackend.Controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import liberty.emsbackend.Dto.EmployeeDto;
import liberty.emsbackend.Service.EmployeeService;
import java.io.IOException;

import java.io.IOException;
import java.util.List;
import org.springframework.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("*")
@Controller
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	//add employee API
	@PostMapping
	public ResponseEntity<EmployeeDto> createEmployee( @RequestParam("file") MultipartFile multipartFile,
			@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,
			@RequestParam("email") String email) throws IOException{
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setFirstName(firstName);
		employeeDto.setLastName(lastName);
		employeeDto.setEmail(email);
		employeeDto.setImage(multipartFile.getBytes());
		employeeDto.setStatu("pending at president");
		EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
		
	}
	
	//get employee  by id API
	@GetMapping("{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id")Long employeeId){
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		return ResponseEntity.ok(employeeDto);
	}
	
	//get All employee REST API
	@GetMapping
	public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
		List<EmployeeDto> employees = employeeService.getAllEmployees();
		return ResponseEntity.ok(employees);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDto>> getPendingEmp(){
		System.out.println("hello all employeesss....");
		List<EmployeeDto> employees = employeeService.getPendingEmp();
		System.out.println("...."+employees);
		return ResponseEntity.ok(employees);
	}
	
	@PostMapping("/pending/{id}/{name}")
	public ResponseEntity<EmployeeDto> getUpdate(@PathVariable("id")Long employeeId,@PathVariable("name") String status){
		EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
		employeeDto.setStatu(status);
		employeeDto = employeeService.createEmployee(employeeDto);
		return ResponseEntity.ok(employeeDto);
	}
	
}
