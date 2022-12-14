package tw.hibernatedemo.action;

import java.io.Serializable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import tw.hibernatedemo.model.Department;
import tw.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentEx5 {

	public static void main(String[] args) {
		
		
		
		SessionFactory factory = HibernateUtils.getSessionFactory(); //造工廠
		Session session = factory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction(); // 開交易
			Department dept = new Department("戰鬥部門");
			
			session.save(dept);	
			
			tx.commit();
			
		} catch (Exception e) {
			System.out.println("RollBack!!");
			tx.rollback();
			e.printStackTrace();
		}finally {
			HibernateUtils.closeSessionFactory();
		}
		
	}
}
