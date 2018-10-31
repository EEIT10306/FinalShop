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
		if (id == null)
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
		WishMessage WM = selectByPk(bean.getwM_id());
		if (WM == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishMessage update(WishMessage bean) throws SQLException {
		WishMessage WM = selectByPk(bean.getwM_id());
		if (WM != null) {
			if (bean.getW_id() != null)
				WM.setW_id(bean.getW_id());
			if (bean.getM_idMessage() != null)
				WM.setM_idMessage(bean.getM_idMessage());
			if (bean.getwM_context() != null)
				WM.setwM_context(bean.getwM_context());
			if (bean.getwM_time() != null)
				WM.setwM_time(bean.getwM_time());
			if (bean.getwM_stateId() != null)
				WM.setwM_stateId(bean.getwM_stateId());
			return WM;
		}
		return null;
	}
}
