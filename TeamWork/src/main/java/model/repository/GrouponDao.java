package model.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;


import model.bean.Groupon;

public interface GrouponDao {
	public List<Groupon> select() throws SQLException;
	public Groupon select(Integer id) throws SQLException;
	public Groupon insert(Groupon bean) throws SQLException;
	public Groupon update(Groupon bean) throws SQLException;
	
}
