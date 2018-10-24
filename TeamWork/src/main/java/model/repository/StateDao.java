package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.State;

public interface StateDao {
	public List<State> select() throws SQLException;
	public State selectByPk(State bean) throws SQLException;
	public State insert(State bean) throws SQLException;
	public State update(State bean) throws SQLException;
}
