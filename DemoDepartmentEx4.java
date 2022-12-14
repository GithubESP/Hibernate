package tw.hibernatedemo.action;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.util.HibernateUtils;

public class DemoDepartmentEx4 {

	public static void main(String[] args) {
		
		SessionFactory factory = HibernateUtils.getSessionFactory(); //造工廠
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction(); // 開交易
			CompanyBean com1 = new CompanyBean();
			com1.setCompanyId(1002);
			com1.setCompanyName("FTX");
			
			Serializable id = session.save(com1);
			
			System.out.println("id:"+id);
			
			session.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("出事了，阿伯。");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			HibernateUtils.closeSessionFactory();
		}
		
//		Department dept = new Department("Sells"); // 創部門
//		
//		Serializable id = session.save(dept);
//		
//		System.out.println("id:"+id);
//		
//		session.getTransaction().commit();
//		session.close();
//		HibernateUtils.closeSessionFactory();
	}
}
