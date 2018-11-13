package model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import model.bean.Member;
import model.bean.WishImages;
import model.repository.Impl.MemberDaoImpl;

@Service
@Transactional
public class UserPageImageService {

	private static String SetAccountImagePath = "C:/EEIT10306/TeamWork/repository/TeamWork/src/main/webapp/web/images/user/account/";
	private static String GetAccountImagePath = "/TeamWork/web/images/user/account/";
	@Autowired
	private MemberDaoImpl memberDaoImpl;

	public void saveAccountImage(MultipartFile file, String fileName) throws IllegalStateException, IOException {
		file.transferTo(new File(SetAccountImagePath + fileName));
	}

	public boolean insertAccountImage(MultipartFile file, Integer m_id) {
		try {
			String fileName = "m_photo_" + m_id + "." + file.getContentType().split("/")[1];
			saveAccountImage(file, fileName);
			String filePath = GetAccountImagePath + fileName;
			Member member = memberDaoImpl.selectByPk(m_id);
			member.setM_photo(filePath);
			return true;
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
