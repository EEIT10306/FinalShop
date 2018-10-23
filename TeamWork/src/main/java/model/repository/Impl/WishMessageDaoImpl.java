package model.repository.Impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.DistrictType;
import model.bean.Wish;
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
		if(simple==null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishMessage update(Integer id, Integer groupProductId, Integer buyerMemberIdEE, Integer bid, String amount,
			Date time, Integer state) throws SQLException {
		WishMessage wishMessage = this.getSession().get(WishMessage.class, id);
		if (wishMessage != null) {
			wishMessage.setId(id);
			wishMessage.setGroupProductId(groupProductId);
			wishMessage.setBuyerMemberIdEE(buyerMemberIdEE);
			wishMessage.setBid(bid);
			wishMessage.setAmount(amount);
			wishMessage.setTime(time);
			wishMessage.setState(state);
			return wishMessage;
		}
		return null;
	}
}
