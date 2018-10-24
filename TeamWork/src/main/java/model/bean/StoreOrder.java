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

	@Column(name = "memS_IdEE", columnDefinition = "int")
	Integer memberStoreIdEE;

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
	Product productBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "memS_IDee", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "state", insertable = false, updatable = false)
	State stateBean;

	public StoreOrder() {
	}

	public StoreOrder(Integer id, Integer productId, Integer memberStoreIdEE, String storeProductName, Integer amount,
			Integer storeProductPrice, Integer state) {
		this.id = id;
		this.productId = productId;
		this.memberStoreIdEE = memberStoreIdEE;
		this.storeProductName = storeProductName;
		this.amount = amount;
		this.storeProductPrice = storeProductPrice;
		this.state = state;
	}

	@Override
	public String toString() {
		return "StoreOrder [id=" + id + ", productId=" + productId + ", memberStoreIdEE=" + memberStoreIdEE
				+ ", storeProductName=" + storeProductName + ", amount=" + amount + ", storeProductPrice="
				+ storeProductPrice + ", state=" + state + "]\r\n  [productBean=" + productBean + "]\r\n  [memberBean=" + memberBean
				+ "]\r\n  [stateBean=" + stateBean + "]\r\n";
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

	public Integer getMemberStoreIdEE() {
		return memberStoreIdEE;
	}

	public void setMemberStoreIdEE(Integer memberStoreIdEE) {
		this.memberStoreIdEE = memberStoreIdEE;
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

	public Product getProductBean() {
		return productBean;
	}

	public void setProductBean(Product productBean) {
		this.productBean = productBean;
	}

	public Member getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(Member memberBean) {
		this.memberBean = memberBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
