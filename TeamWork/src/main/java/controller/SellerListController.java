package controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import model.bean.Member;
import model.bean.StoreImages;
import model.bean.StoreOrder;
import model.bean.StoreProduct;
import model.bean.Wish;
import model.bean.WishOrder;
import model.service.ImageService;
import model.service.SellerService;

@Controller
public class SellerListController {

	@Autowired
	SellerService sellerService;
	@Autowired
	ImageService imageService;

	@InitBinder
	protected void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	}

	// 賣家下架商城商品
	@RequestMapping(path = "/CancelStoreProduct", method = RequestMethod.GET)
	public String cancelStoreProduct(StoreProduct storeProduct) throws SQLException {
		sellerService.cancelStoreProduct(storeProduct);
		return "redirect:/web/view/userPage_StoreProductList.html";
	}

	// 重新編輯商店商品資料
	@RequestMapping(path = "/EditStoreProduct", method = RequestMethod.POST)
	public String editStoreProduct(List<MultipartFile> files, StoreProduct storeProduct, BindingResult binder,
			StoreImages storeImages) throws SQLException {
		System.out.println("UpdateAccountImage-files:===========" + files);
		sellerService.updateStoreProductData(storeProduct);
		// 先刪除此商品ID的關聯圖片
		sellerService.deleteStoreProductAllImagesById(storeImages);		
		// 執行上傳圖片方法
		for (MultipartFile file : files) {
			imageService.insertStoreProductImage(file, storeProduct.getsP_id());
		}
		return "redirect:/web/view/userPage_StoreProductList.html";
	}

	// 用會員ID取得商店上架商品的資料(賣家)
	@RequestMapping(path = "/StoreProductSellerListByM_id", method = RequestMethod.GET, produces = {
			"application/json" })
	@ResponseBody
	public List<StoreProduct> getStoreProductSellerListByM_id(Member member, BindingResult binder) throws SQLException {
		List<StoreProduct> temps = sellerService.getStoreProductSellerListByM_id(member);
		System.out.println(temps);
		return temps;
	}

	// 用會員ID取得該使用者之商店的訂單資料(賣家)
	@RequestMapping(path = "/StoreOrderSellerListByM_id", method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<StoreOrder> getStoreOrderSellerListByM_id(Member member, BindingResult binder) throws SQLException {
		List<StoreOrder> temps = sellerService.getStoreOrderSellerListByM_id(member);
		System.out.println(temps);
		return temps;
	}

	// 編輯願望
	@RequestMapping(path = "/EditWish", method = RequestMethod.POST)
	public String editWish(Wish wish, BindingResult binder) throws SQLException {
		Wish temp = sellerService.editWish(wish);
		System.out.println(temp);
		return "redirect:/web/view/userPage_WishList.html";
	}

	// 下架願望
	@RequestMapping(path = "/CancelWish", method = RequestMethod.POST)
	public String Wish(Wish wish, BindingResult binder) throws SQLException {
		Wish temp = sellerService.cancelWish(wish);
		System.out.println(temp);
		return "redirect:/web/view/userPage_WishList.html";
	}

}
