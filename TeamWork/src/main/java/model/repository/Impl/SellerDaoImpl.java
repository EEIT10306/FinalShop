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
	public List<Seller> selectAll() throws SQLException {
		List<Seller> LS = getSession().createQuery("from Seller", Seller.class).list();
		System.out.println(LS);
		return LS;
	}

	@Override
	public Seller selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		Seller S = getSession().get(Seller.class, id);
		System.out.println(S);
		return S;
	}

	@Override
	public List<Seller> selectHql(String hqlString) throws SQLException {
		String hql = "from Seller ";
		hql += hqlString;
		List<Seller> LS = getSession().createQuery(hql, Seller.class).list();
		System.out.println(LS);
		return LS;
	}

	@Override
	public Seller insert(Seller bean) throws SQLException {
		// 查詢此ID有無資料
		Seller S = selectByPk(bean.getId());
		// 沒有才新增
		if (S == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Seller update(Seller bean) throws SQLException {
		// 查詢此ID有無資料
		Seller S = selectByPk(bean.getId());
		// 有才修改
		if (S != null) {
			S.setMemberId(bean.getMemberId());
			S.setBank(bean.getBank());
			S.setCard(bean.getCard());
			S.setStateId(bean.getStateId());
			return S;
		}
		return null;
	}

}
