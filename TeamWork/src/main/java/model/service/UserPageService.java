package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Achievement;
import model.bean.Member;
import model.repository.MemberDao;

@Service
@Transactional
public class UserPageService {
	@Autowired
	private MemberDao memberDaoImpl;
	
	public Member getOneMember(Member member) {
		try {
		Member temp;
		temp = memberDaoImpl.selectByPk(member.getM_id());
		return temp;
		}catch (SQLException e) {
			System.out.println("getOneMember- SQLException");
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Member> getSelect(Member member) {
		try {
			if (member.getM_id() == null) {
				List<Member> list = memberDaoImpl.selectAll();
				return list;
			}
			Member temp;
			temp = memberDaoImpl.selectByPk(member.getM_id());
			List<Member> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - Achievement - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
