package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Wish;

public interface WishDao {
	public List<Wish> selectAll() throws SQLException;

	public Wish selectByPk(Integer id) throws SQLException;

	public List<Wish> selectHql(String hqlString) throws SQLException;

	public Wish insert(Wish bean) throws SQLException;

	public Wish update(Wish bean) throws SQLException;

}
