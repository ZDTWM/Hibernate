package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

public class TestHibernate02 {

	public static void main(String[] args) {
		//��ȡSessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//ͨ��SessionFactory ��ȡһ��Session
		Session s = sf.openSession();
		
		//��Session�Ļ����Ͽ���һ������
		s.beginTransaction();
		
		for (int i = 0; i < 10; i++) {
			Product p = new Product();
			p.setName("iphone" + i);
			p.setPrice(i * 1000);
			s.save(p);
		}
		
		
		//�ύ����
		s.getTransaction().commit();
		
		//�ر�Session
		s.close();
		
		//�ر�SessionFactory
		sf.close();
	}

}
