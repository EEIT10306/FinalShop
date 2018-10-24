package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupFavorite;
import model.repository.GroupFavoriteDao;

@Repository
public class GroupFavoriteDaoImpl implements GroupFavoriteDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<GroupFavorite> select() throws SQLException {
		System.out.println(getSession().createQuery("from GroupFavorite", GroupFavorite.class).setMaxResults(50).list());
		return getSession().createQuery("from GroupFavorite", GroupFavorite.class).setMaxResults(50).list();
	}

	@Override
	public GroupFavorite select(Integer id) throws SQLException {
		System.out.println(getSession().get(GroupFavorite.class, id));
		return getSession().get(GroupFavorite.class, id);
	}

	@Override
	public GroupFavorite insert(GroupFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		GroupFavorite simple = getSession().get(GroupFavorite.class, bean.getId());
		// 沒有才新增
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupFavorite update(Integer id, Integer memberId, Integer groupProductId) throws SQLException {
		// 查詢此ID有無資料
		GroupFavorite simple = getSession().get(GroupFavorite.class, id);
		// 有才修改
		if (simple != null) {
			simple.setMemberId(memberId);
			simple.setGroupProductId(groupProductId);
			return simple;
		}
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		// 查詢此ID有無資料
		GroupFavorite simple = getSession().get(GroupFavorite.class, id);
		// 有才刪除
		if (simple != null) {
			getSession().delete(simple);
			return true;
		}
		return false;
	}

}
