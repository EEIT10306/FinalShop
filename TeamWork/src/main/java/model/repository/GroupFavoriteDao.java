package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.GroupFavorite;

public interface GroupFavoriteDao {
	public List<GroupFavorite> select() throws SQLException;
	public GroupFavorite selectByPk(GroupFavorite bean) throws SQLException;
	public GroupFavorite insert(GroupFavorite bean) throws SQLException;
	public GroupFavorite update(GroupFavorite bean) throws SQLException;
	public boolean delete(GroupFavorite bean) throws SQLException;
}
