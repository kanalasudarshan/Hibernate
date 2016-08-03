package com.ksr;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.ksr.dto.AddressDTO;
import com.ksr.dto.GendarDTO;
import com.ksr.dto.QualificationDTO;
import com.ksr.dto.UserDTO;

public class SampleTestClass2 {

	public static void main(String[] args) {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();		
		Transaction tx=session.beginTransaction();

		UserDTO userDTO=new UserDTO();
		userDTO.setUserName("Sudarshan");
		userDTO.setIsActive(true);
		
		//UserDTO : one to many
		//AddressDTO : one to many
		AddressDTO addressDTO=new AddressDTO();
		addressDTO.setAddress("Jammalamadugu");
		addressDTO.setUserDTO(userDTO);
		userDTO.getAddress().add(addressDTO);
		
		//UserDTO : Many to one
		//GendarDTO :One to many
		GendarDTO gendarDTO=new GendarDTO();
		gendarDTO.setGendar("Male");
		gendarDTO.getUserDTOs().add(userDTO);
		userDTO.setGendarDTO(gendarDTO);
		
		//UserDTO : Many to Many
		//GendarDTO :Many to many
		QualificationDTO qualification_1=new QualificationDTO();
		qualification_1.setQualification("MCA");
		qualification_1.getUserDTOs().add(userDTO);
		userDTO.getQualifications().add(qualification_1);
		
		QualificationDTO qualification_2=new QualificationDTO();
		qualification_2.setQualification("BSC");
		userDTO.getQualifications().add(qualification_2);
		qualification_2.getUserDTOs().add(userDTO);
		
		session.save(userDTO);
		
		
		tx.commit();
		session.close();
	}

}
