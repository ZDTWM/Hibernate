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
		//��ȡSessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//ͨ��SessionFactory ��ȡһ��Session
		Session s = sf.openSession();
		
		//��Session�Ļ����Ͽ���һ������
		s.beginTransaction();
		
		//newһ��Product����
		Product p = new Product();
		
		//���ö�������
		p.setName("iphone7");
		
		//���ü۸�
		p.setPrice(7000);
		
		//ͨ������Session��save�����Ѷ��󱣴浽���ݿ�
		s.save(p);
		
		//�ύ����
		s.getTransaction().commit();
		
		//�ر�Session
		s.close();
		
		//�ر�SessionFactory
		sf.close();
	}

}
