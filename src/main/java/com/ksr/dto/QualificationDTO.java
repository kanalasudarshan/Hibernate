package com.ksr.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="b_qualification")
public class QualificationDTO {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="qualification_id")
	private int qualificationId;
	@Column(name="qualification")
	private String qualification;	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<UserDTO> userDTOs=new HashSet<>();
	
	
	public int getQualificationId() {
		return qualificationId;
	}
	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public Set<UserDTO> getUserDTOs() {
		return userDTOs;
	}
	public void setUserDTOs(Set<UserDTO> userDTOs) {
		this.userDTOs = userDTOs;
	}
	
	
}
