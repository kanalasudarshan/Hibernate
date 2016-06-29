package com.ksr.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="b_address")
public class AddressDTO {

		@Id
		@GeneratedValue
		private long addressId;
		private String address;		
		@ManyToOne(cascade=CascadeType.ALL)
		@JoinColumn(name="user_id")
		private UserDTO userDTO;		
		
	
		public UserDTO getUserDTO() {
			return userDTO;
		}
		public void setUserDTO(UserDTO userDTO) {
			this.userDTO = userDTO;
		}
		public long getAddressId() {
			return addressId;
		}
		public void setAddressId(long addressId) {
			this.addressId = addressId;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		@Override
		public String toString() {
			return "AddressDTO [addressId=" + addressId + ", address="
					+ address + "]";
		}
		
		
		
		
}
