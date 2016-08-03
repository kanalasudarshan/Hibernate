package com.ksr.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="b_gendar")
public class GendarDTO {

	@Id @GeneratedValue
	@Column(name="gendar_id")
	private long  gendarId;
	@Column(name="gendar_type")
	private String gendar;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="gendarDTO")	
	private Set<UserDTO> userDTOs=new HashSet<>();
	
	
	
	public Set<UserDTO> getUserDTOs() {
		return userDTOs;
	}
	public void setUserDTOs(Set<UserDTO> userDTOs) {
		this.userDTOs = userDTOs;
	}
	public long getGendarId() {
		return gendarId;
	}
	public void setGendarId(long gendarId) {
		this.gendarId = gendarId;
	}
	public String getGendar() {
		return gendar;
	}
	public void setGendar(String gendar) {
		this.gendar = gendar;
	}
	@Override
	public String toString() {
		return "GendarDTO [gendarId=" + gendarId + ", gendar=" + gendar + "]";
	}
		
	
	
	
}
