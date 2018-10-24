package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreAssess;

public interface StoreAssessDao {
	public List<StoreAssess> select() throws SQLException;
	public StoreAssess selectByPk(StoreAssess bean) throws SQLException;
	public StoreAssess insert(StoreAssess bean) throws SQLException;
	public StoreAssess update(StoreAssess bean) throws SQLException;

}