package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.DistrictType;
import model.bean.Groupon;
import model.bean.Member;
import model.bean.Product;
import model.bean.State;
import model.repository.GrouponDao;

@Repository
public class GrouponDaoImpl implements GrouponDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Groupon> select() throws SQLException {
		return getSession().createQuery("from Groupon", Groupon.class).setMaxResults(50).list();
	}

	@Override
	public Groupon select(Integer id) throws SQLException {
		return getSession().get(Groupon.class, id);
	}

	@Override
	public Groupon insert(Groupon bean) throws SQLException {
		Groupon simple = getSession().get(Groupon.class, bean.getId());
		if (simple == null) {
			Member memb = getSession().get(Member.class, bean.getId());
			DistrictType dist = getSession().get(DistrictType.class, bean.getId());
			Product prod = getSession().get(Product.class, bean.getId());
			State simpleState = getSession().get(State.class, bean.getState());
			if(dist != null && prod != null && simpleState != null && memb!=null ) {	
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}
	
	public Groupon update(Groupon bean)
			throws SQLException {
		Groupon simple = getSession().get(Groupon.class, bean.getId());
		if (simple != null) {
			Member memb = getSession().get(Member.class, bean.getId());
			DistrictType dist = getSession().get(DistrictType.class, bean.getId());
			Product prod = getSession().get(Product.class, bean.getId());
			State simpleState = getSession().get(State.class, bean.getState());
			if(dist != null && prod != null && simpleState != null&& memb!=null) {	
				simple.setMemberId(bean.getMemberId());
				simple.setGroupClass(bean.getGroupClass());
				simple.setTitle(bean.getTitle());
				simple.setCont(bean.getCont());
				simple.setDistrictTypeId(bean.getDistrictTypeId());
				simple.setStartDate(bean.getStartDate());
				simple.setEndDate(bean.getEndDate());
				simple.setGoal(bean.getGoal());
				simple.setCompTime(bean.getCompTime());
				simple.setState(bean.getState());
				return bean;
			}
			return null;
		}
		return null;
	}

	}


