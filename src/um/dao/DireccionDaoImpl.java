package um.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import um.pojo.Admin;
import um.pojo.Direccion;

@Transactional
@Repository
public class DireccionDaoImpl implements DireccionDao{

	@Autowired
	private SessionFactory sessionFactory;

	// me retorna la sesion hibernate, invoca al get
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void save(Direccion direccion) {
		getSession().save(direccion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Direccion> findAll(Admin admin) {
		@SuppressWarnings("deprecation")
		Criteria crit = getSession().createCriteria(Direccion.class)
						.setFetchMode("admin", FetchMode.JOIN)
						.add(Restrictions.eq("admin.idAd", admin.getIdAd()))
						.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		return crit.list();
	}
			//todo eso es como si escribiera select * from springbd.Direccion natural join Admin where Direccion.idAd = Admin.idAd and Admin.idAd = 1 
}
