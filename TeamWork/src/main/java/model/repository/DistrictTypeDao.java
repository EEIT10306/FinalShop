package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.DistrictType;

public interface DistrictTypeDao {
	public List<DistrictType> selectAll() throws SQLException;

	public DistrictType selectByPk(Integer id) throws SQLException;

	public List<DistrictType> selectHql(String hqlString) throws SQLException;

}
