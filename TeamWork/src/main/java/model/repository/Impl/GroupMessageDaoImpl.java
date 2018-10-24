package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupMessage;
import model.bean.GroupProduct;
import model.bean.GroupService;
import model.bean.Member;
import model.bean.State;
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
	public GroupMessage selectByPk(GroupMessage groupMessageBean) throws SQLException {
		GroupMessage groupMessage = getSession().get(GroupMessage.class, groupMessageBean.getId());
		if (groupMessage != null) {
			return groupMessage;
		}
		return null;
	}

	@Override
	public GroupMessage insert(GroupMessage groupMessageBean) throws SQLException {
		GroupMessage message = getSession().get(GroupMessage.class, groupMessageBean.getId());
		if (message == null) {
			getSession().save(groupMessageBean);
			return groupMessageBean;
		}
		return null;
	}

	@Override
	public GroupMessage update(GroupMessage groupMessageBean) throws SQLException {
		GroupMessage groupMessage = getSession().get(GroupMessage.class, groupMessageBean.getId());
		if (groupMessage != null) {
			if (getSession().get(GroupProduct.class, groupMessageBean.getGroupProductId()) != null) {
				if (getSession().get(Member.class, groupMessageBean.getMemberId()) != null) {
					if (getSession().get(GroupService.class, groupMessageBean.getGroupServiceId()) != null) {
						if (getSession().get(State.class, groupMessageBean.getState()) != null) {
							groupMessage.setGroupProductId(groupMessageBean.getGroupProductId());
							groupMessage.setMemberId(groupMessageBean.getMemberId());
							groupMessage.setAmount(groupMessageBean.getAmount());
							groupMessage.setTime(groupMessageBean.getTime());
							groupMessage.setGroupServiceId(groupMessageBean.getGroupServiceId());
							groupMessage.setSumPrice(groupMessageBean.getSumPrice());
							groupMessage.setState(groupMessageBean.getState());
							return groupMessage;
						}
					}
				}
			}
		}
		return null;
	}
}
