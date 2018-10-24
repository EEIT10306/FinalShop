package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.DistrictType;

public interface DistrictTypeDao {
	public List<DistrictType> select() throws SQLException;
	public DistrictType select(Integer id) throws SQLException;
	public DistrictType insert(DistrictType bean) throws SQLException;
	public DistrictType update(DistrictType bean) throws SQLException;
}
