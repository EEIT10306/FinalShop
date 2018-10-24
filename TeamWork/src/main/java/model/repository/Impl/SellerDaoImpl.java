package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Seller;
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
		System.out.println(getSession().createQuery("from Seller", Seller.class).setMaxResults(50).list());
		return getSession().createQuery("from Seller", Seller.class).setMaxResults(50).list();
	}

	@Override
	public Seller select(Integer id) throws SQLException {
		System.out.println(getSession().get(Seller.class, id));
		return getSession().get(Seller.class, id);
	}

	@Override
	public Seller insert(Seller bean) throws SQLException {
		// 查詢此ID有無資料
		Seller simple = getSession().get(Seller.class, bean.getId());
		// 沒有才新增
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Seller update(Integer id, Integer memberId, String idCard, String mailVerification, Integer state) throws SQLException {
		// 查詢此ID有無資料
		Seller simple = getSession().get(Seller.class, id);
		// 有才修改
		if (simple != null) {
			simple.setMemberId(memberId);
			simple.setIdCard(idCard);
			simple.setMailVerification(mailVerification);
			simple.setState(state);
			return simple;
		}
		return null;
	}

}
