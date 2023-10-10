package in.nareshit.raghu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
	
	@Id
	@GeneratedValue
	private  int empId;
	
	private String empName;
	private Double empSal;
	private String empDept;
	
	

}
