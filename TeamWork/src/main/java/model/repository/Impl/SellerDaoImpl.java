package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Member;
import model.bean.Seller;
import model.bean.State;
import model.repository.SellerDao;

@Repository
public class SellerDaoImpl implements SellerDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Seller> select() throws SQLException {
		List<Seller> simples = getSession().createQuery("from Seller", Seller.class).setMaxResults(50).list();
		System.out.println(simples);
		return simples;
	}

	@Override
	public Seller selectByPk(Seller bean) throws SQLException {
		System.out.println(getSession().get(Seller.class, bean.getId()));
		return getSession().get(Seller.class, bean.getId());
	}

	@Override
	public Seller insert(Seller bean) throws SQLException {
		// 查詢此ID有無資料
		Seller simple = getSession().get(Seller.class, bean.getId());
		// 沒有才新增
		if (simple == null) {
			// 外鍵有資料才新增
			State simpleState = getSession().get(State.class, bean.getState());
			Member simpleMember = getSession().get(Member.class, bean.getMemberId());
			if (simpleState != null && simpleMember != null) {
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public Seller update(Seller bean) throws SQLException {
		// 查詢此ID有無資料
		Seller simple = getSession().get(Seller.class, bean.getId());
		// 有才修改
		if (simple != null) {
			// 外鍵有資料才修改
			State simpleState = getSession().get(State.class, bean.getState());
			Member simpleMember = getSession().get(Member.class, bean.getMemberId());
			if (simpleState != null && simpleMember != null) {
				simple.setMemberId(bean.getMemberId());
				simple.setIdCard(bean.getIdCard());
				simple.setMailVerification(bean.getMailVerification());
				simple.setState(bean.getState());
				return simple;
			}
		}
		return null;
	}

}
