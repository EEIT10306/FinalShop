package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.StoreFavorite;
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
		System.out.println(getSession().createQuery("from StoreFavorite", StoreFavorite.class).setMaxResults(50).list());
		return getSession().createQuery("from StoreFavorite", StoreFavorite.class).setMaxResults(50).list();
	}

	@Override
	public StoreFavorite select(Integer id) throws SQLException {
		System.out.println(getSession().get(StoreFavorite.class, id));
		return getSession().get(StoreFavorite.class, id);
	}

	@Override
	public StoreFavorite insert(StoreFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		StoreFavorite simple = getSession().get(StoreFavorite.class, bean.getId());
		// 沒有才新增
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public StoreFavorite update(Integer id, Integer memberId, Integer storeProductId) throws SQLException {
		// 查詢此ID有無資料
		StoreFavorite simple = getSession().get(StoreFavorite.class, id);
		// 有才修改
		if (simple != null) {
			simple.setMemberId(memberId);
			simple.setStoreProductId(storeProductId);
			return simple;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		// 查詢此ID有無資料
		StoreFavorite simple = getSession().get(StoreFavorite.class, id);
		// 有才刪除
		if (simple != null) {
			getSession().delete(simple);
			return true;
		}
		return false;
	}

}
