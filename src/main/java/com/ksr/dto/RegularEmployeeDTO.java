package com.ksr.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="b_regular_employee")
//@DiscriminatorValue(value="regularemplyee")  
//@PrimaryKeyJoinColumn(name="employee_id")  
@AttributeOverrides({
	@AttributeOverride(name="employeeId",column=@Column(name="employee_id")),
	@AttributeOverride(name="employeeName",column=@Column(name="employee_name"))
})
public class RegularEmployeeDTO extends EmployeeDTO {
	
	@Column(name="salary")
	private float salary;
	@Column(name="bonus_amount")
	private int bonus;
	
	
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	
	

}
