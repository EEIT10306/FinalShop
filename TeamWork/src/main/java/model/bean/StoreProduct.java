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
public class StoreProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sP_ID", columnDefinition = "int")
	Integer id;
	
	@Column(name = "store_ID", columnDefinition = "int")
	Integer storeId;
	
	@Column(name = "sP_name", columnDefinition = "nvarchar(max)")
	String name;
	
	@Column(name = "prod_ID", columnDefinition = "int")
	Integer productId;
	
	@Column(name = "sP_amt", columnDefinition = "int")
	Integer amount;
	
	@Column(name = "sP_price", columnDefinition = "int")
	Integer price;
	
	@Column(name = "sP_state", columnDefinition = "int")
	Integer state;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "store_ID", insertable = false, updatable = false)
	Store store;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	Product product;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sP_state", insertable = false, updatable = false)
	State st;

	public StoreProduct() {}
	
	public StoreProduct(Integer id, Integer storeId, String name, Integer productId, Integer amount, Integer price,
			Integer state) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.name = name;
		this.productId = productId;
		this.amount = amount;
		this.price = price;
		this.state = state;
	}

	@Override
	public String toString() {
		return "StoreProduct [id=" + id + ", storeId=" + storeId + ", name=" + name + ", productId=" + productId
				+ ", amount=" + amount + ", price=" + price + ", state=" + state + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public State getSt() {
		return st;
	}

	public void setState(State st) {
		this.st = st;
	}
}
