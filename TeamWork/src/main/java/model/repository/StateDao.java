package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.State;

public interface StateDao {
	public List<State> select() throws SQLException;
	public State select(Integer id) throws SQLException;
	public State insert(State bean) throws SQLException;
	public State update(Integer id, String context, String className) throws SQLException;
}
