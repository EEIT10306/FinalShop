package model.repository.Impl;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.bean.Member;
import model.bean.State;
import model.repository.MemberDao;

@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public List<Member> select() throws SQLException {
		List<Member> simples = getSession().createQuery("from Member", Member.class).setMaxResults(50).list();
		System.out.println(simples);
		return simples;
	}
	
	
	@Override
	public Member selectByPk(Member bean) throws SQLException {
		Member simple = getSession().get(Member.class, bean.getId());
		System.out.println(simple);
		return simple;
	}

	@Override
	public Member insert(Member bean) throws SQLException {
		// 查詢此ID有無資料
		Member simple = getSession().get(Member.class, bean.getId());
		// 沒有才新增
		if (simple == null) {
			// 外鍵有資料才新增
			State simpleState = getSession().get(State.class, bean.getState());
			if (simpleState != null) {
				getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public Member update(Member bean) throws SQLException {
		// 查詢此ID有無資料
		Member simple = getSession().get(Member.class, bean.getId());
		// 有才修改
		if (simple != null) {
			// 外鍵有資料才修改
			State simpleState = getSession().get(State.class, bean.getState());
			if (simpleState != null) {
				simple.setAccount(bean.getAccount());
				simple.setPassword(bean.getPassword());
				simple.setName(bean.getName());
				simple.setAddress(bean.getAddress());
				simple.setTelephone(bean.getTelephone());
				simple.setMail(bean.getMail());
				simple.setPosition(bean.getPosition());
				simple.setCoin(bean.getCoin());
				simple.setPhoto(bean.getPhoto());
				simple.setState(bean.getState());
				simple.setWiseAssessSumEE(bean.getWiseAssessSumEE());
				simple.setGroupAssessSumEE(bean.getGroupAssessSumEE());
				simple.setStoreAssessSumEE(bean.getStoreAssessSumEE());
				simple.setWiseAssessSum(bean.getWiseAssessSum());
				simple.setGroupAssessSum(bean.getGroupAssessSum());
				simple.setStoreAssessSum(bean.getStoreAssessSum());
				return simple;
			}
		}
		return null;
	}

}
