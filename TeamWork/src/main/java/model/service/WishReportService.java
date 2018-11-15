package model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WishReport;
import model.repository.WishReportDao;

@Service
@Transactional
public class WishReportService {
	@Autowired
	WishReportDao wishReportDaoImpl;
	
	public WishReport insertOneStoreReport(WishReport bean) throws SQLException {
		return wishReportDaoImpl.insert(bean);
	}
}
