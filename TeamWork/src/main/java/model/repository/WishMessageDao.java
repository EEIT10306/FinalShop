package model.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import model.bean.WishMessage;

public interface WishMessageDao {
	public List<WishMessage> select() throws SQLException;
	public WishMessage select(Integer id) throws SQLException;
	public WishMessage insert(WishMessage bean) throws SQLException;
	public WishMessage update(WishMessage bean) throws SQLException;
	
}