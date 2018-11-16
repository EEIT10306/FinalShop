package model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import model.bean.Member;
import model.repository.Impl.MemberDaoImpl;

@Service
@Transactional
public class UserPageImageService {

	private static String SetAccountImagePath = "C:/EEIT10306/TeamWork/repository/TeamWork/src/main/webapp/web/images/user/account/";
	private static String SetAccountImagePathTomcat = "C:/EEIT10306/TeamWork/apache-tomcat-9.0.11/wtpwebapps/TeamWork/web/images/user/account/";
	private static String GetAccountImagePath = "/TeamWork/web/images/user/account/";
	@Autowired
	private MemberDaoImpl memberDaoImpl;

	public void saveAccountImage(MultipartFile file, String fileName) throws IllegalStateException, IOException {
		file.transferTo(new File(SetAccountImagePath + fileName));
		file.transferTo(new File(SetAccountImagePathTomcat + fileName));
	}

	public boolean insertAccountImage(MultipartFile file, Integer m_id) {
		try {
			if (file.isEmpty() || m_id == null) {
				System.out.println("1");
				return false;
			} else {
				String fileName = "m_photo_" + m_id + "." + file.getContentType().split("/")[1];
				saveAccountImage(file, fileName);
				String filePath = GetAccountImagePath + fileName;
				Member member = memberDaoImpl.selectByPk(m_id);
				member.setM_photo(filePath);
				System.out.println("2");
				System.out.println(member);
				return true;
			}
		} catch (IllegalStateException | IOException e) {
			System.err.println("UserPageImageService - saveAccountImage() - IllegalStateException | IOExceptio");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.err.println("UserPageImageService - insertAccountImage() - SQLException");
			e.printStackTrace();
			return false;
		}
	}

}
