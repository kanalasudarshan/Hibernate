package com.ksr;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.ksr.dto.UserDTO;

public class SampleTestClass1 {

	public static void main(String[] args) {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();		
		Transaction tx=session.beginTransaction();

		UserDTO userDTO=new UserDTO();
		userDTO.setUserName("Sudarshan");
		userDTO.setIsActive(true);
		session.save(userDTO);
		userDTO.setUserName("Sudarshan Reddy");
		
		tx.commit();
		session.close();
	}
}
