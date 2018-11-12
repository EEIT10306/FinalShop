package model.service;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import model.bean.GroupImages;
import model.bean.StoreImages;
import model.bean.WishImages;
import model.repository.Impl.GroupImagesDaoImpl;
import model.repository.Impl.StoreImagesDaoImpl;
import model.repository.Impl.WishImagesDaoImpl;

@Service
@Transactional
public class ImageService {

	private static String SetImagePath = "C:/EEIT10306/TeamWork/repository/TeamWork/src/main/webapp/web/images/product/";
	private static String GetImagePath = "/TeamWork/web/images/product/";
	private StoreImages SI;
	private GroupImages GI;
	private WishImages WI;
	@Autowired
	private StoreImagesDaoImpl storeImagesDaoImpl;
	@Autowired
	private GroupImagesDaoImpl groupImagesDaoImpl;
	@Autowired
	private WishImagesDaoImpl wishImagesDaoImpl;

	public void saveImage(MultipartFile file, String fileName) throws IllegalStateException, IOException {
		file.transferTo(new File(SetImagePath + fileName));
	}

	public boolean insertStoreProductImage(MultipartFile file, Integer sP_id) {
		try {
			int count = storeImagesDaoImpl.selectHql("Where sP_id = " + sP_id).size();
			String fileName = "sP_" + sP_id + "_" + (count + 1) + "." + file.getContentType().split("/")[1];

			saveImage(file, fileName);

			String filePath = GetImagePath + fileName;

			SI = new StoreImages(null, sP_id, filePath);

			storeImagesDaoImpl.insert(SI);

			return true;
		} catch (IllegalStateException | IOException e) {
			System.err.println("ImageService - saveImage() - IllegalStateException | IOExceptio");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.err.println("ImageService - insertStoreProductImage() - SQLException");
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertGroupProductImage(MultipartFile file, Integer gP_id) {
		try {
			int count = groupImagesDaoImpl.selectHql("Where gP_id = " + gP_id).size();
			String fileName = "gP_" + gP_id + "_" + (count + 1) + "." + file.getContentType().split("/")[1];

			saveImage(file, fileName);

			String filePath = GetImagePath + fileName;

			GI = new GroupImages(null, gP_id, filePath);

			groupImagesDaoImpl.insert(GI);

			return true;
		} catch (IllegalStateException | IOException e) {
			System.err.println("ImageService - saveImage() - IllegalStateException | IOExceptio");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.err.println("ImageService - insertGroupProductImage() - SQLException");
			e.printStackTrace();
			return false;
		}
	}

	public boolean insertWishProductImage(MultipartFile file, Integer wP_id) {
		try {
			int count = wishImagesDaoImpl.selectHql("Where wP_id = " + wP_id).size();
			String fileName = "wP_" + wP_id + "_" + (count + 1) + "." + file.getContentType().split("/")[1];

			saveImage(file, fileName);

			String filePath = GetImagePath + fileName;

			WI = new WishImages(null, wP_id, filePath);

			wishImagesDaoImpl.insert(WI);

			return true;
		} catch (IllegalStateException | IOException e) {
			System.err.println("ImageService - saveImage() - IllegalStateException | IOExceptio");
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			System.err.println("ImageService - insertWishProductImage() - SQLException");
			e.printStackTrace();
			return false;
		}
	}

}
