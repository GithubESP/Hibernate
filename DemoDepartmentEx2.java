package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentEx2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		Department dept2 = new Department("RD");
		session.save(dept2);
		session.getTransaction().commit();
		session.close();
		HibernateUtils.closeSessionFactory();
	}
}
