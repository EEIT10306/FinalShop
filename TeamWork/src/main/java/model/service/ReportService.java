package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.GroupReport;
import model.bean.StoreReport;
import model.bean.WishReport;
import model.repository.GroupReportDao;
import model.repository.StoreReportDao;
import model.repository.WishReportDao;

@Service
@Transactional
public class ReportService {
	@Autowired
	private WishReportDao wishReportDaoImpl;
	@Autowired
	private GroupReportDao groupReportDaoImpl;
	@Autowired
	private StoreReportDao storeReportDaoImpl;

	public List<List<WishReport>> getWishReport() {
		try {
			List<List<WishReport>> LLWR = new ArrayList<>();
			List<WishReport> LWRI = wishReportDaoImpl.selectHql("Where wR_stateId = 46 Order by wR_time");
			List<WishReport> LWRS = wishReportDaoImpl.selectHql("Where wR_stateId = 47 Order by wR_time");
			List<WishReport> LWRF = wishReportDaoImpl.selectHql("Where wR_stateId = 48 Order by wR_time");
			LLWR.add(LWRI);
			LLWR.add(LWRS);
			LLWR.add(LWRF);
			return LLWR;
		} catch (SQLException e) {
			System.err.println("ReportService - getWishReport - SQLException");
			e.printStackTrace();
			return null;
		}
	}

	public List<List<GroupReport>> getGroupReport() {
		try {
			List<List<GroupReport>> LLGR = new ArrayList<>();
			List<GroupReport> LGRI = groupReportDaoImpl.selectHql("Where gR_stateId = 63 Order by gR_time");
			List<GroupReport> LGRS = groupReportDaoImpl.selectHql("Where gR_stateId = 64 Order by gR_time");
			List<GroupReport> LGRF = groupReportDaoImpl.selectHql("Where gR_stateId = 65 Order by gR_time");
			LLGR.add(LGRI);
			LLGR.add(LGRS);
			LLGR.add(LGRF);
			return LLGR;
		} catch (SQLException e) {
			System.err.println("ReportService - getWishReport - SQLException");
			e.printStackTrace();
			return null;
		}
	}

	public List<List<StoreReport>> getStoreReport() {
		try {
			List<List<StoreReport>> LLSR = new ArrayList<>();
			List<StoreReport> LSRI = storeReportDaoImpl.selectHql("Where sR_stateId = 25 Order by sR_time");
			List<StoreReport> LSRS = storeReportDaoImpl.selectHql("Where sR_stateId = 26 Order by sR_time");
			List<StoreReport> LSRF = storeReportDaoImpl.selectHql("Where sR_stateId = 27 Order by sR_time");
			LLSR.add(LSRI);
			LLSR.add(LSRS);
			LLSR.add(LSRF);
			return LLSR;
		} catch (SQLException e) {
			System.err.println("ReportService - getWishReport - SQLException");
			e.printStackTrace();
			return null;
		}
	}
	
	public WishReport updateWishReport(WishReport wishReport) {
		try {
			wishReport.setwR_time(new Date());
			return wishReportDaoImpl.update(wishReport);
		} catch (SQLException e) {
			System.err.println("ReportService - updateWishReport - SQLException");
			e.printStackTrace();
			return null;
		}
	}
	
	public GroupReport updateGroupReport(GroupReport groupReport) {
		try {
			groupReport.setgR_time(new Date());
			return groupReportDaoImpl.update(groupReport);
		} catch (SQLException e) {
			System.err.println("ReportService - updateGroupReport - SQLException");
			e.printStackTrace();
			return null;
		}
	}
	
	public StoreReport updateStoreReport(StoreReport storeReport) {
		try {
			storeReport.setsR_time(new Date());
			return storeReportDaoImpl.update(storeReport);
		} catch (SQLException e) {
			System.err.println("ReportService - updateStoreReport - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
