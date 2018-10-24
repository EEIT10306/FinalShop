package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.GroupService;
import model.repository.GroupServiceDao;

@Service
@Transactional
public class GroupServiceService {

	@Autowired
	private GroupServiceDao groupServiceDaoImpl;
	
	public List<GroupService> getSelect(GroupService groupService){
		try {
			if (groupService.getId() == null) {
				List<GroupService> list = groupServiceDaoImpl.selectAll();
				return list;
			}
			GroupService temp;
			temp = groupServiceDaoImpl.selectByPk(groupService);
			List<GroupService> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("Service - GroupService - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
