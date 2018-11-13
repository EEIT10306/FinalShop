package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import model.bean.GroupProduct;
import model.bean.StoreProduct;
import model.bean.WishProduct;
import model.service.GroupProductService;
import model.service.ImageService;
import model.service.SellerVerifyService;
import model.service.StoreProductService;
import model.service.WishProductService;

@Controller
public class AddProductController {

	@Autowired
	StoreProductService storeProductService;
	@Autowired
	GroupProductService groupProductService;
	@Autowired
	WishProductService wishProductService;
	@Autowired
	SellerVerifyService sellerVerifyService;
	@Autowired
	ImageService imageService;

	// 新增開店
	@RequestMapping(value = "/AddStoreProduct", method = RequestMethod.POST)
	@ResponseBody
	private String AddStoreProduct(StoreProduct storeProduct) {
		Gson gson = new Gson();
		System.out.println(storeProduct.toString());
		System.out.println("AddStoreProduct");
		storeProduct.setS_id(1);
		storeProduct.setsP_hot(5);
		storeProduct.setsP_amountFavorite(4);
		storeProduct.setsP_time(new Date());
		storeProduct.setsP_averageAssess(2.0);
		storeProduct.setsP_amountAssess(1);
		storeProduct.setsP_stateId(13);
		StoreProduct list = storeProductService.insert(storeProduct);
		String json = gson.toJson(list);

		System.out.println("Storejson = " + json);
		return json;

	}
	// 新增開團
	@RequestMapping(value = "/AddGroupon", method = RequestMethod.POST)
	@ResponseBody
	private String AddGroupon(GroupProduct groupProduct) {
		Gson gson = new Gson();
		groupProduct.setG_iD(5);
		groupProduct.setgP_stateId(53);
		GroupProduct list = groupProductService.insert(groupProduct);
		String json = gson.toJson(list);
		System.out.println("Grouponjson = "+json);
		return json;
	}
	// 新增許願
	@RequestMapping(value = "/AddWish", method = RequestMethod.POST)
	@ResponseBody
	private String AddWish(WishProduct wishProduct) {
		Gson gson = new Gson();
		wishProduct.setW_id(5);
		wishProduct.setwP_stateId(32);
		WishProduct list = wishProductService.insert(wishProduct);
		String json = gson.toJson(list);
		System.out.println("Wishjson = "+json);
		return json;
	}
	// 會員Account取得賣家ID
	@RequestMapping(value = "/accountVerifySeller", method = RequestMethod.POST)
	@ResponseBody
	private Integer accountVerifySeller(String account) {
		System.out.println(account);
		Integer SellerID = sellerVerifyService.AccountVerifySellerData(account);
		System.out.println("SellerID=" + SellerID);
		return SellerID;
	}
	//驗證是否有店家ID 要不要判斷有無賣家
	@RequestMapping(value = "/accountVerifyStore", method = RequestMethod.POST)
	@ResponseBody
	private Integer accountVerifyStore(String account) {
		System.out.println(account);
		Integer SellerID = sellerVerifyService.AccountVerifySellerData(account);
		Integer StoreID = sellerVerifyService.accountVerifyStore(SellerID);
		System.out.println("StoreID=" + StoreID);
		return StoreID;
	}
	//沒用到的單圖檔上傳 只傳圖檔
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String upload(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getOriginalFilename());
		System.out.println();
		return null;
	}
	//多圖檔上傳 傳圖檔和商品名稱or開團名稱or許願名稱
	@RequestMapping(value = "/uploadmutipart", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String uploadmutipart(@RequestParam("file") List<MultipartFile> files,
			@RequestParam("te") String te,@RequestParam String inputstr) throws IOException {
//		MultipartFile file = null;
		System.out.println(files);
		System.out.println("==================="+files.get(0));
		System.out.println("==================="+files.get(1));
		System.out.println(inputstr);
//		for (int i = 0; i < files.length; i++) {
//			System.out.println("for="+te);
//			file = files[i];
//			System.out.println("for="+file.getOriginalFilename());
//		}
		Integer spid = null;
		Integer gpid = null;
		Integer wpid = null;
		if(inputstr=="Wish"||"Wish".equals(inputstr)) {
			//取得wpid
			try {
				wpid = wishProductService.wPnameToID(te);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("wpid============="+wpid);
			//執行上傳圖片方法
			for(MultipartFile file : files) {			
				imageService.insertWishProductImage(file, wpid);
			}
		} else if(inputstr=="Group"||"Group".equals(inputstr)) {
			//取得gpid
			try {
				gpid = groupProductService.gPnameToID(te);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("gpid========="+gpid);
			//執行上傳圖片方法
			for(MultipartFile file : files) {			
				imageService.insertGroupProductImage(file, gpid);
			}
		} else if(inputstr=="Store"||"Store".equals(inputstr)) {
			//取得spid
			try {
				spid = storeProductService.sPnameToID(te);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("spid=========="+spid);
			//執行上傳圖片方法
			for(MultipartFile file : files) {			
				imageService.insertStoreProductImage(file, spid);
			}
		}

		return "success";
	}
}
