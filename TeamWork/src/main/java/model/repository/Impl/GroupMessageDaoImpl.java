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
		if (id != null)
			return null;
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
		GroupMessage GM = selectByPk(bean.getgM_id());
		if (GM == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupMessage update(GroupMessage bean) throws SQLException {
		GroupMessage GM = selectByPk(bean.getgM_id());
		if (GM != null) {
			if (bean.getG_id() != null)
				GM.setG_id(bean.getG_id());
			if (bean.getM_idMessage() != null)
				GM.setM_idMessage(bean.getM_idMessage());
			if (bean.getgM_context() != null)
				GM.setgM_context(bean.getgM_context());
			if (bean.getgM_time() != null)
				GM.setgM_time(bean.getgM_time());
			if (bean.getgM_stateId() != null)
				GM.setgM_stateId(bean.getgM_stateId());
			return GM;
		}
		return null;
	}
}
