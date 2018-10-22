package model.repository;

import java.sql.SQLException;
import java.util.List;

import model.bean.Images;

public interface ImagesDao {

	public List<Images> selectAll() throws SQLException;

	public Images select(Integer id) throws SQLException;

	public Images insert(Images images) throws SQLException;

	public Images update(Integer id, Integer wgsID, Byte[] cont, Integer imState) throws SQLException;

	public Boolean delete(Integer id) throws SQLException;
}
