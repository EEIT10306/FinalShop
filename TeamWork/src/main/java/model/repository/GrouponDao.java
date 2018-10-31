package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Groupon;

public interface GrouponDao {
	public List<Groupon> selectAll() throws SQLException;

	public Groupon selectByPk(Integer id) throws SQLException;

	public List<Groupon> selectHql(String hqlString) throws SQLException;

	public Groupon insert(Groupon bean) throws SQLException;

	public Groupon update(Groupon bean) throws SQLException;

	public Groupon update(Groupon G, Groupon bean) throws SQLException;

}
