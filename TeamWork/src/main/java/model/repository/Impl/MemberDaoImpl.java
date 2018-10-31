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
		if (id == null)
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
		Member M = selectByPk(bean.getM_id());
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
		Member M = selectByPk(bean.getM_id());
		// 有才修改
		if (M != null) {
			if (bean.getM_account() != null)
				M.setM_account(bean.getM_account());
			if (bean.getM_password() != null)
				M.setM_password(bean.getM_password());
			if (bean.getM_name() != null)
				M.setM_name(bean.getM_name());
			if (bean.getM_address() != null)
				M.setM_address(bean.getM_address());
			if (bean.getM_telephone() != null)
				M.setM_telephone(bean.getM_telephone());
			if (bean.getM_mail() != null)
				M.setM_mail(bean.getM_mail());
			if (bean.getM_position() != null)
				M.setM_position(bean.getM_position());
			if (bean.getM_coin() != null)
				M.setM_coin(bean.getM_coin());
			if (bean.getM_photo() != null)
				M.setM_photo(bean.getM_photo());
			if (bean.getM_loginCount() != null)
				M.setM_loginCount(bean.getM_loginCount());
			if (bean.getM_loginTime() != null)
				M.setM_loginTime(bean.getM_loginTime());
			if (bean.getM_stateId() != null)
				M.setM_stateId(bean.getM_stateId());
			if (bean.getM_wiseAssessSumEE() != null)
				M.setM_wiseAssessSumEE(bean.getM_wiseAssessSumEE());
			if (bean.getM_groupAssessSumEE() != null)
				M.setM_groupAssessSumEE(bean.getM_groupAssessSumEE());
			if (bean.getM_storeAssessSumEE() != null)
				M.setM_storeAssessSumEE(bean.getM_storeAssessSumEE());
			if (bean.getM_wiseAssessSum() != null)
				M.setM_wiseAssessSum(bean.getM_wiseAssessSum());
			if (bean.getM_groupAssessSum() != null)
				M.setM_groupAssessSum(bean.getM_groupAssessSum());
			if (bean.getM_storeAssessSum() != null)
				M.setM_storeAssessSum(bean.getM_storeAssessSum());
			return M;
		}
		return null;
	}

	public Member update(Member M, Member bean) throws SQLException {
		if (bean.getM_account() != null)
			M.setM_account(bean.getM_account());
		if (bean.getM_password() != null)
			M.setM_password(bean.getM_password());
		if (bean.getM_name() != null)
			M.setM_name(bean.getM_name());
		if (bean.getM_address() != null)
			M.setM_address(bean.getM_address());
		if (bean.getM_telephone() != null)
			M.setM_telephone(bean.getM_telephone());
		if (bean.getM_mail() != null)
			M.setM_mail(bean.getM_mail());
		if (bean.getM_position() != null)
			M.setM_position(bean.getM_position());
		if (bean.getM_coin() != null)
			M.setM_coin(bean.getM_coin());
		if (bean.getM_photo() != null)
			M.setM_photo(bean.getM_photo());
		if (bean.getM_loginCount() != null)
			M.setM_loginCount(bean.getM_loginCount());
		if (bean.getM_loginTime() != null)
			M.setM_loginTime(bean.getM_loginTime());
		if (bean.getM_stateId() != null)
			M.setM_stateId(bean.getM_stateId());
		if (bean.getM_wiseAssessSumEE() != null)
			M.setM_wiseAssessSumEE(bean.getM_wiseAssessSumEE());
		if (bean.getM_groupAssessSumEE() != null)
			M.setM_groupAssessSumEE(bean.getM_groupAssessSumEE());
		if (bean.getM_storeAssessSumEE() != null)
			M.setM_storeAssessSumEE(bean.getM_storeAssessSumEE());
		if (bean.getM_wiseAssessSum() != null)
			M.setM_wiseAssessSum(bean.getM_wiseAssessSum());
		if (bean.getM_groupAssessSum() != null)
			M.setM_groupAssessSum(bean.getM_groupAssessSum());
		if (bean.getM_storeAssessSum() != null)
			M.setM_storeAssessSum(bean.getM_storeAssessSum());
		return M;
	}

}
