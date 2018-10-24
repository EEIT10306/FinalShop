package model.repository.Impl;

import java.sql.Blob;
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
		System.out.println(getSession().createQuery("from Member", Member.class).setMaxResults(50).list());
		return getSession().createQuery("from Member", Member.class).setMaxResults(50).list();
	}

	@Override
	public Member select(Integer id) throws SQLException {
		System.out.println(getSession().get(Member.class, id));
		return getSession().get(Member.class, id);
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
			return null;
		}
		return null;
	}

	@Override
	public Member update(Integer id, String account, String password, String name, String address, String telephone,
			String mail, String position, Integer coin, Blob photo, Integer state, Double wiseAssessSumEE,
			Double groupAssessSumEE, Double storeAssessSumEE, Double wiseAssessSum, Double groupAssessSum,
			Double storeAssessSum) throws SQLException {
		// 查詢此ID有無資料
		Member simple = getSession().get(Member.class, id);
		// 有才修改
		if (simple != null) {
			// 外鍵有資料才新增
			State simpleState = getSession().get(State.class, state);
			if (simpleState != null) {
				simple.setAccount(account);
				simple.setPassword(password);
				simple.setName(name);
				simple.setAddress(address);
				simple.setTelephone(telephone);
				simple.setMail(mail);
				simple.setPosition(position);
				simple.setCoin(coin);
				simple.setPhoto(photo);
				simple.setState(state);
				simple.setWiseAssessSumEE(wiseAssessSumEE);
				simple.setGroupAssessSumEE(groupAssessSumEE);
				simple.setStoreAssessSumEE(storeAssessSumEE);
				simple.setWiseAssessSum(wiseAssessSum);
				simple.setGroupAssessSum(groupAssessSum);
				simple.setStoreAssessSum(storeAssessSum);
				return simple;
			}
			return null;
		}
		return null;
	}

}
