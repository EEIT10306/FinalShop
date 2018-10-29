package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.WishMessage;
import model.repository.WishMessageDao;
@Service
public class _TestServiceWishMessage {

	@Autowired
	private WishMessageDao wishMessageDaoImpl;
	
	public List<WishMessage> getSelect(WishMessage wishMessage) {
		try {
			if (wishMessage.getId() == null) {
				List<WishMessage> list = wishMessageDaoImpl.selectAll();
				return list;
			}
			WishMessage temp;
			temp =	wishMessageDaoImpl.selectByPk(wishMessage.getId());
			List<WishMessage> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}

