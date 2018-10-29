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
		GroupProduct GP = selectByPk(bean.getId());
		if (GP == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupProduct update(GroupProduct bean) throws SQLException {
		GroupProduct GP = selectByPk(bean.getId());
		if (GP != null) {
			if (bean.getGroupID() != null)
				GP.setGroupID(bean.getGroupID());
			if (bean.getName() != null)
				GP.setName(bean.getName());
			if (bean.getProductId() != null)
				GP.setProductId(bean.getProductId());
			if (bean.getAmount() != null)
				GP.setAmount(bean.getAmount());
			if (bean.getPrice() != null)
				GP.setPrice(bean.getPrice());
			if (bean.getContext() != null)
				GP.setContext(bean.getContext());
			if (bean.getVersion() != null)
				GP.setVersion(bean.getVersion());
			if (bean.getCompleteTime() != null)
				GP.setCompleteTime(bean.getCompleteTime());
			if (bean.getStateId() != null)
				GP.setStateId(bean.getStateId());
			return GP;
		}
		return null;
	}
}
