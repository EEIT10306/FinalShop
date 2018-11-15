package model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.WishOrder;
import model.repository.Impl.WishOrderDaoImpl;

@Service
@Transactional
public class WishOrderService {
	@Autowired
	WishOrderDaoImpl wishOrderDaoImpl;
	
	public WishOrder InsertOneWishOrder(WishOrder bean) throws SQLException {
		return wishOrderDaoImpl.insert(bean);
	}
}
