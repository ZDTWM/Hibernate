package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

public class TestHibernate04 {
	/**
	 * 获取
	 * @param args
	 */
	public static void main(String[] args) {
		//获取SessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//通过SessionFactory 获取一个Session
		Session s = sf.openSession();
		
		//在Session的基础上开启一个事务
		s.beginTransaction();
		
		Product p = (Product) s.get(Product.class, 6);
		System.out.println("id=6的产品名称是：" + p.getName());
		
		//提交事务
		s.getTransaction().commit();
		
		//关闭Session
		s.close();
		
		//关闭SessionFactory
		sf.close();
	}

}
