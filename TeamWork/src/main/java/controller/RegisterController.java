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
		if (member.getM_account() == null|| member.getM_account().trim().length() == 0) {
			return "accountNull";
		} else {
			member.setM_account(replaceSpecialCharater(member.getM_account()));
		}
		if (member.getM_password() == null|| member.getM_password().trim().length() == 0) {
			return "passwordNull";
		} else if(member.getM_password() != null|| member.getM_password().trim().length() != 0) {
			member.setM_password(replaceSpecialCharater(member.getM_password()));
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(member.getM_password());
			if (matcher.matches()) {
				member.setM_password(replaceSpecialCharater(member.getM_password()));
			} else {
				return "passwordNull";
			}
		}
		if (member.getM_name() == null|| member.getM_name().trim().length() == 0) {
			return "accountNull";
		} else {
			member.setM_name(replaceSpecialCharater(member.getM_name()));
		}
		
		//呼叫model
		//根據model執行結果，導向view
		if(ms.idExists(member.getM_account())) {
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


