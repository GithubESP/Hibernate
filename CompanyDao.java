package tw.hibernatedemo.model;

import org.hibernate.Session;

public class CompanyDao {
	
	private Session session;
	
	//依賴注入、Dependency Injection
	public CompanyDao(Session session) {
		//上面的等於帶進來的
		this.session = session;
	}
	
	public CompanyBean insertCompany(CompanyBean cBean) {
		CompanyBean companyBean = session.get(CompanyBean.class,cBean.getCompanyId());
		if (companyBean == null) {
		session.save(cBean);
		return cBean;
	}
		return null;
	}
	
	public CompanyBean findById(Integer id) {
		return session.get(CompanyBean.class, id);
	}
	
	//session.save
	
	
	//session.delete
	
	
	//session...
	
}
