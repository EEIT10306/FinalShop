package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.GroupMessage;
import model.repository.GroupMessageDao;

@Service
@Transactional
public class GroupMessageService {

	@Autowired
	private GroupMessageDao groupMessageDaoImpl;
	
	public List<GroupMessage> getSelect(GroupMessage groupMessage){
		try {
			if (groupMessage.getId() == null) {
				List<GroupMessage> list = groupMessageDaoImpl.selectAll();
				return list;
			}
			GroupMessage temp;
			temp = groupMessageDaoImpl.selectByPk(groupMessage);
			List<GroupMessage> list = new ArrayList<>();
			list.add(temp);
			return list;
		} catch (SQLException e) {
			System.out.println("Service - GroupMessage - SQLException");
			e.printStackTrace();
			return null;
		}
	}
}
