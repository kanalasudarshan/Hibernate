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
	@OneToMany(cascade=CascadeType.ALL,mappedBy="userDTO")	
	private Set<AddressDTO> address=new HashSet<AddressDTO>(); 	
	@ManyToMany(cascade=CascadeType.ALL)	
	@JoinTable(name = "j_user_gendar", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "gendar_id") })	
	private Set<GendarDTO> gendar=new HashSet<>();
	
	
	
	
	
	public Set<GendarDTO> getGendar() {
		return gendar;
	}
	public void setGendar(Set<GendarDTO> gendar) {
		this.gendar = gendar;
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
				+ ", address=" + address + ", gendar=" + gendar + "]";
	}
	
	
	

}
