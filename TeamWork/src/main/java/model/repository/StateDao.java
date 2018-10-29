package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.State;

public interface StateDao {
	public List<State> selectAll() throws SQLException;

	public State selectByPk(Integer id) throws SQLException;

	public List<State> selectHql(String hqlString) throws SQLException;

	public State insert(State bean) throws SQLException;

	public State update(State bean) throws SQLException;
}
