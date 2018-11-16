package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.Product;
import model.bean.StoreProduct;
import model.repository.ProductDao;
import model.repository.StoreProductDao;

@Service
@Transactional
public class StoreSearchService {

	@Autowired
	private StoreProductDao storeProductDaoImpl;

	
	public List<StoreProduct> getStoreProductForm(String storeProduct) {
		String str="";
		if(storeProduct!=null) {
		str += "Where sP_name like '%"+storeProduct+"%' or sP_context like '%" +storeProduct+"%' " ;
		
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
	
	@Autowired
	private ProductDao productDaoImpl;

	public List<Product> getSelect(Product product) {
		String str;
		str = "Where p_parentsId = " + product.getP_id();
		try {
			List<Product> list = productDaoImpl.selectHql(str);
			return list;
		} catch (SQLException e) {
			System.out.println("_TestService - SQLException");
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<StoreProduct> getStoreProductChangeForm(String search,String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m){
		String str="";
		 List<String> list = new ArrayList<>();
		str += "Where (sP_name like '%"+search+"%' or sP_context like '%" +search+"%') " ;
		str += (a!=null)?" and product.p_parentsId ="+ a+ " ":"";
		str += (b!=null)?" and product.p_id ="+ b+" ":"";
		str += (c!=null)?" and sP_averageAssess >= "+c+" ":"";
		if(d!=null||e!=null||f!=null||g!=null||h!=null) {
			
			if(d!=null) {list.add(" sP_transport="+d);}
			if(e!=null) {list.add(" sP_transport="+e);}
			if(f!=null) {list.add(" sP_transport="+f);}
			if(g!=null) {list.add(" sP_transport="+g);}
			if(h!=null) {list.add(" sP_transport="+h);}
			
			if(list.size()>1) {
				str+=" and( "+list.get(0);	
				for(int x =1;list.size()-2>=x;x++) {
					str+=" or"+list.get(x);
				}
				str+=" or"+list.get(list.size()-1)+") ";
			}else {
				str+=" and ";
				str+=list.get(0);
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

	public StoreProduct getStoreProductHot(StoreProduct storeProduct) throws SQLException {
			if(storeProduct!=null) {
				StoreProduct bean =storeProductDaoImpl.selectByPk(storeProduct.getsP_id());
				
				Integer sp_id = bean.getP_id();
				bean.setsP_hot(bean.getsP_hot()+1);	
				return storeProductDaoImpl.update(bean);
			}
			return storeProduct;
			
		
	}
	
	
}