package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	public List<WishMessage> selectAll() throws SQLException {
		List<WishMessage> LWM = getSession().createQuery("from WishMessage", WishMessage.class).list();
		System.out.println(LWM);
		return LWM;
	}

	@Override
	public WishMessage selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		WishMessage WM = getSession().get(WishMessage.class, id);
		System.out.println(WM);
		return WM;
	}

	@Override
	public List<WishMessage> selectHql(String hqlString) throws SQLException {
		String hql = "from WishMessage ";
		hql += hqlString;
		List<WishMessage> LWM = getSession().createQuery(hql, WishMessage.class).list();
		System.out.println(LWM);
		return LWM;
	}

	@Override
	public WishMessage insert(WishMessage bean) throws SQLException {
		WishMessage WM = selectByPk(bean.getId());
		if (WM == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishMessage update(WishMessage bean) throws SQLException {
		WishMessage WM = selectByPk(bean.getId());
		if (WM != null) {
			if (bean.getWishId() != null)
				WM.setWishId(bean.getWishId());
			if (bean.getMemberId() != null)
				WM.setMemberId(bean.getMemberId());
			if (bean.getContext() != null)
				WM.setContext(bean.getContext());
			if (bean.getTime() != null)
				WM.setTime(bean.getTime());
			if (bean.getStateId() != null)
				WM.setStateId(bean.getStateId());
			return WM;
		}
		return null;
	}
}
