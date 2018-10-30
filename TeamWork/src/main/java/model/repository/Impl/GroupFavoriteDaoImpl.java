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
	public List<GroupFavorite> selectAll() throws SQLException {
		List<GroupFavorite> LGF = getSession().createQuery("from GroupFavorite", GroupFavorite.class).list();
		System.out.println(LGF);
		return LGF;
	}

	@Override
	public GroupFavorite selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		GroupFavorite GF = getSession().get(GroupFavorite.class, id);
		System.out.println(GF);
		return GF;
	}

	@Override
	public List<GroupFavorite> selectHql(String hqlString) throws SQLException {
		String hql = "from GroupFavorite ";
		hql += hqlString;
		List<GroupFavorite> LGF = getSession().createQuery(hql, GroupFavorite.class).list();
		System.out.println(LGF);
		return LGF;
	}

	@Override
	public GroupFavorite insert(GroupFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		GroupFavorite GF = selectByPk(bean.getId());
		// 沒有才新增
		if (GF == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean delete(GroupFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		GroupFavorite GF = selectByPk(bean.getId());
		// 有才刪除
		if (GF != null) {
			getSession().delete(GF);
			return true;
		}
		return false;
	}

}
