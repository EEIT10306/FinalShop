package model.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Wish;
import model.repository.WishDao;

@Service
@Transactional
public class WishService {
	@Autowired
	WishDao wishDaoImpl;
	
	public Wish findOneWishByWId(Integer w_id) throws SQLException {
		return wishDaoImpl.selectByPk(w_id);
	}

	public Wish updateOneWish(Wish bean) throws SQLException {
		return wishDaoImpl.update(bean);
	}
}
