package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Images;
import model.repository.ImagesDao;

@Service
@Transactional
public class ImagesService {

	@Autowired
	private ImagesDao imagesDaoImpl;
	
	public List<Images> getSelect(Images images){
		try {
			if (images.getId() == null) {
				List<Images> list = imagesDaoImpl.selectAll();
				return list;
			}
			Images temp;
			temp = imagesDaoImpl.selectByPk(images);
			List<Images> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("Service - Images - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
