package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupImages;

public interface GroupImagesDao {
	public List<GroupImages> selectAll() throws SQLException;

	public GroupImages selectByPk(Integer id) throws SQLException;

	public List<GroupImages> selectHql(String hqlString) throws SQLException;

	public GroupImages insert(GroupImages bean) throws SQLException;

	public GroupImages update(GroupImages bean) throws SQLException;

	public GroupImages update(GroupImages GI, GroupImages bean) throws SQLException;

	public Boolean delete(GroupImages bean) throws SQLException;
}
