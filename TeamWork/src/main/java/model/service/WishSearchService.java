package model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreProduct;
import model.bean.Wish;
import model.bean.WishBid;
import model.repository.StoreProductDao;
import model.repository.WishBidDao;
import model.repository.WishDao;

@Service
@Transactional
public class WishSearchService {

	@Autowired
	private StoreProductDao storeProductDaoImpl;
	@Autowired
	private WishBidDao wishBidDao;
	@Autowired
	private WishDao wishdaoImpl;

	public List<StoreProduct> getStoreProductForm(String storeProduct) {
		String str = "";
		if (storeProduct != null) {
			str += "Where sP_name like '%" + storeProduct + "%' or sP_context like '%" + storeProduct + "%' ";

		}
//		as sp left join sp.product as pro left join sp.state as st
		try {
			List<StoreProduct> list = storeProductDaoImpl.selectHql(str);
//			for(StoreProduct sp:list) {
//				Iterator<StoreImages> it = sp.getStoreImages().iterator();
//				while(it.hasNext()) {
//					it.next().setStoreProduct(null);
//					
//				};
//			}
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}

	}

	public List<WishBid> getWishBidListByW_id(Wish wish) throws SQLException {
		Integer w_id = wish.getW_id();
		if (w_id != null) {
			String hqlString = "WHERE w_id = " + w_id;
			return wishBidDao.selectHql(hqlString);
		} else {
			return wishBidDao.selectAll();
		}
	}

