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
public class _TestServiceDistrictType {

	@Autowired
	private DistrictTypeDao districtTypeDaoImpl;
	
	public List<DistrictType> getSelect(DistrictType districtType) {
		try {
				return districtTypeDaoImpl.selectAll();
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}

