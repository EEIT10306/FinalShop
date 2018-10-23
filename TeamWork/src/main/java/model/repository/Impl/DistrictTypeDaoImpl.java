package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Achievement;
import model.bean.DistrictType;
import model.bean.WishProduct;
import model.repository.DistrictTypeDao;

@Repository
public class DistrictTypeDaoImpl implements DistrictTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<DistrictType> select() throws SQLException {
		return getSession().createQuery("from DistrictType", DistrictType.class).setMaxResults(50).list();

	}

	@Override
	public DistrictType select(Integer id) throws SQLException {
		return getSession().get(DistrictType.class, id);
	}

	@Override
	public DistrictType insert(DistrictType bean) throws SQLException {
		DistrictType simple = getSession().get(DistrictType.class, bean.getId());
		if (simple == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public DistrictType update(Integer id, String name, Integer parentID, Integer stage) throws SQLException {
		DistrictType districtType = this.getSession().get(DistrictType.class, id);
		if (districtType != null) {
			districtType.setId(id);
			districtType.setName(name);
			districtType.setParentID(parentID);
			districtType.setStage(stage);
			return districtType;
		}
		return null;
	}

}
