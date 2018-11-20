package model.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Analytics;
import model.bean.XYAnalytics;
import model.repository.AnalyticsDao;
import model.repository.XYAnalyticsDao;

@Service
@Transactional
public class RequisitionService {
	@Autowired
	private AnalyticsDao analyticsDao;
	@Autowired
	private XYAnalyticsDao xyAnalyticsDao;

	public List<Analytics> getAnalytics() {
		try {
			List<Analytics> LA = analyticsDao.selectAll();
			return LA;
		} catch (SQLException e) {
			System.err.println("RequisitionService - getAnalytics - SQLException");
			e.printStackTrace();
			return null;
		}
	}

	public XYAnalytics setXYAnalytics(XYAnalytics xyAnalytics) {
		try {
			List<XYAnalytics> LXYA = xyAnalyticsDao
					.selectHql("Where xy_x = " + xyAnalytics.getXy_x() + " and xy_y = " + xyAnalytics.getXy_y());
			if (LXYA.size() == 0) {
				xyAnalytics.setXy_date(new Date());
				xyAnalyticsDao.insert(xyAnalytics);
			}else {
				LXYA.get(0).setXy_r(LXYA.get(0).getXy_r()*Math.sqrt(2));
				xyAnalyticsDao.update(LXYA.get(0));
			}
			return xyAnalytics;
		} catch (SQLException e) {
			System.err.println("RequisitionService - setXYAnalytics - SQLException");
			e.printStackTrace();
			return null;
		}
	}

	public List<XYAnalytics> getXYAnalytics() {
		try {
			return xyAnalyticsDao.selectAll();
		} catch (SQLException e) {
			System.err.println("RequisitionService - getXYAnalytics - SQLException");
			e.printStackTrace();
			return null;
		}
	}

}
