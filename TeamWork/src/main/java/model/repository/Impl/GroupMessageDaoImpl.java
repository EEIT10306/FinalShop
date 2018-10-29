package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupMessage;
import model.repository.GroupMessageDao;

@Repository
public class GroupMessageDaoImpl implements GroupMessageDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<GroupMessage> selectAll() throws SQLException {
		List<GroupMessage> LGM = getSession().createQuery("from GroupMessage", GroupMessage.class).list();
		System.out.println(LGM);
		return LGM;
	}

	@Override
	public GroupMessage selectByPk(Integer id) throws SQLException {
		GroupMessage GM = getSession().get(GroupMessage.class, id);
		System.out.println(GM);
		return GM;
	}

	@Override
	public List<GroupMessage> selectHql(String hqlString) throws SQLException {
		String hql = "from GroupMessage ";
		hql += hqlString;
		List<GroupMessage> LGM = getSession().createQuery(hql, GroupMessage.class).list();
		System.out.println(LGM);
		return LGM;
	}

	@Override
	public GroupMessage insert(GroupMessage bean) throws SQLException {
		GroupMessage GM = selectByPk(bean.getId());
		if (GM == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupMessage update(GroupMessage bean) throws SQLException {
		GroupMessage GM = selectByPk(bean.getId());
		if (GM != null) {
			if (bean.getGroupId() != null)
				GM.setGroupId(bean.getGroupId());
			if (bean.getMemberId() != null)
				GM.setMemberId(bean.getMemberId());
			if (bean.getContext() != null)
				GM.setContext(bean.getContext());
			if (bean.getTime() != null)
				GM.setTime(bean.getTime());
			if (bean.getStateId() != null)
				GM.setStateId(bean.getStateId());
			return GM;
		}
		return null;
	}
}
