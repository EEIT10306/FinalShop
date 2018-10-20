package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StoreOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sO_ID", columnDefinition = "int")
	Integer id;
	
	@Column(name = "prod_ID", columnDefinition = "int")
	Integer productId;
	
	@Column(name = "memS_IDee", columnDefinition = "int")
	Integer memberStoreIDee;
	
	@Column(name = "sP_name", columnDefinition = "nvarchar(max)")
	String storeProductName;
	
	@Column(name = "sO_amt", columnDefinition = "int")
	Integer amount;
	
	@Column(name = "sP_price", columnDefinition = "int")
	Integer storeProductPrice;
	
	@Column(name = "state", columnDefinition = "int")
	Integer state;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_id", insertable = false, updatable = false)
	Product product;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "memS_IDee", insertable = false, updatable = false)
	Member member;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "state", insertable = false, updatable = false)
	State st;

	public StoreOrder() {}
	
	public StoreOrder(Integer id, Integer productId, Integer memberStoreIDee, String storeProductName, Integer amount,
			Integer storeProductPrice, Integer state) {
		this.id = id;
		this.productId = productId;
		this.memberStoreIDee = memberStoreIDee;
		this.storeProductName = storeProductName;
		this.amount = amount;
		this.storeProductPrice = storeProductPrice;
		this.state = state;
	}

	@Override
	public String toString() {
		return "StoreOrder [id=" + id + ", productId=" + productId + ", memberStoreIDee=" + memberStoreIDee
				+ ", storeProductName=" + storeProductName + ", amount=" + amount + ", storeProductPrice="
				+ storeProductPrice + ", state=" + state + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getMemberStoreIDee() {
		return memberStoreIDee;
	}

	public void setMemberStoreIDee(Integer memberStoreIDee) {
		this.memberStoreIDee = memberStoreIDee;
	}

	public String getStoreProductName() {
		return storeProductName;
	}

	public void setStoreProductName(String storeProductName) {
		this.storeProductName = storeProductName;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getStoreProductPrice() {
		return storeProductPrice;
	}

	public void setStoreProductPrice(Integer storeProductPrice) {
		this.storeProductPrice = storeProductPrice;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public State getSt() {
		return st;
	}

	public void setSt(State st) {
		this.st = st;
	}
	
	
}
