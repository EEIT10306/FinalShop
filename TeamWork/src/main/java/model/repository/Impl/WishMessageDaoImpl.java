package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupProduct;
import model.bean.Member;
import model.bean.State;
import model.bean.WishMessage;
import model.repository.WishMessageDao;

@Repository
public class WishMessageDaoImpl implements WishMessageDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishMessage> select() throws SQLException {
		return getSession().createQuery("from WishMessage", WishMessage.class).setMaxResults(50).list();

	}

	@Override
	public WishMessage select(Integer id) throws SQLException {
		return getSession().get(WishMessage.class, id);
	}

	@Override
	public WishMessage insert(WishMessage bean) throws SQLException {
		WishMessage simple = getSession().get(WishMessage.class, bean.getId());
		if (simple == null) {
			GroupProduct group = getSession().get(GroupProduct.class, bean.getId());
			Member memb = getSession().get(Member.class, bean.getId());
			State sta = getSession().get(State.class, bean.getState());
			if (group != null && memb != null && sta != null) {
				getSession().save(bean);
				return bean;
			}
			return null;
		}
		return null;
	}

	@Override
	public WishMessage update(WishMessage bean) throws SQLException {
		WishMessage wishMessage = this.getSession().get(WishMessage.class,bean.getId());
		if (wishMessage != null) {
			GroupProduct group = getSession().get(GroupProduct.class, bean.getId());
			Member memb = getSession().get(Member.class, bean.getId());
			State sta = getSession().get(State.class, bean.getState());
			if (group != null && memb != null && sta != null) {			
				wishMessage.setGroupProductId(bean.getGroupProductId());
				wishMessage.setBuyerMemberIdEE(bean.getBuyerMemberIdEE());
				wishMessage.setBid(bean.getBid());
				wishMessage.setAmount(bean.getAmount());
				wishMessage.setTime(bean.getTime());
				wishMessage.setState(bean.getState());
				return wishMessage;
			}
			return null;
		}
		return null;
	}
}
