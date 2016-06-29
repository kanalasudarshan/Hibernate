package com.ksr;

import java.util.List;

import javax.persistence.criteria.Predicate;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ksr.dto.AddressDTO;
import com.ksr.dto.ContractEmployeeDTO;
import com.ksr.dto.EmployeeDTO;
import com.ksr.dto.GendarDTO;
import com.ksr.dto.RegularEmployeeDTO;
import com.ksr.dto.UserDTO;

public class MainApp {

	public static void main(String... args){
		
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();		
		Transaction tx=session.beginTransaction();
		
		Criteria cr=session.createCriteria(UserDTO.class);
		cr.add(Restrictions.eq("userId", 1L));
		cr.add(Restrictions.gt("userId", 0L));
		cr.add(Restrictions.like("userName", "sudarshan"));
		cr.add(Restrictions.in("userId",new Long[]{1L,2L,3L}));
		
		Criterion userId_1=Restrictions.eq("userId", 1L);
		Criterion userId_2=Restrictions.gt("userId", 0L);
		cr.add(Restrictions.or(userId_1,userId_2));
		List<UserDTO> list=cr.list();
		
		System.out.println(list);
		/*UserDTO userDTO=new UserDTO();		
		userDTO.setUserName("sudarshan");		
		
		AddressDTO adto1=new AddressDTO();
		adto1.setAddress("A");
		adto1.setUserDTO(userDTO);		
		userDTO.getAddress().add(adto1);
		

		AddressDTO adto2=new AddressDTO();
		adto2.setAddress("B");		
		adto2.setUserDTO(userDTO);
		userDTO.getAddress().add(adto2);
		
		GendarDTO gdto=new GendarDTO();
		gdto.setGendar("Male");
		
		userDTO.getGendar().add(gdto);
		
		session.save(userDTO);*/
		
		//tx.commit();
		
		/*UserDTO userDTO=new UserDTO();		
		userDTO.setUserName("sudarshan");	
		userDTO=(UserDTO)session.get(UserDTO.class,1L);
		
		System.out.println(userDTO);*/
		
		/*
		EmployeeDTO edto=new EmployeeDTO();
		edto.setEmployeeName("sudahrsa");
		session.save(edto);
		
		RegularEmployeeDTO redto=new RegularEmployeeDTO();
		redto.setEmployeeName("A");
		redto.setSalary(1000f);
		redto.setBonus(300);
		session.save(redto);
		
		ContractEmployeeDTO cedto=new ContractEmployeeDTO();
		cedto.setEmployeeName("B");
		cedto.setContractPeriod(4);
		cedto.setPayPerHour(8);
		session.save(cedto);*/
		
		tx.commit();
		session.close();
		
	}
}
