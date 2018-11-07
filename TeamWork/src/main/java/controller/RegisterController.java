package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
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
	MemberService memberservice;
	
	@RequestMapping(value = "/RegisterServlet" , method = RequestMethod.POST )
	@ResponseBody
	private String RegisterServlet(Member member) {
		System.out.println("RegisterServlet");
		//接收資料
		//驗證資料
		if (member.getM_account() == null|| member.getM_account().trim().length() == 0) {
			return "accountNull";
		} else {
			member.setM_account(replaceSpecialCharater(member.getM_account()));
		}
		if (member.getM_password() == null|| member.getM_password().trim().length() == 0) {
			return "passwordNull";
		}
		//負責密碼複雜度
//		else if(member.getM_password() != null|| member.getM_password().trim().length() != 0) {
//			member.setM_password(replaceSpecialCharater(member.getM_password()));
//			pattern = Pattern.compile(PASSWORD_PATTERN);
//			matcher = pattern.matcher(member.getM_password());
//			if (matcher.matches()) {
//				member.setM_password(replaceSpecialCharater(member.getM_password()));
//			} else {
//				return "passwordNull";
//			}
//		}
		if (member.getM_name() == null|| member.getM_name().trim().length() == 0) {
			return "accountNull";
		} else {
			member.setM_name(replaceSpecialCharater(member.getM_name()));
		}
		
		//呼叫model
		//根據model執行結果，導向view
		if(memberservice.idExists(member.getM_account())) {
			return "existsAccount";
		} else {
			try {
				memberservice.insert(member);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return member.getM_account().toString();
		}
		
		
	}
	
	private String replaceSpecialCharater(String value) {
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll(">", "&gt;");
		return value;
	}
	
	@RequestMapping(value = "/FBRegister", method = RequestMethod.POST)
	@ResponseBody
	public String getFbUserInfo(String userInfo) {
		System.out.println(userInfo);
		JSONObject json = new JSONObject(userInfo);
		System.out.println(json.getString("email"));
		
		if(memberservice.idExists(json.getString("email"))) {
			return "existsAccount";
		} else {
			try {
				Member member = new Member();
				member.setM_account(json.getString("email"));
				member.setM_password("facebook");
				member.setM_name(json.getString("name"));
				member.setM_mail(json.getString("email"));
				memberservice.insert(member);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("註冊成功");
			return "account";
		}
	}
	
	@RequestMapping(value = "/GoogleRegister", method = RequestMethod.POST)
	@ResponseBody
	public String getGgUserInfo(String userInfo) {
		System.out.println(userInfo);
		JSONObject json = new JSONObject(userInfo);
		System.out.println(json.getString("email"));
		
		if(memberservice.idExists(json.getString("email"))) {
			return "existsAccount";
		} else {
			try {
				Member member = new Member();
				member.setM_account(json.getString("email"));
				member.setM_password("google");
				member.setM_name(json.getString("name"));
				member.setM_mail(json.getString("email"));
				memberservice.insert(member);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "account";
		}
		
	}
}


