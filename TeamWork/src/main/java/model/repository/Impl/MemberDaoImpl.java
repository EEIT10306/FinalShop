package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Member;
import model.repository.MemberDao;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Member> selectAll() throws SQLException {
		List<Member> LM = getSession().createQuery("from Member", Member.class).list();
		System.out.println(LM);
		return LM;
	}

	@Override
	public Member selectByPk(Integer id) throws SQLException {
		if (id != null)
			return null;
		Member M = getSession().get(Member.class, id);
		System.out.println(M);
		return M;
	}

	@Override
	public List<Member> selectHql(String hqlString) throws SQLException {
		String hql = "from Member ";
		hql += hqlString;
		List<Member> LM = getSession().createQuery(hql, Member.class).list();
		System.out.println(LM);
		return LM;
	}

	@Override
	public Member insert(Member bean) throws SQLException {
		// 查詢此ID有無資料
		Member M = selectByPk(bean.getId());
		// 沒有才新增
		if (M == null) {
			getSession().save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public Member update(Member bean) throws SQLException {
		// 查詢此ID有無資料
		Member M = selectByPk(bean.getId());
		// 有才修改
		if (M != null) {
			if (bean.getAccount() != null)
				M.setAccount(bean.getAccount());
			if (bean.getPassword() != null)
				M.setPassword(bean.getPassword());
			if (bean.getName() != null)
				M.setName(bean.getName());
			if (bean.getAddress() != null)
				M.setAddress(bean.getAddress());
			if (bean.getTelephone() != null)
				M.setTelephone(bean.getTelephone());
			if (bean.getMail() != null)
				M.setMail(bean.getMail());
			if (bean.getPosition() != null)
				M.setPosition(bean.getPosition());
			if (bean.getCoin() != null)
				M.setCoin(bean.getCoin());
			if (bean.getPhoto() != null)
				M.setPhoto(bean.getPhoto());
			if (bean.getStateId() != null)
				M.setStateId(bean.getStateId());
			if (bean.getLoginCount() != null)
				M.setLoginCount(bean.getLoginCount());
			if (bean.getLoginTime() != null)
				M.setLoginTime(bean.getLoginTime());
			if (bean.getWiseAssessSumEE() != null)
				M.setWiseAssessSumEE(bean.getWiseAssessSumEE());
			if (bean.getGroupAssessSumEE() != null)
				M.setGroupAssessSumEE(bean.getGroupAssessSumEE());
			if (bean.getStoreAssessSumEE() != null)
				M.setStoreAssessSumEE(bean.getStoreAssessSumEE());
			if (bean.getWiseAssessSum() != null)
				M.setWiseAssessSum(bean.getWiseAssessSum());
			if (bean.getGroupAssessSum() != null)
				M.setGroupAssessSum(bean.getGroupAssessSum());
			if (bean.getStoreAssessSum() != null)
				M.setStoreAssessSum(bean.getStoreAssessSum());
			return M;
		}
		return null;
	}

}
