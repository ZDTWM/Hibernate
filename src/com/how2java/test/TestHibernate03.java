package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

public class TestHibernate03 {

	public static void main(String[] args) {
		//��ȡSessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//ͨ��SessionFactory ��ȡһ��Session
		Session s = sf.openSession();
		
		//��Session�Ļ����Ͽ���һ������
		s.beginTransaction();
		
		Product p = new Product();
		p.setName("p1");
		System.out.println("��ʱp��˲ʱ״̬");
		s.save(p);
		System.out.println("��ʱp�ǳ־�״̬");
		
		//�ύ����
		s.getTransaction().commit();
		
		//�ر�Session
		s.close();
		
		System.out.println("��ʱp���й�״̬");
		
		//�ر�SessionFactory
		sf.close();
	}

}
