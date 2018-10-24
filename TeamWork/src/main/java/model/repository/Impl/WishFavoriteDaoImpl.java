package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.WishFavorite;
import model.repository.WishFavoriteDao;

@Repository
public class WishFavoriteDaoImpl implements WishFavoriteDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<WishFavorite> select() throws SQLException {
		System.out.println(getSession().createQuery("from WishFavorite", WishFavorite.class).setMaxResults(50).list());
		return getSession().createQuery("from WishFavorite", WishFavorite.class).setMaxResults(50).list();
	}

	@Override
	public WishFavorite select(Integer id) throws SQLException {
		System.out.println(getSession().get(WishFavorite.class, id));
		return getSession().get(WishFavorite.class, id);
	}

	@Override
	public WishFavorite insert(WishFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		WishFavorite simple = getSession().get(WishFavorite.class, bean.getId());
		// 沒有才新增
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public WishFavorite update(Integer id, Integer memberId, Integer wishProductId) throws SQLException {
		// 查詢此ID有無資料
		WishFavorite simple = getSession().get(WishFavorite.class, id);
		// 有才修改
		if (simple != null) {
			simple.setMemberId(memberId);
			simple.setWishProductId(wishProductId);
			return simple;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		// 查詢此ID有無資料
		WishFavorite simple = getSession().get(WishFavorite.class, id);
		// 有才刪除
		if (simple != null) {
			getSession().delete(simple);
			return true;
		}
		return false;
	}

}
