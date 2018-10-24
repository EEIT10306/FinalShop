package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupFavorite;
import model.bean.GroupProduct;
import model.bean.Member;
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
		List<GroupFavorite> simples = getSession().createQuery("from GroupFavorite", GroupFavorite.class)
				.setMaxResults(50).list();
		System.out.println(simples);
		return simples;
	}

	@Override
	public GroupFavorite selectByPk(GroupFavorite bean) throws SQLException {
		GroupFavorite simple = getSession().get(GroupFavorite.class, bean.getId());
		System.out.println(simple);
		return simple;
	}

	@Override
	public GroupFavorite insert(GroupFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		GroupFavorite simple = getSession().get(GroupFavorite.class, bean.getId());
		// 沒有才新增
		if (simple == null) {
			// 外鍵有資料才新增
			Member simpleMember = getSession().get(Member.class, bean.getMemberId());
			GroupProduct simpleGroupProduct = getSession().get(GroupProduct.class, bean.getGroupProductId());
			if (simpleMember != null && simpleGroupProduct != null) {
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public GroupFavorite update(GroupFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		GroupFavorite simple = getSession().get(GroupFavorite.class, bean.getId());
		// 有才修改
		if (simple != null) {
			// 外鍵有資料才修改
			Member simpleMember = getSession().get(Member.class, bean.getMemberId());
			GroupProduct simpleGroupProduct = getSession().get(GroupProduct.class, bean.getGroupProductId());
			if (simpleMember != null && simpleGroupProduct != null) {
				simple.setMemberId(bean.getMemberId());
				simple.setGroupProductId(bean.getGroupProductId());
				return simple;
			}
		}
		return null;
	}

	@Override
	public boolean delete(GroupFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		GroupFavorite simple = getSession().get(GroupFavorite.class, bean.getId());
		// 有才刪除
		if (simple != null) {
			getSession().delete(simple);
			return true;
		}
		return false;
	}

}
