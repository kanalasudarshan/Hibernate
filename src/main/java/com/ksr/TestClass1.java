package com.ksr;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ksr.dto.RegularEmployeeDTO;

public class TestClass1 {

	public static void main(String[] args) {
		SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sf.openSession();		
		Transaction tx=session.beginTransaction();
		
		RegularEmployeeDTO rdto=new RegularEmployeeDTO();
		rdto.setEmployeeName("sudarshan reddy");
		rdto.setBonus(10);
		rdto.setSalary(1000f);
		
		session.save(rdto);
		
		Criteria cr=session.createCriteria(RegularEmployeeDTO.class);
		cr.add(Restrictions.like("employeeName", "suda%"));
		cr.addOrder(Order.desc("employeeId"));
		cr.setProjection(Projections.groupProperty("employeeName"));
		
		List<RegularEmployeeDTO> list=cr.list();
		Iterator<RegularEmployeeDTO> it=list.iterator();
		while(it.hasNext()){
			RegularEmployeeDTO dto=it.next();
			System.out.println(dto.getEmployeeId()+" "+dto.getEmployeeName());
		}
		tx.commit();
		session.close();
	}
}
