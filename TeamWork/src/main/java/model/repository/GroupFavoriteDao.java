package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupFavorite;

public interface GroupFavoriteDao {
	public List<GroupFavorite> selectAll() throws SQLException;

	public GroupFavorite selectByPk(Integer id) throws SQLException;

	public List<GroupFavorite> selectHql(String hqlString) throws SQLException;

	public GroupFavorite insert(GroupFavorite bean) throws SQLException;

	public boolean delete(GroupFavorite bean) throws SQLException;

}
