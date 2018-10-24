package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.DistrictType;
import model.repository.DistrictTypeDao;
@Service
public class _TestServiceDistrictType {

	@Autowired
	private DistrictTypeDao districtTypeDaoImpl;
	
	public List<DistrictType> getSelect(DistrictType districtType) {
		try {
			if (districtType.getId() == null) {
				List<DistrictType> list = districtTypeDaoImpl.select();
				return list;
			}
			DistrictType temp;
			temp =	districtTypeDaoImpl.select(districtType.getId());
			List<DistrictType> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}

