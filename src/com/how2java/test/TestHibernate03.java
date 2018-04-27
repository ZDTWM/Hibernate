package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

public class TestHibernate03 {

	public static void main(String[] args) {
		//获取SessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//通过SessionFactory 获取一个Session
		Session s = sf.openSession();
		
		//在Session的基础上开启一个事务
		s.beginTransaction();
		
		Product p = new Product();
		p.setName("p1");
		System.out.println("此时p是瞬时状态");
		s.save(p);
		System.out.println("此时p是持久状态");
		
		//提交事务
		s.getTransaction().commit();
		
		//关闭Session
		s.close();
		
		System.out.println("此时p是托管状态");
		
		//关闭SessionFactory
		sf.close();
	}

}
