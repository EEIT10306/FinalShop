package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreAssess;

public interface StoreAssessDao {
	public List<StoreAssess> select() throws SQLException;
	public StoreAssess select(Integer id) throws SQLException;
	public StoreAssess insert(StoreAssess bean) throws SQLException;
	public StoreAssess update(Integer id, Integer storeassessPoint, String storeassessContent, Integer storeassessPointee,
			String storeassessContee) throws SQLException;
	public boolean delete(Integer id) throws SQLException;

}