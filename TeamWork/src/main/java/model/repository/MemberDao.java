package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Member;

public interface MemberDao {
	public List<Member> select() throws SQLException;
	public Member selectByPk(Member bean) throws SQLException;
	public Member insert(Member bean) throws SQLException;
	public Member update(Member bean) throws SQLException;
}
