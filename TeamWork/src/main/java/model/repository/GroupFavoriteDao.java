package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupFavorite;

public interface GroupFavoriteDao {
	public List<GroupFavorite> select() throws SQLException;
	public GroupFavorite select(Integer id) throws SQLException;
	public GroupFavorite insert(GroupFavorite bean) throws SQLException;
	public GroupFavorite update(Integer id, Integer memberId, Integer groupProductId) throws SQLException;
	public boolean delete(Integer id) throws SQLException;
}
