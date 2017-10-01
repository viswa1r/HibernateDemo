package com.javaTest.rambabu.service;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.javaTest.rambabu.model.Address;
import com.javaTest.rambabu.model.UserDetails;

public class UserServiceApp {
	/* Committing Branch changes */
	public static void main(String[] args) {
		
		UserDetails userDetails = new UserDetails();
		userDetails.setUserName("First User");
		userDetails.setAddress("First user address");
		userDetails.setDescription("First User details");
		userDetails.setJoinedDate(new Date());
		
/*		UserDetails userDetails1 = new UserDetails();
		userDetails1.setUserName("second User");
		userDetails1.setAddress("second user address");
		userDetails1.setDescription("second User details");
		userDetails1.setJoinedDate(new Date());*/
		
//		Address homeAdress = new Address("Plano","Texas","75024","USA");
//		userDetails.setHomeAddress(homeAdress);
//		
//		Address officeAdress = new Address("frisco","Texas","75050","USA");
//		userDetails.setOfficeAddress(officeAdress);
		
		userDetails.getListofAddress().add(new Address("first city","first state","546907","USA"));
		userDetails.getListofAddress().add(new Address("second city","second state","750343","USA"));
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(userDetails);
		//session.save(userDetails1);
		session.getTransaction().commit();
		session.close();
		
		userDetails =null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		userDetails = (UserDetails) session.get(UserDetails.class, 1);
		
		session.close();
		
		System.out.println(userDetails.toString());
	}
}
