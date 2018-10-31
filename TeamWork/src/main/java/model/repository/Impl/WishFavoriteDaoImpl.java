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
	public List<WishFavorite> selectAll() throws SQLException {
		List<WishFavorite> LWF = getSession().createQuery("from WishFavorite", WishFavorite.class).list();
		System.out.println(LWF);
		return LWF;
	}

	@Override
	public WishFavorite selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		WishFavorite WF = getSession().get(WishFavorite.class, id);
		System.out.println(WF);
		return WF;
	}

	@Override
	public List<WishFavorite> selectHql(String hqlString) throws SQLException {
		String hql = "from WishFavorite ";
		hql += hqlString;
		List<WishFavorite> LWF = getSession().createQuery(hql, WishFavorite.class).list();
		System.out.println(LWF);
		return LWF;
	}

	@Override
	public WishFavorite insert(WishFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		WishFavorite WF = selectByPk(bean.getwF_id());
		// 沒有才新增
		if (WF == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean delete(WishFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		WishFavorite WF = selectByPk(bean.getwF_id());
		// 有才刪除
		if (WF != null) {
			getSession().delete(WF);
			return true;
		}
		return false;
	}

}
