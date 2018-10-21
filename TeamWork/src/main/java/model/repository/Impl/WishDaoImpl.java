package model.repository.Impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.DistrictType;
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
		if(simple==null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}
	@Override
	public Wish update(Integer id, Integer memberId, Integer productId, String title, String cont,
			Integer districtTypeId, Date startDate, Date endDate, Date compTime, Integer state) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
