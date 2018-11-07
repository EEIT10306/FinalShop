package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreAssess;
import model.repository.StoreAssessDao;

@Service
@Transactional
public class StoreAssessService {
	@Autowired
	StoreAssessDao storeAssessDaoImpl;
	
	public List<StoreAssess> selectAllAssessBySpId(Integer sP_id) throws SQLException {
		String hql = "sA Where sA.storeOrder.sP_id = " + sP_id + " ";
		hql += "Order By sA.storeOrder.sO_time desc";
		List<StoreAssess> storeProductAssess = storeAssessDaoImpl.selectHql(hql);
		System.out.println(storeAssessDaoImpl.selectHql(hql).get(0).getStoreOrder().getStoreProduct().getStoreImages());
		return storeAssessDaoImpl.selectHql(hql);
	}
}
