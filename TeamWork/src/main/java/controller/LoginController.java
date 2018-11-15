package controller;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import model.bean.Member;
import model.service.MemberService;

/**
 * ░░░░░░░░░░░░░░░░░░░░░░░░▄░░
 * ░░░░░░░░░▐█░░░░░░░░░░░▄▀▒▌░
 * ░░░░░░░░▐▀▒█░░░░░░░░▄▀▒▒▒▐
 * ░░░░░░░▐▄▀▒▒▀▀▀▀▄▄▄▀▒▒▒▒▒▐
 * ░░░░░▄▄▀▒░▒▒▒▒▒▒▒▒▒█▒▒▄█▒▐
 * ░░░▄▀▒▒▒░░░▒▒▒░░░▒▒▒▀██▀▒▌
 * ░░▐▒▒▒▄▄▒▒▒▒░░░▒▒▒▒▒▒▒▀▄▒▒
 * ░░▌░░▌█▀▒▒▒▒▒▄▀█▄▒▒▒▒▒▒▒█▒▐
 * ░▐░░░▒▒▒▒▒▒▒▒▌██▀▒▒░░░▒▒▒▀▄
 * ░▌░▒▄██▄▒▒▒▒▒▒▒▒▒░░░░░░▒▒▒▒
 * ▀▒▀▐▄█▄█▌▄░▀▒▒░░░░░░░░░░▒▒▒
 * 單身狗就這樣看著你。
 */

@Controller
public class LoginController {
	private static final long serialVersionUID = 1L;
	// 
	// 設定密碼欄位必須由大寫字母、小寫字母、數字與 !@#$%!^'" 等四組資料組合而成，且長度不能小於八個字元
	// 
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%!^'\"]).{8,})";
	private Pattern pattern = null;
	private Matcher matcher = null;
	
	@Autowired
	MemberService memberService;
	
	@RequestMapping(value = "/LoginServlet" , method = RequestMethod.POST ,produces = "application/json; charset=utf-8")
	@ResponseBody
	private String LogingServlet(Member member) {
		System.out.println("LoginServlet");
		Gson gson = new Gson();
		//接收資料
		//驗證資料
		// 如果 member.getM_account() 欄位為空白，回傳字串accountNull到form_login.html
		if (member.getM_account() == null || member.getM_account().trim().length() == 0) {
			return "accountNull";
		}
		if (member.getM_password() == null || member.getM_password().trim().length() == 0) {
			return "passwordNull";
		} 
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
		//呼叫model
		
		String hql = "WHERE m_account = '"+member.getM_account()
		            +"' and m_password = '"+member.getM_password()+"'";
		List<Member> bean = null;
		try {
			bean = memberService.selectHql(hql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(bean);
		//根據model執行結果，導向view
		if(bean.size()==0) {
			return "beanNull";
		} else {
			String json = gson.toJson(bean);
			return json;
		}
	
	}
	
	private String replaceSpecialCharater(String value) {
		value = value.replaceAll("<", "&lt;");
		value = value.replaceAll(">", "&gt;");
		return value;
	}
	
	@RequestMapping(value = "/LoginFb" , method = RequestMethod.POST ,produces="text/html;charset=utf-8")
	@ResponseBody
	private String LogingFbServlet(String userInfo) {
		System.out.println("LoginFb ="+userInfo);
		//接收資料
		JSONObject json = new JSONObject(userInfo);
		System.out.println(json.getString("email"));
		//驗證資料

		//呼叫model
		
		String hql = "WHERE m_account = '"+json.getString("email")
		            +"' and m_password = 'facebook'";
		List<Member> bean = null;
		try {
			bean = memberService.selectHql(hql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println(bean);
		for(Member mbean:bean) {
			if(memberService.idExists(mbean.getM_account())) {
				//根據model執行結果，導向view
				System.out.println("抓FB帳號=" + mbean.getM_account());
				if(bean.size()==0) {
					return "beanNull";
				} else {
					return mbean.getM_account();
				}
			}
		}
		return "existsAccount";

	}
	
	@RequestMapping(value = "/LoginGg" , method = RequestMethod.POST ,produces="text/html;charset=utf-8")
	@ResponseBody
	private String LogingGgServlet(String userInfo) {
		System.out.println("LoginGg");
		//接收資料
		JSONObject json = new JSONObject(userInfo);
		System.out.println(json.getString("email"));
		//驗證資料

		//呼叫model
		
		String hql = "WHERE m_account = '"+json.getString("email")
		            +"' and m_password = 'google'";
		List<Member> bean = null;
		try {
			bean = memberService.selectHql(hql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(bean);
		for(Member mbean:bean) {
			if(memberService.idExists(mbean.getM_account())) {
				//根據model執行結果，導向view
				System.out.println("抓google帳號=" + mbean.getM_account());
				if(bean.size()==0) {
					return "beanNull";
				} else {
					return mbean.getM_account();
				}
			}
		}
		return "existsAccount";
		
	
	}
	
	@RequestMapping(value = "/checkAccount" , method = RequestMethod.POST ,produces = "application/json; charset=utf-8")
	@ResponseBody
	private String checkAccount(Member member) {
		System.out.println("LoginCheckAccount");
		//接收資料
		//驗證資料
		//呼叫model
		Gson gson = new Gson();
		System.out.println(member);
		String hql = "WHERE m_account = '"+member.getM_account()+"'";
		
		List<Member> bean = null;
		
		try {
			bean = memberService.selectHql(hql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(bean);
		if(bean.size()==0||bean.isEmpty()||bean==null) {
			return "accountNoRepeat";
		}
		String json = gson.toJson(bean);
		return json;
//		for(Member mbean:bean) {
//			System.out.println(mbean);
//			if("facebook".equals(mbean.getM_password()) || mbean.getM_password()=="facebook"){
//				System.out.println("FB帳號");
//				return mbean.getM_account().toString()+"facebook";
//			} else if("google".equals(mbean.getM_password()) || mbean.getM_password()=="google") {
//				System.out.println("google帳號");
//				return mbean.getM_account().toString()+"google";
//			} else {
//				System.out.println("一般帳號");
//				return mbean.getM_account().toString();
//			}
//			
//		}
//		return "account";
	}
}
