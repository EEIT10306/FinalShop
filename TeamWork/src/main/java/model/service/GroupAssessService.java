package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.GroupAssess;
import model.repository.GroupAssessDao;

@Service
@Transactional
public class GroupAssessService {

	@Autowired
	private GroupAssessDao groupAssessDaoImpl;

	public List<GroupAssess> getSelect(GroupAssess groupAssess) {
		try {
			if (groupAssess.getId() == null) {
				List<GroupAssess> list = groupAssessDaoImpl.selectAll();
				return list;
			}
			GroupAssess temp;
			temp = groupAssessDaoImpl.selectByPk(groupAssess);
			List<GroupAssess> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("Service - GroupAssess - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
