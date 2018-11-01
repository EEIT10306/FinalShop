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
	public List<StoreFavorite> selectAll() throws SQLException {
		List<StoreFavorite> LSF = getSession().createQuery("from StoreFavorite", StoreFavorite.class).list();
		System.out.println(LSF);
		return LSF;
	}
	
	@Override
	public StoreFavorite selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		StoreFavorite SF = getSession().get(StoreFavorite.class, id);
		System.out.println(SF);
		return SF;
	}

	@Override
	public List<StoreFavorite> selectHql(String hqlString) throws SQLException {
		String hql = "from StoreFavorite ";
		hql += hqlString;
		List<StoreFavorite> LSF = getSession().createQuery(hql, StoreFavorite.class).list();
		System.out.println(LSF);
		return LSF;
	}

	@Override
	public StoreFavorite insert(StoreFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		StoreFavorite SF = selectByPk(bean.getsF_id());
		// 沒有才新增
		if (SF == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public boolean delete(StoreFavorite bean) throws SQLException {
		// 查詢此ID有無資料
		StoreFavorite SF = selectByPk(bean.getsF_id());
		// 有才刪除
		if (SF != null) {
			getSession().delete(SF);
			return true;
		}
		return false;
	}

}
