package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.DistrictType;
import model.repository.DistrictTypeDao;

@Repository
public class DistrictTypeDaoImpl implements DistrictTypeDao {

	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<DistrictType> selectAll() throws SQLException {
		List<DistrictType> LDT = getSession().createQuery("from DistrictType", DistrictType.class).list();
		System.out.println(LDT);
		return LDT;

	}

	@Override
	public DistrictType selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		DistrictType DT = getSession().get(DistrictType.class, id);
		System.out.println(DT);
		return DT;
	}

	@Override
	public List<DistrictType> selectHql(String hqlString) throws SQLException {
		String hql = "from DistrictType ";
		hql += hqlString;
		List<DistrictType> LDT = getSession().createQuery(hql, DistrictType.class).list();
		System.out.println(LDT);
		return LDT;
	}

	@Override
	public DistrictType update(DistrictType bean) throws SQLException {
		// 查詢此ID有無資料
		DistrictType DT = selectByPk(bean.getD_id());
		// 有才修改
		if (DT != null) {
			if (bean.getD_name() != null)
				DT.setD_name(bean.getD_name());
			if (bean.getD_parentsId() != null)
				DT.setD_parentsId(bean.getD_parentsId());
			if (bean.getD_stageId() != null)
				DT.setD_stageId(bean.getD_stageId());
			return DT;
		}
		return null;
	}

}
