package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.util.HibernateUtils;

public class DemoCompanyBeanEx2 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			// get要給2個參數，一個資料型別,一個id (get進入永續狀態)
			CompanyBean com1 = session.get(CompanyBean.class, 1001);
			System.out.println("id:"+com1.getCompanyId());
			System.out.println("Company Name:"+com1.getCompanyName());
			
			//公司名改成 Alphabet (永續狀態下直接set)
			com1.setCompanyName("Alphabet");
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSessionFactory();
		}
	}

}
