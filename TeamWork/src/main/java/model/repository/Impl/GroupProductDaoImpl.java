package model.repository.Impl;

import java.sql.SQLException;
import java.util.Date;
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
		return getSession().createQuery("from GroupProduct", GroupProduct.class).setMaxResults(50).list();
	}

	@Override
	public GroupProduct select(Integer id) throws SQLException {
		return getSession().get(GroupProduct.class, id);
	}

	@Override
	public GroupProduct insert(GroupProduct groupProduct) throws SQLException {
		GroupProduct product = getSession().get(GroupProduct.class, groupProduct.getId());
		if (product == null) {
			getSession().save(groupProduct);
			return groupProduct;
		}
		return null;
	}

	@Override
	public GroupProduct update(Integer id, Integer groupID, String name, Integer prodID, Integer amt, Integer price,
			String cont, Integer ver, Date compTime, Integer gpState) throws SQLException {
		GroupProduct groupProduct = this.getSession().get(GroupProduct.class, id);
		if (groupProduct != null) {
			groupProduct.setId(id);
			groupProduct.setGroupID(groupID);
			groupProduct.setName(name);
			groupProduct.setProductId(prodID);
			groupProduct.setAmount(amt);
			groupProduct.setPrice(price);
			groupProduct.setContext(cont);
			groupProduct.setVersion(ver);
			groupProduct.setCompleteTime(compTime);
			groupProduct.setState(gpState);
			getSession().update(groupProduct);
			return groupProduct;
		}
		return null;
	}

	@Override
	public Boolean delete(Integer id) throws SQLException {
		GroupProduct groupProduct = getSession().get(GroupProduct.class, id);
		if (groupProduct != null) {
			getSession().delete(groupProduct);
			return true;
		}
		return false;
	}

}
