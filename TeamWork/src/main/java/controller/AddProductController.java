package controller;

import java.io.IOException;
import java.util.Date;

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

		System.out.println("json = " + json);
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
		System.out.println(list);
		return null;
	}
	// 新增許願
	@RequestMapping(value = "/AddWish", method = RequestMethod.POST)
	@ResponseBody
	private String AddWish(WishProduct wishProduct) {
		Gson gson = new Gson();
		wishProduct.setW_id(5);
		wishProduct.setwP_stateId(32);
		WishProduct list = wishProductService.insert(wishProduct);
		System.out.println(list);
		return null;
	}
	// 驗證是否為賣家
	@RequestMapping(value = "/accountVerifySeller", method = RequestMethod.POST)
	@ResponseBody
	private Integer accountVerifySeller(String account) {
		System.out.println(account);
		Integer SellerID = sellerVerifyService.AccountVerifySellerData(account);
		System.out.println("SellerID=" + SellerID);
		return SellerID;
	}
	// 驗證是否為店家
	@RequestMapping(value = "/accountVerifyStore", method = RequestMethod.POST)
	@ResponseBody
	private Integer accountVerifyStore(String account) {
		System.out.println(account);
		Integer SellerID = sellerVerifyService.AccountVerifySellerData(account);
		System.out.println("SellerID=" + SellerID);
		return SellerID;
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
	public @ResponseBody String uploadmutipart(@RequestParam("file") MultipartFile[] files,
			@RequestParam("te") String te) throws IOException {
		
		for (int i = 0; i < files.length; i++) {
			System.out.println("for"+te);
			MultipartFile file = files[i];
			System.out.println("for"+file.getOriginalFilename());
		}
		return "success";
	}
}
