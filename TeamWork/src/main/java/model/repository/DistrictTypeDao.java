package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.DistrictType;

public interface DistrictTypeDao {
	public List<DistrictType> select() throws SQLException;
	public DistrictType select(Integer id) throws SQLException;
	public DistrictType insert(DistrictType bean) throws SQLException;
	public DistrictType update(Integer id, String name, Integer parentID, Integer stage) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
