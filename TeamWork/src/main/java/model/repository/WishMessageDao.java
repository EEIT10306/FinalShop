package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.WishMessage;

public interface WishMessageDao {
	public List<WishMessage> selectAll() throws SQLException;

	public WishMessage selectByPk(Integer id) throws SQLException;

	public List<WishMessage> selectHql(String hqlString) throws SQLException;

	public WishMessage insert(WishMessage bean) throws SQLException;

	public WishMessage update(WishMessage bean) throws SQLException;

}
