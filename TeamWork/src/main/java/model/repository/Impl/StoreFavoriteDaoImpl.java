package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Member;
import model.bean.StoreFavorite;
import model.bean.StoreProduct;
import model.repository.StoreFavoriteDao;

@Repository
public class StoreFavoriteDaoImpl implements StoreFavoriteDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<StoreFavorite> select() throws SQLException {
		List<StoreFavorite> simples = getSession().createQuery("from StoreFavorite", StoreFavorite.class)
				.setMaxResults(50).list();
		System.out.println(simples);
		return simples;
	}

	@Override
	public StoreFavorite selectByPk(StoreFavorite bean) throws SQLException {
		StoreFavorite simple = getSession().get(StoreFavorite.class, bean.getId());
		System.out.println(simple);
		return simple;
	}

	@Override
	public StoreFavorite insert(StoreFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		StoreFavorite simple = getSession().get(StoreFavorite.class, bean.getId());
		// 沒有才新增
		if (simple == null) {
			// 外鍵有資料才新增
			Member simpleMember = getSession().get(Member.class, bean.getMemberId());
			StoreProduct simpleStoreProduct = getSession().get(StoreProduct.class, bean.getStoreProductId());
			if (simpleMember != null && simpleStoreProduct != null) {
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public StoreFavorite update(StoreFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		StoreFavorite simple = getSession().get(StoreFavorite.class, bean.getId());
		// 有才修改
		if (simple != null) {
			// 外鍵有資料才修改
			Member simpleMember = getSession().get(Member.class, bean.getMemberId());
			StoreProduct simpleStoreProduct = getSession().get(StoreProduct.class, bean.getStoreProductId());
			if (simpleMember != null && simpleStoreProduct != null) {
				simple.setMemberId(bean.getMemberId());
				simple.setStoreProductId(bean.getStoreProductId());
				return simple;
			}
		}
		return null;
	}

	@Override
	public boolean delete(StoreFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		StoreFavorite simple = getSession().get(StoreFavorite.class, bean.getId());
		// 有才刪除
		if (simple != null) {
			getSession().delete(simple);
			return true;
		}
		return false;
	}

}
