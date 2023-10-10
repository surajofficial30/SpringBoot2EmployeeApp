package in.nareshit.raghu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nareshit.raghu.model.Employee;
import in.nareshit.raghu.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService service;
	
	//1 save 
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
		Integer id = service.saveEmployee(employee);
		
		return new ResponseEntity<String>("Employee " +employee.getEmpName() + " Saved " , HttpStatus.OK);
	}
	
	//2 fetch all
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> allEmployee = service.getAllEmployee();
		return  new ResponseEntity<List<Employee>> (allEmployee, HttpStatus.OK);
	}
	
	// 3 fetch one 
	
	@GetMapping("/one/{id}")
	public ResponseEntity<Employee> getOneEmployee(@PathVariable Integer id){
		 Employee oneEmployee = service.getOneEmployee(id);
		return  new ResponseEntity<Employee>(oneEmployee, HttpStatus.OK);
	}
	
	//4 Delete
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteEmployee(@RequestParam("id") Integer id){
		service.deleteEmployee(id);
		
		return new ResponseEntity<String> ("Employee  ' "+id+"' Deleted successully", HttpStatus.OK);
		
		
	}
	// 5 update 
	@PutMapping("/modify/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable Integer id , @RequestBody Employee emp){
		
		Employee db = service.getOneEmployee(id);
		db.setEmpDept(emp.getEmpDept());
		db.setEmpName(emp.getEmpName());
		db.setEmpSal(emp.getEmpSal());
		
		service.saveEmployee(db);
		
		return new ResponseEntity<String>("Employee '"+id+"' Update succssfully", HttpStatus.OK);
		
		
	}
	
	

}
