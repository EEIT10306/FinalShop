package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Member;

public interface MemberDao {
	public List<Member> selectAll() throws SQLException;

	public Member selectByPk(Integer id) throws SQLException;
	
	public List<Member> selectHql(String hqlString) throws SQLException;

	public Member insert(Member bean) throws SQLException;

	public Member update(Member bean) throws SQLException;

	public boolean idExists(String acount);
}
