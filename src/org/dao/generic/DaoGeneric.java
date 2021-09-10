package org.dao.generic;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.modelo.ciudad.Ciudad;

public class DaoGeneric {
	
	@SuppressWarnings("unchecked")
	public List<Ciudad> listCiudad(){
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.getCurrentSession();
		List<Ciudad> list = null;
		try {
			session.beginTransaction();
			list = (List<Ciudad>) session.createQuery("from Ciudad").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
			session.getTransaction().rollback();
		}
		return list;
	}
}