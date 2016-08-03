package com.ksr.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="b_contract_employee")

//SINGLE_TABLE
//@DiscriminatorValue(value="contractemployee")

//JOINED
//@PrimaryKeyJoinColumn(name="employee_id")   

//TABLE_PER_CLASS
@AttributeOverrides({
	@AttributeOverride(name="employeeId",column=@Column(name="employee_id")),
	@AttributeOverride(name="employeeName",column=@Column(name="employee_name"))
})
public class ContractEmployeeDTO  extends EmployeeDTO  {
		
		@Column(name="pay_per_hour")
		private float payPerHour;
		@Column(name="contract_period")
		private int contractPeriod;
		
		
		public float getPayPerHour() {
			return payPerHour;
		}
		public void setPayPerHour(float payPerHour) {
			this.payPerHour = payPerHour;
		}
		public int getContractPeriod() {
			return contractPeriod;
		}
		public void setContractPeriod(int contractPeriod) {
			this.contractPeriod = contractPeriod;
		}
		
				

}
