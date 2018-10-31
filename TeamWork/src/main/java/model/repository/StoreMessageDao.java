package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.StoreMessage;

public interface StoreMessageDao {
	public List<StoreMessage> selectAll() throws SQLException;

	public StoreMessage selectByPk(Integer id) throws SQLException;

	public List<StoreMessage> selectHql(String hqlString) throws SQLException;

	public StoreMessage insert(StoreMessage bean) throws SQLException;

	public StoreMessage update(StoreMessage bean) throws SQLException;

	public StoreMessage update(StoreMessage SM, StoreMessage bean) throws SQLException;

}
