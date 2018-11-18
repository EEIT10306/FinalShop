package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import model.bean.DistrictType;
import model.bean.GroupProduct;
import model.bean.StoreProduct;
import model.bean.Wish;
import model.bean.WishProduct;
import model.bean.wishandproduct;
import model.service.DistrictService;
import model.service.GroupProductService;
import model.service.ImageService;
import model.service.SellerVerifyService;
import model.service.StoreProductService;
import model.service.WishProductService;
import model.service.WishService;

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
	@Autowired
	DistrictService districtService;
	@Autowired
	WishService wishService;

	// 新增開店
	@RequestMapping(value = "/AddStoreProduct", method = RequestMethod.POST)
	@ResponseBody
	private String AddStoreProduct(StoreProduct storeProduct) {
		Gson gson = new Gson();
		System.out.println(storeProduct.toString());
		System.out.println("AddStoreProduct");
		storeProduct.setsP_hot(0);
		storeProduct.setsP_amountFavorite(0);
		storeProduct.setsP_time(new Date());
		storeProduct.setsP_averageAssess(0.0);
		storeProduct.setsP_amountAssess(0);
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
		System.out.println("Grouponjson = " + json);
		return json;
	}

	// 新增許願
	@RequestMapping(value = "/AddWish", method = RequestMethod.POST)
	@ResponseBody
	private String AddWish(WishProduct wishProduct) {
		Gson gson = new Gson();
//		wishProduct.setW_id(5);
//		wishProduct.setwP_stateId(32);
		WishProduct list = wishProductService.insert(wishProduct);
		String json = gson.toJson(list);
		System.out.println("Wishjson = " + json);
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

	// 驗證是否有店家ID 要不要判斷有無賣家
	@RequestMapping(value = "/accountVerifyStore", method = RequestMethod.POST)
	@ResponseBody
	private Integer accountVerifyStore(String account) {
		System.out.println(account);
		Integer SellerID = sellerVerifyService.AccountVerifySellerData(account);
		Integer StoreID = sellerVerifyService.accountVerifyStore(SellerID);
		System.out.println("StoreID=" + StoreID);
		return StoreID;
	}

	// 沒用到的單圖檔上傳 只傳圖檔
	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String upload(@RequestParam("file") MultipartFile file) throws IOException {
		System.out.println(file.getOriginalFilename());
		System.out.println();
		return null;
	}

	// 多圖檔上傳 傳圖檔和商品名稱or開團名稱or許願名稱
	@RequestMapping(value = "/uploadmutipart", method = RequestMethod.POST, produces = MediaType.TEXT_PLAIN_VALUE)
	public @ResponseBody String uploadmutipart(@RequestParam("file") List<MultipartFile> files,
			@RequestParam("te") String te, @RequestParam String inputstr) throws IOException {
//		MultipartFile file = null;
		System.out.println(files);
		System.out.println("===================" + files.get(0));
		System.out.println(inputstr);
//		for (int i = 0; i < files.length; i++) {
//			System.out.println("for="+te);
//			file = files[i];
//			System.out.println("for="+file.getOriginalFilename());
//		}
		Integer spid = null;
		Integer gpid = null;
		Integer wpid = null;
		if (inputstr == "Wish" || "Wish".equals(inputstr)) {
			// 取得wpid
			try {
				wpid = wishProductService.wPnameToID(te);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("wpid=============" + wpid);
			// 執行上傳圖片方法
			for (MultipartFile file : files) {
				imageService.insertWishProductImage(file, wpid);
			}
		} else if (inputstr == "Group" || "Group".equals(inputstr)) {
			// 取得gpid
			try {
				gpid = groupProductService.gPnameToID(te);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("gpid=========" + gpid);
			// 執行上傳圖片方法
			for (MultipartFile file : files) {
				imageService.insertGroupProductImage(file, gpid);
			}
		} else if (inputstr == "Store" || "Store".equals(inputstr)) {
			// 取得spid
			try {
				spid = storeProductService.sPnameToID(te);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("spid==========" + spid);
			// 執行上傳圖片方法
			for (MultipartFile file : files) {
				imageService.insertStoreProductImage(file, spid);
			}
		}

		return "success";
	}

	@ResponseBody
	@RequestMapping(path = "/changeDistFormSelect", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
//	public List<Product> search(Product product) {
	public String districtsearch() {
		List<DistrictType> lis = districtService.selectAll();

		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		String json = gson.toJson(lis);


		return json;
	}
	
	// 新增許願
	@RequestMapping(value = "/AddWishandProduct", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	private String AddWishandProduct(@RequestBody wishandproduct wishjson) {
		System.out.println("======================================");
		System.out.println(wishjson.getM_id());
		System.out.println("======================================");
		Gson gson = new Gson();
		Wish wish = new Wish();
		wish.setM_id(wishjson.getM_id());
		wish.setP_id(wishjson.getP_id());
		wish.setW_title(wishjson.getW_title());
		wish.setW_context(wishjson.getW_context());
		wish.setD_id(wishjson.getD_id());
		wish.setW_startDate(wishjson.getW_startDate());
		wish.setW_endDate(wishjson.getW_endDate());
		wish.setW_changeTime(new Date());
		wish.setW_hot(0);
		wish.setW_amountFavorite(0);
		wish.setW_stateId(28);
//		System.out.println(wish.toString());
		Wish wishlist = wishService.insert(wish);
		System.out.println("======================");
		System.out.println(wishlist);
		WishProduct wishProduct = new WishProduct();
		wishProduct.setW_id(wishlist.getW_id());
		wishProduct.setwP_name(wishjson.getwP_name());
		wishProduct.setP_id(wishjson.getP_id());
		wishProduct.setwP_amount(wishjson.getwP_amount());
		wishProduct.setwP_priceBottom(wishjson.getwP_priceBottom());
		wishProduct.setwP_priceTop(wishjson.getwP_priceTop());
		wishProduct.setwP_stateId(32);
		System.out.println(wishProduct);
		WishProduct list = wishProductService.insert(wishProduct);
		String json = gson.toJson(list);
		System.out.println("Wishjson = " + json);
		return json;
//		Gson gson = new Gson();
//		wishProduct.setW_id(5);
//		wishProduct.setwP_stateId(32);
//		WishProduct list = wishProductService.insert(wishProduct);
//		String json = gson.toJson(list);
//		System.out.println("Wishjson = " + json);
//		return json;
	}
}
