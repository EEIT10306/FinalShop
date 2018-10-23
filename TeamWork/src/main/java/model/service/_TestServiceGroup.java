package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.bean.Group;
import model.repository.GroupDao;
@Service
public class _TestServiceGroup {

	@Autowired
	private GroupDao groupDaoImpl;
	
	public List<Group> getSelect(Group group) {
		try {
			if (group.getId() == null) {
				List<Group> list = groupDaoImpl.select();
				return list;
			}
			Group temp;
			temp =	groupDaoImpl.select(group.getId());
			List<Group> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
