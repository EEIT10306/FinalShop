package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Achievement;
import model.bean.Wish;
import model.bean.WishProduct;
import model.repository.AchievementDao;
import model.repository.WishProductDao;

@Service
@Transactional
public class _TestServiceSearch {
	@Autowired
	private WishProductDao wishProductDaoImpl;

	public List<WishProduct> getSelect(String selectone) {
		try {
			if (selectone == null && !selectone.isEmpty()) {
				List<WishProduct> list = wishProductDaoImpl.selectAll();
				return list;
			}
			List<WishProduct> temp;
			temp = wishProductDaoImpl.search(selectone);
			return temp;
		} catch (SQLException e) {
			System.out.println("_TestService - Achievement - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
