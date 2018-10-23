package model.repository.Impl;

import java.sql.SQLException;
import java.util.Date;
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
		return getSession().createQuery("from GroupMessage", GroupMessage.class).setMaxResults(50).list();
	}

	@Override
	public GroupMessage select(Integer id) throws SQLException {
		return getSession().get(GroupMessage.class, id);
	}

	@Override
	public GroupMessage insert(GroupMessage groupMessage) throws SQLException {
		GroupMessage message = getSession().get(GroupMessage.class, groupMessage.getId());
		if (message == null) {
			getSession().save(groupMessage);
			return groupMessage;
		}
		return null;
	}

	@Override
	public GroupMessage update(Integer id, Integer groupProdID, Integer memberID, Integer gmAmt, Date gmTime,
			Integer gsID, Integer sumPrice, Integer gmState) throws SQLException {
		GroupMessage groupMessage = getSession().get(GroupMessage.class, id);
		if (groupMessage != null) {
			groupMessage.setId(id);
			groupMessage.setGroupProductId(groupProdID);
			groupMessage.setMemberId(memberID);
			groupMessage.setAmount(gmAmt);
			groupMessage.setTime(gmTime);
			groupMessage.setGroupServiceId(gsID);
			groupMessage.setSumPrice(sumPrice);
			groupMessage.setState(gmState);
			getSession().update(groupMessage);
			return groupMessage;
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws SQLException {
		GroupMessage groupMessage = getSession().get(GroupMessage.class, id);
		if (groupMessage != null) {
			getSession().delete(groupMessage);
			return true;
		}
		return false;
	}
}
