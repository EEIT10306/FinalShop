package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.Groupon;
import model.repository.GrouponDao;

@Service
public class _TestServiceGroupon {

	@Autowired
	private GrouponDao grouponDaoImpl;

	public List<Groupon> getSelect(Groupon groupon) {
		try {
			if (groupon.getId() == null) {
				List<Groupon> list = grouponDaoImpl.select();
				return list;
			}
			Groupon temp;
			temp = grouponDaoImpl.select(groupon.getId());
			List<Groupon> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
