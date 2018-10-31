package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupProduct;
import model.repository.GroupProductDao;

@Repository
public class GroupProductDaoImpl implements GroupProductDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<GroupProduct> selectAll() throws SQLException {
		List<GroupProduct> LGP = getSession().createQuery("from GroupProduct", GroupProduct.class).list();
		System.out.println(LGP);
		return LGP;
	}

	@Override
	public GroupProduct selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		GroupProduct GP = getSession().get(GroupProduct.class, id);
		System.out.println(GP);
		return GP;
	}

	@Override
	public List<GroupProduct> selectHql(String hqlString) throws SQLException {
		String hql = "from GroupProduct ";
		hql += hqlString;
		List<GroupProduct> LGP = getSession().createQuery(hql, GroupProduct.class).list();
		System.out.println(LGP);
		return LGP;
	}

	@Override
	public GroupProduct insert(GroupProduct bean) throws SQLException {
		GroupProduct GP = selectByPk(bean.getgP_id());
		if (GP == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupProduct update(GroupProduct bean) throws SQLException {
		GroupProduct GP = selectByPk(bean.getgP_id());
		if (GP != null) {
			if (bean.getG_iD() != null)
				GP.setG_iD(bean.getG_iD());
			if (bean.getgP_name() != null)
				GP.setgP_name(bean.getgP_name());
			if (bean.getP_id() != null)
				GP.setP_id(bean.getP_id());
			if (bean.getgP_amount() != null)
				GP.setgP_amount(bean.getgP_amount());
			if (bean.getgP_price() != null)
				GP.setgP_price(bean.getgP_price());
			if (bean.getgP_context() != null)
				GP.setgP_context(bean.getgP_context());
			if (bean.getgP_version() != null)
				GP.setgP_version(bean.getgP_version());
			if (bean.getgP_completeTime() != null)
				GP.setgP_completeTime(bean.getgP_completeTime());
			if (bean.getgP_stateId() != null)
				GP.setgP_stateId(bean.getgP_stateId());
			return GP;
		}
		return null;
	}

	public GroupProduct update(GroupProduct GP, GroupProduct bean) throws SQLException {
		if (bean.getG_iD() != null)
			GP.setG_iD(bean.getG_iD());
		if (bean.getgP_name() != null)
			GP.setgP_name(bean.getgP_name());
		if (bean.getP_id() != null)
			GP.setP_id(bean.getP_id());
		if (bean.getgP_amount() != null)
			GP.setgP_amount(bean.getgP_amount());
		if (bean.getgP_price() != null)
			GP.setgP_price(bean.getgP_price());
		if (bean.getgP_context() != null)
			GP.setgP_context(bean.getgP_context());
		if (bean.getgP_version() != null)
			GP.setgP_version(bean.getgP_version());
		if (bean.getgP_completeTime() != null)
			GP.setgP_completeTime(bean.getgP_completeTime());
		if (bean.getgP_stateId() != null)
			GP.setgP_stateId(bean.getgP_stateId());
		return GP;
	}
}
