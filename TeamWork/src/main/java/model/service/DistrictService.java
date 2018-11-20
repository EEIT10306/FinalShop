package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.DistrictType;
import model.repository.DistrictTypeDao;

@Service
@Transactional
public class DistrictService {
	
	@Autowired
	private DistrictTypeDao districtTypeDao;
	
	public List<DistrictType> selectAll(){
		List<DistrictType> list = null;
		try {
			list = districtTypeDao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println("================");
//		System.out.println(list);
//		System.out.println("================");
		return list;
		
	}
}
