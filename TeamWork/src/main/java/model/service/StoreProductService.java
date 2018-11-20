package model.service;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Store;
import model.bean.StoreProduct;
import model.repository.StoreProductDao;

@Service
@Transactional
public class StoreProductService {
	
	@Autowired
	StoreProductDao storeProductDaoImpl;
	
	public StoreProduct selectByPk(int id) throws SQLException {
		System.out.println(storeProductDaoImpl.selectByPk(id).getStoreImages());
		StoreProduct sp = new StoreProduct();
		sp = storeProductDaoImpl.selectByPk(id);
		sp.setsP_context(sp.getsP_context().replace("\r\n", "<br>"));
		return sp;
	}
	
	public List<StoreProduct> getStoreProductChangeForm(String search,String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m){
		String str="";
		 List<String> list = new ArrayList<>();
		str += "Where (sP_name like '%"+search+"%' or sP_context like '%" +search+"%') " ;
		str += (a!=null)?" and product.p_parentsId ="+ a+ " ":"";
		str += (b!=null)?" and product.p_id ="+ b+" ":"";
		str += (c!=null)?" and sP_averageAssess >= "+c+" ":"";
		if(d!=null||e!=null||f!=null||g!=null||h!=null) {
			if(d!=null) {list.add("sP_transport like '%全家%' ");}
			if(e!=null) {list.add("sP_transport like '%7-11%' ");}
			if(f!=null) {list.add("sP_transport like '%萊爾富%' ");}
			if(g!=null) {list.add("sP_transport like '%中華郵政%' ");}
			if(h!=null) {list.add("sP_transport like '%賣家宅配%' ");}			
			if(list.size()!=5) {
				str += " and (";
				for(String lis : list) {
					str += lis + " or ";
				}
				str = str.substring(0, str.length()-4);
				str += ") ";
			}
		}
//		str += "and (sP_transport="+d+" or sP_transport="+e+" or sP_transport="+f+" or sP_transport="+g+" or sP_transport="+h+")";
		
		
//		if(i==null&&j==null) {
//			str+="";
//		}else {
//			str+=(i!=null)?" and (sP_new ="+i+" ":"";
//			str+=(j!=null)?" and sP_new ="+j+")":"";
//		}
		str+=" and (sP_new ="+i;
		str+=" or sP_new ="+j+")";
		str+=(k!=null&&l!=null)?" and (sP_price > "+k+ " and sP_price<"+l+") ":"";
		if(!m.equals("null")) {
		if(m.equals("1")){
			System.out.println("wwwewe");
			str +=" order by sP_amountFavorite desc";
			}else if(m.equals("2")){
				
				str +=" order by sP_time";
			}else if(m.equals("3")){str +=" order by sP_hot desc";
			}else if(m.equals("4")){str +=" order by sP_price";
			}else {
				
				str +=" order by sP_price desc";}
		}
		
		try {
			List<StoreProduct> lis = storeProductDaoImpl.selectHql(str);
			for(StoreProduct sp:lis) {
				sp.getStoreImages().iterator();
			}
			return lis;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
		
	}
	
	public StoreProduct insert(StoreProduct bean) {
		try {
			return storeProductDaoImpl.insert(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	public Integer sPnameToID(String spname) throws SQLException {
		
		String hql = "WHERE sP_name = '" +  spname + "'";
		//取得商城商品資料
		System.out.println("StorePro=" + storeProductDaoImpl.selectHql(hql));
		// 去找店家家的ID 如果不是NULL就回傳ID
		for (StoreProduct storebean : storeProductDaoImpl.selectHql(hql)) {
			return storebean.getsP_id();
		}
		return null;
		
	}
	
}
