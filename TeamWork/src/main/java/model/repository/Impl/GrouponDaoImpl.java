package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Groupon;
import model.repository.GrouponDao;

@Repository
public class GrouponDaoImpl implements GrouponDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Groupon> selectAll() throws SQLException {
		List<Groupon> LG = getSession().createQuery("from Groupon", Groupon.class).list();
		System.out.println(LG);
		return LG;
	}

	@Override
	public Groupon selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		Groupon G = getSession().get(Groupon.class, id);
		System.out.println(G);
		return G;
	}

	@Override
	public List<Groupon> selectHql(String hqlString) throws SQLException {
		String hql = "from Groupon ";
		hql += hqlString;
		List<Groupon> LG = getSession().createQuery(hql, Groupon.class).list();
		System.out.println(LG);
		return LG;
	}

	@Override
	public Groupon insert(Groupon bean) throws SQLException {
		Groupon G = selectByPk(bean.getId());
		if (G == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	public Groupon update(Groupon bean) throws SQLException {
		Groupon G = selectByPk(bean.getId());
		if (G != null) {
			if (bean.getSellerId() != null)
				G.setSellerId(bean.getSellerId());
			if (bean.getProductId() != null)
				G.setProductId(bean.getProductId());
			if (bean.getTitle() != null)
				G.setTitle(bean.getTitle());
			if (bean.getContext() != null)
				G.setContext(bean.getContext());
			if (bean.getDistrictTypeId() != null)
				G.setDistrictTypeId(bean.getDistrictTypeId());
			if (bean.getStartDate() != null)
				G.setStartDate(bean.getStartDate());
			if (bean.getEndDate() != null)
				G.setEndDate(bean.getEndDate());
			if (bean.getGoal() != null)
				G.setGoal(bean.getGoal());
			if (bean.getCompleteTime() != null)
				G.setCompleteTime(bean.getCompleteTime());
			if (bean.getStateId() != null)
				G.setStateId(bean.getStateId());
			return G;
		}
		return null;
	}

}
