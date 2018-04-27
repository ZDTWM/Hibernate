package com.how2java.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

public class TestHibernate04 {
	/**
	 * ��ȡ
	 * @param args
	 */
	public static void main(String[] args) {
		//��ȡSessionFactory
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		
		//ͨ��SessionFactory ��ȡһ��Session
		Session s = sf.openSession();
		
		//��Session�Ļ����Ͽ���һ������
		s.beginTransaction();
		
		Product p = (Product) s.get(Product.class, 6);
		System.out.println("id=6�Ĳ�Ʒ�����ǣ�" + p.getName());
		
		//�ύ����
		s.getTransaction().commit();
		
		//�ر�Session
		s.close();
		
		//�ر�SessionFactory
		sf.close();
	}

}
