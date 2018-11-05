package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Conversation;
import model.repository.ConversationDao;

@Service
@Transactional
public class ConversationService {
	@Autowired
	private ConversationDao conversationDaoImpl;

	public List<List<Conversation>> getConversationTalker(Conversation conversation) {
		try {
			String hqlString = "Where m_id = ";
			hqlString += conversation.getM_id() + " ";// 自己的ID
			hqlString += "or m_idConversation = ";
			hqlString += conversation.getM_id() + " ";// 自己為接話人:找出密我的人
			hqlString += "Order by c_time desc";
			List<Conversation> temp = conversationDaoImpl.selectHql(hqlString);// 找m_id(傳) 和 m_idConversation(接)
			Set<Integer> tempId = new LinkedHashSet<Integer>();
			for (Conversation cs : temp) {
				tempId.add(cs.getM_idConversation());
				tempId.add(cs.getM_id());
			}
			tempId.remove(conversation.getM_id());// 與本人對話之他人
			System.out.println(tempId);// M_idTalker

			
			List<List<Conversation>> lastConversation = new ArrayList<>();
			Iterator<Integer> tempIdIt = tempId.iterator();
			while (tempIdIt.hasNext()) {
				Integer now = tempIdIt.next();

				hqlString = "Where m_id = ";
				hqlString += conversation.getM_id() + " ";// 自己的ID
				hqlString += "and m_idConversation = ";
				hqlString += now + " ";// 自己為接話人:找出密我的人

				hqlString += "or m_id = ";
				hqlString += now + " ";// 自己的ID
				hqlString += "and m_idConversation = ";
				hqlString += conversation.getM_id() + " ";// 自己為接話人:找出密我的人
				hqlString += "Order by c_time desc";

				lastConversation.add(conversationDaoImpl.selectHql(hqlString));
			}
			System.out.println("lastConversation = " + lastConversation);
			return lastConversation;
		} catch (SQLException e) {
			System.out.println("ConversationService - getConversationTalker - SQLException");
			e.printStackTrace();
			return null;
		}
	}

}
