package model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreReport;
import model.repository.StoreReportDao;

@Service
@Transactional
public class StoreReportService {
	@Autowired
	StoreReportDao storeReportDaoImpl;
	
	public StoreReport insertOneReportBySpId(StoreReport bean) throws SQLException {
		return storeReportDaoImpl.insert(bean);
	}
}
