package model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.DistrictType;
import model.repository.DistrictTypeDao;

@Service
@Transactional
public class DistrictTypeService {
	@Autowired
	DistrictTypeDao districtTypeDaoImpl;
	
	public DistrictType findOneDistrictTypeByDId(Integer districtNo) throws SQLException {
		return districtTypeDaoImpl.selectByPk(districtNo);
	}
}
