package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

public class TestHibernate01 {
	/**
	 * Hello Hibernate
	 * @param args
	 */
	public static void main(String[] args) {
		//获取SessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//通过SessionFactory 获取一个Session
		Session s = sf.openSession();
		
		//在Session的基础上开启一个事务
		s.beginTransaction();
		
		//new一个Product对象
		Product p = new Product();
		
		//设置对象名称
		p.setName("iphone7");
		
		//设置价格
		p.setPrice(7000);
		
		//通过调用Session的save方法把对象保存到数据库
		s.save(p);
		
		//提交事务
		s.getTransaction().commit();
		
		//关闭Session
		s.close();
		
		//关闭SessionFactory
		sf.close();
	}

}
