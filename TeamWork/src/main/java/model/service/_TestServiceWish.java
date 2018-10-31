package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.Wish;
import model.repository.WishDao;
@Service
public class _TestServiceWish {

	@Autowired
	private WishDao wishDaoImpl;

	public List<Wish> getSelect(Wish wish) {
		try {
			if (wish.getW_id() == null) {
				List<Wish> list = wishDaoImpl.selectAll();
				return list;
			}
			Wish temp;
			temp =	wishDaoImpl.selectByPk(wish.getW_id());
			List<Wish> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
