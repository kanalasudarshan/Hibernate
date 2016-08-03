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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="b_user")
public class UserDTO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private long userId;
	private String userName;	
	private boolean isActive;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="userDTO")	
	private Set<AddressDTO> address=new HashSet<AddressDTO>(); 	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="gendar_id")
	private GendarDTO gendarDTO;	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name = "j_user_qualification", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "qualification_id") })
	private Set<QualificationDTO> qualifications=new HashSet<>();
	
	
	public Set<QualificationDTO> getQualifications() {
		return qualifications;
	}
	public void setQualifications(Set<QualificationDTO> qualifications) {
		this.qualifications = qualifications;
	}
	public GendarDTO getGendarDTO() {
		return gendarDTO;
	}
	public void setGendarDTO(GendarDTO gendarDTO) {
		this.gendarDTO = gendarDTO;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	public Set<AddressDTO> getAddress() {
		return address;
	}	
	public void setAddress(Set<AddressDTO> address) {
		this.address = address;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userName=" + userName
				+ ", address=" + address + ", gendar=" + gendarDTO + "]";
	}
	
	
	

}
