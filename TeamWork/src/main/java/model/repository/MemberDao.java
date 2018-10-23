package model.repository;


import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import model.bean.Member;

public interface MemberDao {
	public List<Member> select() throws SQLException;
	public Member select(Integer id) throws SQLException;
	public Member insert(Member bean) throws SQLException;
	public Member update(Integer id, String account, String password, String name, String address, String telephone,
			String mail, String position, Integer coin, Blob photo, Integer state, Double wiseAssessSumEE,
			Double groupAssessSumEE, Double storeAssessSumEE, Double wiseAssessSum, Double groupAssessSum,
			Double storeAssessSum) throws SQLException;
}
