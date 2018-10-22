package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupAssess;

public interface GroupAssessDao {

	public List<GroupAssess> selectAll() throws SQLException;

	public GroupAssess select(Integer id) throws SQLException;

	public GroupAssess insert(GroupAssess assess) throws SQLException;

	public GroupAssess update(Integer id, Integer gmID, Integer point, String cont, Integer pointee, String contee,
			Integer gaState) throws SQLException;

	public Boolean delete(Integer id) throws SQLException;
}
