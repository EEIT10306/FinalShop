package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.Conversation;
import model.bean.Member;
import model.service.ConversationService_forCustomers;

@Controller
public class ConversationController {

	@Autowired
	ConversationService_forCustomers conversationService;

	@RequestMapping(value = "/NewConversation", method = RequestMethod.POST)
	@ResponseBody
	private String ConversationServlet(Conversation conversation) {
		System.out.println("============= Insert New Conversation ============= ");
		System.out.println("Conversation = " + conversation);
		if (conversation.getC_context() == null || conversation.getC_context().equals("")) {
			return "Empty Conversation.";
		} else {
			conversationService.addConversationTalker_C(conversation);
			return "Conversation inserted.";
		}
	}

	@RequestMapping(value = "/UnreadMessages", method = RequestMethod.POST)
	@ResponseBody
	private Integer UnreadMessages(Conversation conversation) {
		System.out.println("============= Check Unread Messages ============= ");
		System.out.println("Conversation = " + conversation);
		Integer amt = conversationService.checkUnreadMessages_C(conversation);
		return amt;
	}

	@RequestMapping(value = "/CommunicationsWithCustomerService", method = RequestMethod.POST)
	@ResponseBody
	private List<List<Conversation>> Communications(Conversation conversation) {
		System.out.println("============= Show Conversations ============= ");
		List<List<Conversation>> data = conversationService.getConversationTalker(conversation);
		if(data.size()!=0) {
			System.out.println(data.get(0).get(0).getC_time());
			return data;
		}else {
			return null;
		}
	}

	@RequestMapping(value = "/UpdateConversationState", method = RequestMethod.POST)
	@ResponseBody
	private void UpdateConversationState(Conversation conversation) {
		System.out.println("============= Update Conversation State ============= ");
		conversationService.updateConversationState_C(conversation);
	}

	@RequestMapping(value = "/FindServiceConversationMemberId", method = RequestMethod.POST)
	@ResponseBody
	private Integer FindServiceConversationMemberId(Member member) {
		System.out.println("============= Find Member Information By Account ============= ");
		return conversationService.findMemberInformation(member);
	}
}
