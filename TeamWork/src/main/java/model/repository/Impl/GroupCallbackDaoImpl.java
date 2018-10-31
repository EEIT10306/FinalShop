package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupCallback;
import model.repository.GroupCallbackDao;

@Repository
public class GroupCallbackDaoImpl implements GroupCallbackDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<GroupCallback> selectAll() throws SQLException {
		List<GroupCallback> LGC = getSession().createQuery("from GroupCallback", GroupCallback.class).list();
		System.out.println(LGC);
		return LGC;
	}

	@Override
	public GroupCallback selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		GroupCallback GC = getSession().get(GroupCallback.class, id);
		System.out.println(GC);
		return GC;
	}

	@Override
	public List<GroupCallback> selectHql(String hqlString) throws SQLException {
		String hql = "from GroupCallback ";
		hql += hqlString;
		List<GroupCallback> LGC = getSession().createQuery(hql, GroupCallback.class).list();
		System.out.println(LGC);
		return LGC;
	}

	@Override
	public GroupCallback insert(GroupCallback bean) throws SQLException {
		GroupCallback GC = selectByPk(bean.getgC_id());
		if (GC == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupCallback update(GroupCallback bean) throws SQLException {
		GroupCallback GC = selectByPk(bean.getgC_id());
		if (GC != null) {
			if (bean.getgM_id() != null)
				GC.setgM_id(bean.getgM_id());
			if (bean.getM_idCallback() != null)
				GC.setM_idCallback(bean.getM_idCallback());
			if (bean.getgC_context() != null)
				GC.setgC_context(bean.getgC_context());
			if (bean.getgC_time() != null)
				GC.setgC_time(bean.getgC_time());
			if (bean.getgC_stateId() != null)
				GC.setgC_stateId(bean.getgC_stateId());
			return GC;
		}
		return null;
	}
}
