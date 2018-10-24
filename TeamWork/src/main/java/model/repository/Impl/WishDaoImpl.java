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
import model.bean.Member;
import model.bean.Product;
import model.bean.State;
import model.bean.Wish;
import model.repository.WishDao;

@Repository
public class WishDaoImpl implements WishDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Wish> select() throws SQLException {
		return getSession().createQuery("from Wish", Wish.class).setMaxResults(50).list();

	}

	@Override
	public Wish select(Integer id) throws SQLException {
		return getSession().get(Wish.class, id);
	}

	@Override
	public Wish insert(Wish bean) throws SQLException {
		Wish simple = getSession().get(Wish.class, bean.getId());
		if (simple == null) {
			Member memb = getSession().get(Member.class, bean.getId());
			Product prod = getSession().get(Product.class, bean.getId());
			DistrictType dist = getSession().get(DistrictType.class, bean.getId());
			State stat = getSession().get(State.class, bean.getState());
			if (memb != null && prod != null && dist != null && stat != null) {
				
				getSession().save(bean);
				return bean;
			}
			return null;
		}
		return null;
	}

	

	@Override
	public Wish update(Wish bean) throws SQLException {
		Wish simple = this.getSession().get(Wish.class, bean.getId());
		if (simple != null) {
			Member memb = getSession().get(Member.class, bean.getId());
			Product prod = getSession().get(Product.class, bean.getId());
			DistrictType dist = getSession().get(DistrictType.class, bean.getId());
			State stat = getSession().get(State.class, bean.getState());
			if (memb != null && prod != null && dist != null && stat != null) {
				simple.setMemberId(bean.getMemberId());
				simple.setProductId(bean.getProductId());
				simple.setTitle(bean.getTitle());
				simple.setContext(bean.getContext());
				simple.setDistrictTypeId(bean.getDistrictTypeId());
				simple.setStartDate(bean.getStartDate());
				simple.setEndDate(bean.getEndDate());
				simple.setCompleteTime(bean.getCompleteTime());
				simple.setState(bean.getState());
			return simple;
			}
			return null;
		}
		return null;
	}

}
