package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreImages;

public interface StoreImagesDao {
	public List<StoreImages> selectAll() throws SQLException;

	public StoreImages selectByPk(Integer id) throws SQLException;

	public List<StoreImages> selectHql(String hqlString) throws SQLException;

	public StoreImages insert(StoreImages bean) throws SQLException;

	public StoreImages update(StoreImages bean) throws SQLException;

	public StoreImages update(StoreImages SI, StoreImages bean) throws SQLException;

	public Boolean delete(StoreImages bean) throws SQLException;
}
