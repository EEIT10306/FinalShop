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
		if (id == null)
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
		Groupon G = selectByPk(bean.getG_id());
		if (G == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	public Groupon update(Groupon bean) throws SQLException {
		Groupon G = selectByPk(bean.getG_id());
		if (G != null) {
			if (bean.getSeller_id() != null)
				G.setSeller_id(bean.getSeller_id());
			if (bean.getP_id() != null)
				G.setP_id(bean.getP_id());
			if (bean.getG_title() != null)
				G.setG_title(bean.getG_title());
			if (bean.getG_context() != null)
				G.setG_context(bean.getG_context());
			if (bean.getD_id() != null)
				G.setD_id(bean.getD_id());
			if (bean.getG_startDate() != null)
				G.setG_startDate(bean.getG_startDate());
			if (bean.getG_endDate() != null)
				G.setG_endDate(bean.getG_endDate());
			if (bean.getG_goal() != null)
				G.setG_goal(bean.getG_goal());
			if (bean.getG_sumPrice() != null)
				G.setG_sumPrice(bean.getG_sumPrice());
			if (bean.getG_hot() != null)
				G.setG_hot(bean.getG_hot());
			if (bean.getG_amountFavorite() != null)
				G.setG_amountFavorite(bean.getG_amountFavorite());
			if (bean.getG_completeTime() != null)
				G.setG_completeTime(bean.getG_completeTime());
			if (bean.getG_stateId() != null)
				G.setG_stateId(bean.getG_stateId());
			return G;
		}
		return null;
	}

}
