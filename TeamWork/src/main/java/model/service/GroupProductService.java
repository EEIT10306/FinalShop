package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.GroupProduct;
import model.repository.GroupProductDao;

@Service
@Transactional
public class GroupProductService {

	@Autowired
	private GroupProductDao groupProductDaoImpl;

	public List<GroupProduct> getSelect(GroupProduct groupProduct) {
		try {
			if (groupProduct.getId() == null) {
				List<GroupProduct> list = groupProductDaoImpl.selectAll();
				return list;
			}
			GroupProduct temp;
			temp = groupProductDaoImpl.selectByPk(groupProduct);
			List<GroupProduct> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("Service - GroupProduct - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
