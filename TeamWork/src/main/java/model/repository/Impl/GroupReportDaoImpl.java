package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.GroupReport;
import model.repository.GroupReportDao;

@Repository
public class GroupReportDaoImpl implements GroupReportDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<GroupReport> selectAll() throws SQLException {
		List<GroupReport> LGR = getSession().createQuery("from GroupReport", GroupReport.class).list();
		System.out.println(LGR);
		return LGR;
	}

	@Override
	public GroupReport selectByPk(Integer id) throws SQLException {
		if (id == null)
			return null;
		GroupReport GR = getSession().get(GroupReport.class, id);
		System.out.println(GR);
		return GR;
	}

	@Override
	public List<GroupReport> selectHql(String hqlString) throws SQLException {
		String hql = "from GroupReport ";
		hql += hqlString;
		List<GroupReport> LGR = getSession().createQuery(hql, GroupReport.class).list();
		System.out.println(LGR);
		return LGR;
	}

	@Override
	public GroupReport insert(GroupReport bean) throws SQLException {
		GroupReport GR = selectByPk(bean.getgR_id());
		if (GR == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public GroupReport update(GroupReport bean) throws SQLException {
		GroupReport GR = selectByPk(bean.getgR_id());
		if (GR != null) {
			if (bean.getG_id() != null)
				GR.setG_id(bean.getG_id());
			if (bean.getM_idReport() != null)
				GR.setM_idReport(bean.getM_idReport());
			if (bean.getgR_content() != null)
				GR.setgR_content(bean.getgR_content());
			if (bean.getgR_stateId() != null)
				GR.setgR_stateId(bean.getgR_stateId());
			return GR;
		}
		return null;
	}

}
