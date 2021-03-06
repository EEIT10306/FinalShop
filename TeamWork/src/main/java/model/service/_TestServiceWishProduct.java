package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.WishProduct;
import model.repository.WishProductDao;
@Service
public class _TestServiceWishProduct {

	@Autowired
	private WishProductDao wishProductDaoImpl;
	
	public List<WishProduct> getSelect(WishProduct wishProduct) {
		try {
			if (wishProduct.getwP_id() == null) {
				List<WishProduct> list = wishProductDaoImpl.selectAll();
				return list;
			}
			WishProduct temp;
			temp =	wishProductDaoImpl.selectByPk(wishProduct.getwP_id());
			List<WishProduct> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}

