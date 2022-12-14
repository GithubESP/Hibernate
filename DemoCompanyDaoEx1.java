package tw.hibernatedemo.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.model.CompanyDao;
import tw.hibernatedemo.util.HibernateUtils;

public class DemoCompanyDaoEx1 {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			CompanyDao dao = new CompanyDao(session);
			CompanyBean com1 = new CompanyBean();
			com1.setCompanyId(1003);
			com1.setCompanyName("運動彩券");
			
			dao.insertCompany(com1);
///回家試試	dao.findById();
			
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
		}finally {
			HibernateUtils.closeSessionFactory();
		}
	}

}
