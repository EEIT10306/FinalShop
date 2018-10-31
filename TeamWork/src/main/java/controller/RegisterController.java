package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.bean.Member;
import model.service.MemberService;

@Controller
public class RegisterController {
	
	private static final long serialVersionUID = 1L;
	// 
	// 設定密碼欄位必須由大寫字母、小寫字母、數字與 !@#$%!^'" 等四組資料組合而成，且長度不能小於八個字元
	// 
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%!^'\"]).{8,})";
	private Pattern pattern = null;
	private Matcher matcher = null;
	
	@Autowired
	MemberService ms;
	
	@RequestMapping(value = "/RegisterServlet" , method = RequestMethod.POST )
	@ResponseBody
	private String RegisterServlet(Member member) {
		System.out.println("RegisterServlet");
		//接收資料
		System.out.println(member);
		//驗證資料
		if (member.getAccount() == null|| member.getAccount().trim().length() == 0) {
			return "accountNull";
		} else {
			member.setAccount(replaceSpecialCharater(member.getAccount()));
		}
		if (member.getPassword() == null|| member.getPassword().trim().length() == 0) {
			return "passwordNull";
		} else if(member.getPassword() != null|| member.getPassword().trim().length() != 0) {
			member.setPassword(replaceSpecialCharater(member.getPassword()));
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(member.getPassword());
			if (matcher.matches()) {
				member.setPassword(replaceSpecialCharater(member.getPassword()));
			} else {
				return "passwordNull";
			}
		}
		if (member.getName() == null|| member.getName().trim().length() == 0) {
			return "accountNull";
		} else {
			member.setName(replaceSpecialCharater(member.getName()));
		}
		
		//呼叫model
		//根據model執行結果，導向view
		if(ms.idExists(member.getAccount())) {
			return "existsAccount";
		} else {
			try {
				ms.insert(member);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "account";
		}
		
		
	}
	
	private String replaceSpecialCharater(String value) {
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll(">", "&gt;");
		return value;
	}
}


