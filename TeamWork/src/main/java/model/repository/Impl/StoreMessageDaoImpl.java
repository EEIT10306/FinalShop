package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StoreMessage;
import model.repository.StoreMessageDao;

@Repository
public class StoreMessageDaoImpl implements StoreMessageDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<StoreMessage> selectAll() throws SQLException {
		List<StoreMessage> LSM = getSession().createQuery("from StoreMessage", StoreMessage.class).list();
		System.out.println(LSM);
		return LSM;
	}

	@Override
	public StoreMessage selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		StoreMessage SM = getSession().get(StoreMessage.class, id);
		System.out.println(SM);
		return SM;
	}

	@Override
	public List<StoreMessage> selectHql(String hqlString) throws SQLException {
		String hql = "from StoreMessage ";
		hql += hqlString;
		List<StoreMessage> LSM = getSession().createQuery(hql, StoreMessage.class).list();
		System.out.println(LSM);
		return LSM;
	}

	@Override
	public StoreMessage insert(StoreMessage bean) throws SQLException {
		StoreMessage SM = selectByPk(bean.getsM_id());
		if (SM == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreMessage update(StoreMessage bean) throws SQLException {
		StoreMessage SM = selectByPk(bean.getsM_id());
		if (SM != null) {
			if (bean.getsP_id() != null)
				SM.setsP_id(bean.getsP_id());
			if (bean.getM_idMessage() != null)
				SM.setM_idMessage(bean.getM_idMessage());
			if (bean.getsM_context() != null)
				SM.setsM_context(bean.getsM_context());
			if (bean.getsM_time() != null)
				SM.setsM_time(bean.getsM_time());
			if (bean.getsM_stateId() != null)
				SM.setsM_stateId(bean.getsM_stateId());
			return SM;
		}
		return null;
	}

	public StoreMessage update(StoreMessage SM, StoreMessage bean) throws SQLException {
		if (bean.getsP_id() != null)
			SM.setsP_id(bean.getsP_id());
		if (bean.getM_idMessage() != null)
			SM.setM_idMessage(bean.getM_idMessage());
		if (bean.getsM_context() != null)
			SM.setsM_context(bean.getsM_context());
		if (bean.getsM_time() != null)
			SM.setsM_time(bean.getsM_time());
		if (bean.getsM_stateId() != null)
			SM.setsM_stateId(bean.getsM_stateId());
		return SM;
	}
}
