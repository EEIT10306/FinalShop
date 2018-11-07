package model.service;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.bean.StoreProduct;
import model.repository.StoreProductDao;

@Service
@Transactional
public class StoreProductService {
	
	@Autowired
	StoreProductDao storeProductDaoImpl;
	
	public StoreProduct selectByPk(int id) throws SQLException {
		System.out.println(storeProductDaoImpl.selectByPk(id).getStoreImages());
		return storeProductDaoImpl.selectByPk(id);
	}
	public List<StoreProduct> getStoreProductChangeForm(String search,String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String k,String l,String m){
		String str="";
		 List<String> list = new ArrayList<>();
		str += "Where (sP_name like '%"+search+"%' or sP_context like '%" +search+"%') " ;
		str += (a!=null)?" and product.p_parentsId ="+ a+ " ":"";
		str += (b!=null)?" and product.p_id ="+ b+" ":"";
		str += (b!=null)?" and sP_averageAssess >= "+c+" ":"";
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
		
		
		if(i==null&&j==null) {
			str+="";
		}else {
			str+=(i!=null)?" and sP_new ="+i+" ":"";
			str+=(j!=null)?" and sP_new ="+j+" ":"";
		}
		str+=(k!=null&&l!=null)?" and (sP_price > "+k+ " and sP_price<"+l+") ":"";
		
		str += (m!=null)?" order by "+m+" ":" ";
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
	
}
