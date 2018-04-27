package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

public class TestHibernate02 {

	public static void main(String[] args) {
		//获取SessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//通过SessionFactory 获取一个Session
		Session s = sf.openSession();
		
		//在Session的基础上开启一个事务
		s.beginTransaction();
		
		for (int i = 0; i < 10; i++) {
			Product p = new Product();
			p.setName("iphone" + i);
			p.setPrice(i * 1000);
			s.save(p);
		}
		
		
		//提交事务
		s.getTransaction().commit();
		
		//关闭Session
		s.close();
		
		//关闭SessionFactory
		sf.close();
	}

}
