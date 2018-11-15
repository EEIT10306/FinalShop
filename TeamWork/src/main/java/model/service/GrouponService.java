package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Groupon;
import model.bean.StoreProduct;
import model.bean.Wish;
import model.bean.WishBid;
import model.repository.GrouponDao;

@Service
@Transactional
public class GrouponService {

	@Autowired
	private GrouponDao GrouponDaoImpl;

	

	public List<Groupon> getGrouponSearch(String search) {
		String str = "";
		if (search != null) {
			str += "Where g_title like '%" + search + "%' or g_context like '%" + search + "%' ";
		}
		try {
			List<Groupon> list = GrouponDaoImpl.selectHql(str);
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
	
	public List<Groupon> getGrouponSearchChange(String search,String a,String b,String c,String d,String e,String f){
		String str="";
		 List<String> list = new ArrayList<>();
		str += "Where (g_title like '%"+search+"%' or g_context like '%" +search+"%') and DistrictType.p_name like '%" +f+"%' ";
		
		str += (a!=null)?" and product.p_parentsId ="+ a+ " ":"";
		str += (b!=null)?" and product.p_id ="+ b+" ":"";
		str+=" and (sP_new ="+c;
		str+=" or sP_new ="+d+")";
		if(!e.equals("null")) {
		if(e.equals("1")){
			System.out.println("wwwewe");
			str +="";
			}else if(e.equals("2")){
				str +=" order by g_sumPrice";
			}else if(e.equals("3")){str +=" order by g_endDate desc";
			}else 
				str +=" order by g_endDate";
			
		}
		
		try {
			List<Groupon> lis = GrouponDaoImpl.selectHql(str);
//			for(Groupon sp:lis) {
//				sp.getGroupImages().iterator();
//			}
			return lis;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
		
	}
	
}
