package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishAssess;

public interface WishAssessDao {
	public List<WishAssess> select() throws SQLException;
	public WishAssess select(Integer id) throws SQLException;
	public WishAssess insert(WishAssess bean) throws SQLException;
	public WishAssess update(Integer id, Integer point, String content, Integer pointee, String contee) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}