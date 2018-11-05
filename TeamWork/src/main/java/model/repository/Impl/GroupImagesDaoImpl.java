package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupImages;
import model.repository.GroupImagesDao;

@Repository
public class GroupImagesDaoImpl implements GroupImagesDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<GroupImages> selectAll() throws SQLException {
		List<GroupImages> GI = getSession().createQuery("from GroupImages", GroupImages.class).list();
		System.out.println(GI);
		return GI;
	}

	@Override
	public GroupImages selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		GroupImages GI = getSession().get(GroupImages.class, id);
		System.out.println(GI);
		return GI;
	}

	@Override
	public List<GroupImages> selectHql(String hqlString) throws SQLException {
		String hql = "from GroupImages ";
		hql += hqlString;
		List<GroupImages> LGI = getSession().createQuery(hql, GroupImages.class).list();
		System.out.println(LGI);
		return LGI;
	}

	@Override
	public GroupImages insert(GroupImages bean) throws SQLException {
		GroupImages GI = selectByPk(bean.getgI_id());
		if (GI == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupImages update(GroupImages bean) throws SQLException {
		GroupImages GI = selectByPk(bean.getgI_id());
		if (GI != null) {
			if (bean.getgP_id() != null)
				GI.setgP_id(bean.getgP_id());
			if (bean.getgI_context() != null)
				GI.setgI_context(bean.getgI_context());
			return GI;
		}
		return null;
	}

	public GroupImages update(GroupImages GI, GroupImages bean) throws SQLException {
		if (bean.getgP_id() != null)
			GI.setgP_id(bean.getgP_id());
		if (bean.getgI_context() != null)
			GI.setgI_context(bean.getgI_context());
		return GI;
	}

	@Override
	public Boolean delete(GroupImages bean) throws SQLException {
		GroupImages GI = selectByPk(bean.getgI_id());
		if (GI != null) {
			getSession().delete(GI);
			return true;
		}
		return false;
	}
}
