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
		if (id != null)
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
		GroupCallback GC = selectByPk(bean.getId());
		if (GC == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupCallback update(GroupCallback bean) throws SQLException {
		GroupCallback GC = selectByPk(bean.getId());
		if (GC != null) {
			if (bean.getGroupMessageId() != null)
				GC.setGroupMessageId(bean.getGroupMessageId());
			if (bean.getMemberId() != null)
				GC.setMemberId(bean.getMemberId());
			if (bean.getContext() != null)
				GC.setContext(bean.getContext());
			if (bean.getTime() != null)
				GC.setTime(bean.getTime());
			if (bean.getStateId() != null)
				GC.setStateId(bean.getStateId());
			return GC;
		}
		return null;
	}
}
