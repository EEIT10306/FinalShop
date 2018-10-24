package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Member;
import model.bean.WishFavorite;
import model.bean.WishProduct;
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
		List<WishFavorite> simples = getSession().createQuery("from WishFavorite", WishFavorite.class).setMaxResults(50)
				.list();
		System.out.println(simples);
		return simples;
	}

	@Override
	public WishFavorite selectByPk(WishFavorite bean) throws SQLException {
		WishFavorite simple = getSession().get(WishFavorite.class, bean.getId());
		System.out.println(simple);
		return simple;
	}

	@Override
	public WishFavorite insert(WishFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		WishFavorite simple = getSession().get(WishFavorite.class, bean.getId());
		// 沒有才新增
		if (simple == null) {
			// 外鍵有資料才新增
			Member simpleMember = getSession().get(Member.class, bean.getMemberId());
			WishProduct simpleWishProduct = getSession().get(WishProduct.class, bean.getWishProductId());
			if (simpleMember != null && simpleWishProduct != null) {
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public WishFavorite update(WishFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		WishFavorite simple = getSession().get(WishFavorite.class, bean.getId());
		// 有才修改
		if (simple != null) {
			// 外鍵有資料才修改
			Member simpleMember = getSession().get(Member.class, bean.getMemberId());
			WishProduct simpleWishProduct = getSession().get(WishProduct.class, bean.getWishProductId());
			if (simpleMember != null && simpleWishProduct != null) {
				simple.setMemberId(bean.getMemberId());
				simple.setWishProductId(bean.getWishProductId());
				return simple;
			}
		}
		return null;
	}

	@Override
	public boolean delete(WishFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		WishFavorite simple = getSession().get(WishFavorite.class, bean.getId());
		// 有才刪除
		if (simple != null) {
			getSession().delete(simple);
			return true;
		}
		return false;
	}

}
