package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Conversation;
import model.bean.Member;
import model.repository.ConversationDao;
import model.repository.MemberDao;

@Service
@Transactional
public class ConversationService_forCustomers {
	@Autowired
	private ConversationDao conversationDaoImpl;

	@Autowired
	private MemberDao memberDapImpl;

//	使用者查詢通訊紀錄
	public List<List<Conversation>> getConversationTalker(Conversation conversation) {
		try {
			String hqlString = "Where m_id = ";
			hqlString += conversation.getM_id() + " ";// 自己的ID
			hqlString += "or m_idConversation = ";
			hqlString += conversation.getM_id() + " ";// 自己為接話人:找出密我的人
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

//	新訊息傳入資料庫
	public Conversation addConversationTalker_C(Conversation conversation) {
		try {
			Integer m_id = conversation.getM_id();
			Integer m_idC = findManager().getM_id();
			String c_context = conversation.getC_context();
			Date c_time = new Date();
			if ((memberDapImpl.selectByPk(m_id) != null) && (memberDapImpl.selectByPk(m_idC) != null)
					&& (c_context != null) && (c_context.length() != 0)) {
				Conversation conversation_insert = new Conversation(null, m_idC, m_id, c_context, c_time, 3);
				conversationDaoImpl.insert(conversation_insert);
				System.out.println(conversation_insert);
				return conversation_insert;
			} else {
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//	找出客服人員
	public Member findManager() {
		String hql = "WHERE m_position = 'manager'";
		List<Member> managers = null;
		try {
			managers = memberDapImpl.selectHql(hql);
			Member manager = managers.get(0);
//			System.out.println(manager);
			return manager;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//	更改訊息狀態為"已讀"
	public void updateConversationState_C(Conversation conversation) {
		try {
			String hql = "WHERE c_stateId = 3 AND m_id = ";
			hql += findManager().getM_id();
			hql += " AND m_idConversation = ";
			hql += conversation.getM_id();
			List<Conversation> list = conversationDaoImpl.selectHql(hql);
			if (list.size() != 0) {
				for (int i = 0; i < list.size(); i++) {
					list.get(i).setC_stateId(4);
					conversationDaoImpl.update(list.get(i));
					System.out.println(list.get(0));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//	未讀取的訊息數量
	public Integer checkUnreadMessages_C(Conversation conversation) {
		String hql = "WHERE c_stateId = 3 AND m_id = ";
		hql += findManager().getM_id();
		hql += " AND m_idConversation = ";
		hql += conversation.getM_id();
		List<Conversation> list = null;
		try {
			list = conversationDaoImpl.selectHql(hql);
			int amt = list.size();
			System.out.println(amt);
			return amt;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

//	以email尋找會員資料
	public Integer findMemberInformation(Member member) {
		String hql = "WHERE m_account = '" + member.getM_account() + "'";
		System.out.println(hql);
		List<Member> list = null;
		try {
			list = memberDapImpl.selectHql(hql);
			System.out.println(list);
			Member membersFound = list.get(0);
			Integer m_id = membersFound.getM_id();
			System.out.println("m_id = " + m_id);
			return m_id;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
