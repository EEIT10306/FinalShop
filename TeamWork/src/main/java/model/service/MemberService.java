package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Member;
import model.repository.Impl.MemberDaoImpl;

@Service
@Transactional
public class MemberService {
	
	@Autowired
	MemberDaoImpl memberDaoImpl;
	
	public MemberService() {
	}
	
	public Member insert(Member bean) throws Exception {
		return memberDaoImpl.insert(bean);
	}
	
	public boolean idExists(String string) {
		return memberDaoImpl.idExists(string);
	}
	
	public List<Member> selectHql(String hqlString) throws SQLException{
		return memberDaoImpl.selectHql(hqlString);
		
	}
	
	public Member emailToMember(String email) throws SQLException{
		if(email==null) {
			return null;
		}
		
		return memberDaoImpl.selectHql("where m_mail='"+email+"'").get(0);
		
	}
}