	public List<Wish> getWishLoadList(String search) {
		String str = "";
		if (search != null) {
			str += "Where w_title like '%" + search + "%' or w_context like '%" + search + "%' ";

			try {
				return wishdaoImpl.selectHql(str);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;

	}

	public List<Wish> getWishCheage(String search, String a, String b, String c, String d, String e, String f) {
		String str = "";
		 
//		if(e!=null) {		
//			e1 = Integer.parseInt(e);
//		}
//		if(f!=null) {		
//			f1 = Integer.parseInt(f);
//		}
		str += "Where (w_title like '%" + search + "%' or w_context like '%" + search + "%') ";
		str += (a != null) ? " and product.p_parentsId =" + a + " " : "";
		str += (b != null) ? " and product.p_id =" + b + " " : "";
		str += (c != null && d != null) ? " and (sP_price > " + c + " and sP_price<" + d + ") " : "";
		System.out.println("e="+e);
		System.out.println("f="+f);
//		if(f!=null) {	
//		
//		if (f=="0"||f.equals("0")) {
//			str += "and districtType.d_id > 0";
//		} else if (f.equals("1")||f=="1") {
//			str += "and (districtType.d_id >1 and districtType.d_id<31)";
//		} 
////		else if (e < 31) {
////			str += "and districtType.d_parentsId = " + e;} 
//		else if (f.equals("31")||f=="31") {
//			str += "and districtType.d_id >31";
//		} else if (f.equals("32")||f=="32") {
//			str += "and (districtType.d_parentsId =40 and districtType.d_parentsId = 41 and districtType.d_parentsId = 42 and districtType.d_parentsId = 43)";
//		} else if (f.equals("33")||f=="34") {
//			str += "and (districtType.d_parentsId >43 and districtType.d_parentsId <50)";
//		} else if (f.equals("34")||f=="34") {
//			str += "and (districtType.d_parentsId >49 and districtType.d_parentsId <57)";
//		} else if (f.equals("35")||f=="35") {
//			str += "and (districtType.d_parentsId >56 and districtType.d_parentsId <66)";
//		} else if (f.equals("36")||f=="36") {
//			str += "and (districtType.d_parentsId >65 and districtType.d_parentsId <73)";
//		} else if (f.equals("37")||f=="37") {
//			str += "and (districtType.d_parentsId >72 and districtType.d_parentsId <78)";
//		} else if (f.equals("38")||f=="38") {
//			str += "and (districtType.d_parentsId >77 and districtType.d_parentsId <82)";
//		} else if (f.equals("39")||f=="39") {
//			str += "and (districtType.d_parentsId >81 and districtType.d_parentsId <90)";
//		}else {
//			str += "and districtType.d_parentsId = " + f;
//		}
//		}else {
//			f="";
//		}
		
		if(f!=null) {	
					
			Integer f1 = Integer.parseInt(f);
			
			if (f1==0) {
				str += "and districtType.d_id > 0";
			} else if (f1==1 ){
				str += "and (districtType.d_id >1 and districtType.d_id<31)";
			} 
			else if ((f1>8&&f1<31) ||f1>89) {
				str += "and districtType.d_id = " + f;} 
			else if (f1==31) {
				str += "and districtType.d_id >31";
			} else if (f1==32) {
				str += "and (districtType.d_parentsId =40 and districtType.d_parentsId = 41 and districtType.d_parentsId = 42 and districtType.d_parentsId = 43)";
			} else if  (f1==33) {
				str += "and (districtType.d_parentsId >43 and districtType.d_parentsId <50)";
			} else if (f1==34)  {
				str += "and (districtType.d_parentsId >49 and districtType.d_parentsId <57)";
			} else if (f1==35) {
				str += "and (districtType.d_parentsId >56 and districtType.d_parentsId <66)";
			} else if (f1==36) {
				str += "and (districtType.d_parentsId >65 and districtType.d_parentsId <73)";
			} else if (f1==37) {
				str += "and (districtType.d_parentsId >72 and districtType.d_parentsId <78)";
			} else if (f1==38) {
				str += "and (districtType.d_parentsId >77 and districtType.d_parentsId <82)";
			} else if (f1==39) {
				str += "and (districtType.d_parentsId >81 and districtType.d_parentsId <90)";
			}else {
				str += "and districtType.d_parentsId = " + f;
			}
			}else {
				f="";
			}
//		str += (e != null) ? " and districtType.d_parentsId =" + e + " " : "";

//		if (!e.equals("0") || e!= "0"||e!=null) {
		if(e==null) {
			e="";
		}
			if (e.equals("1")||e == "1" ){
				System.out.println("wwwewe");
				str += " order by w_amountFavorite desc";
			} else if (e.equals("2")) {

				str += " order by w_hot desc ";
			} else if (e.equals("3")) {
				str += " order by w_startDate ";
			} else if (e.equals("4")) {
				str += " order by w_endDate desc";
			} else if (e.equals("5")) {
				str += " order by w_sumPriceBottom desc";
			} else if (e.equals("6")) {
				str += " order by w_sumPriceTop";
			}
			
		
//		if(f!= 0) {
//			if (f==1) {
//				System.out.println("wwwewe");
//				str += " order by w_amountFavorite desc";
//			} else if (f==2) {
//
//				str += " order by w_hot desc ";
//			} else if (f==3) {
//				str += " order by w_startDate ";
//			} else if (f==4) {
//				str += " order by w_endDate desc";
//			} else if (f==5) {
//				str += " order by w_sumPriceBottom desc";
//			} else if (f==6) {
//				str += " order by w_sumPriceTop";
//			}
//			else {
//				str +="";
//			}
//		}
//		

		try {
			System.out.println(str);
			List<Wish> lis = wishdaoImpl.selectHql(str);
//			for(Wish sp:lis) {
//				sp.getWishImages().iterator();
//			}
			return lis;
		} catch (SQLException e11) {
			// TODO Auto-generated catch block
			e11.printStackTrace();
		}
		return null;

	}
	
	public Wish getWishHot(Wish wish) throws SQLException {
		if(wish!=null) {
			Wish bean =wishdaoImpl.selectByPk(wish.getW_id());
			
//			Integer w_id = bean.getW_id();
			bean.setW_hot(bean.getW_hot()+1);	
			return wishdaoImpl.update(bean);
		}
		return null;
		
	
}

}
