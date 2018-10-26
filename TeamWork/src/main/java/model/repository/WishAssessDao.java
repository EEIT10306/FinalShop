package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishAssess;

public interface WishAssessDao {
	public List<WishAssess> select() throws SQLException;
	public WishAssess selectByPk(WishAssess bean) throws SQLException;
	public WishAssess insert(WishAssess bean) throws SQLException;
	public WishAssess update(WishAssess bean) throws SQLException;
}