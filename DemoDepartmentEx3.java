package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentEx3 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory(); //造工廠
		Session session = factory.openSession(); // 開session
		session.beginTransaction(); // 開交易
		Department dept = new Department("Sells"); // 創部門
		
		Serializable id = session.save(dept);
		
		System.out.println("id:"+id);
		
		session.getTransaction().commit();
		session.close();
		HibernateUtils.closeSessionFactory();
	}
}
