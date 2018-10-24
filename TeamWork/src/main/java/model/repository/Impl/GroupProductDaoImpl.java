package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupProduct;
import model.bean.Groupon;
import model.bean.Product;
import model.bean.State;
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
		return getSession().createQuery("from GroupProduct", GroupProduct.class).setMaxResults(50).list();
	}

	@Override
	public GroupProduct selectByPk(GroupProduct groupProductBean) throws SQLException {
		GroupProduct groupProduct = getSession().get(GroupProduct.class, groupProductBean.getId());
		if (groupProduct != null) {
			return groupProduct;
		}
		return null;
	}

	@Override
	public GroupProduct insert(GroupProduct groupProductBean) throws SQLException {
		GroupProduct product = getSession().get(GroupProduct.class, groupProductBean.getId());
		if (product == null) {
			getSession().save(groupProductBean);
			return groupProductBean;
		}
		return null;
	}

	@Override
	public GroupProduct update(GroupProduct groupProductBean) throws SQLException {
		GroupProduct groupProduct = getSession().get(GroupProduct.class, groupProductBean.getId());
		if (groupProduct != null) {
			if (getSession().get(Groupon.class, groupProductBean.getGroupID()) != null) {
				if (getSession().get(Product.class, groupProductBean.getProductId()) != null) {
					if (getSession().get(State.class, groupProductBean.getState()) != null) {
						groupProduct.setGroupID(groupProductBean.getGroupID());
						groupProduct.setName(groupProductBean.getName());
						groupProduct.setProductId(groupProductBean.getProductId());
						groupProduct.setAmount(groupProductBean.getAmount());
						groupProduct.setPrice(groupProductBean.getPrice());
						groupProduct.setContext(groupProductBean.getContext());
						groupProduct.setVersion(groupProductBean.getVersion());
						groupProduct.setCompleteTime(groupProductBean.getCompleteTime());
						groupProduct.setState(groupProductBean.getState());
						return groupProduct;
					}
				}
			}
		}
		return null;
	}
}
