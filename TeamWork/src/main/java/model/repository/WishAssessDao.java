package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishAssess;

public interface WishAssessDao {
	public List<WishAssess> selectAll() throws SQLException;

	public WishAssess selectByPk(Integer id) throws SQLException;

	public List<WishAssess> selectHql(String hqlString) throws SQLException;

	public WishAssess insert(WishAssess bean) throws SQLException;

	public WishAssess update(WishAssess bean) throws SQLException;

}