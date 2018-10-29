package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Images;

public interface ImagesDao {
	public List<Images> selectAll() throws SQLException;

	public Images selectByPk(Integer id) throws SQLException;

	public List<Images> selectHql(String hqlString) throws SQLException;

	public Images insert(Images imagesBean) throws SQLException;

	public Images update(Images imagesBean) throws SQLException;

	public Boolean delete(Images imagesBean) throws SQLException;
}
