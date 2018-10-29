package model.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class StoreProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sP_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "store_ID", columnDefinition = "int", nullable = false)
	private Integer storeId;

	@Column(name = "sP_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String name;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer productId;

	@Column(name = "sP_amt", columnDefinition = "int", nullable = false)
	private Integer amount;

	@Column(name = "sP_price", columnDefinition = "int", nullable = false)
	private Integer price;

	@Column(name = "sP_hot", columnDefinition = "int", nullable = false)
	private Integer hot;

	@Column(name = "sP_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "store_ID", insertable = false, updatable = false)
	private Store Store;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product Product;

	@ManyToOne
	@JoinColumn(name = "sP_state", insertable = false, updatable = false)
	private State State;

	@OneToMany(mappedBy = "StoreProduct")
	private Set<Images> Images;

	public StoreProduct() {
	}

	public StoreProduct(Integer id, Integer storeId, String name, Integer productId, Integer amount, Integer price,
			Integer hot, Integer stateId) {
		super();
		this.id = id;
		this.storeId = storeId;
		this.name = name;
		this.productId = productId;
		this.amount = amount;
		this.price = price;
		this.hot = hot;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "StoreProduct [id=" + id + ", storeId=" + storeId + ", name=" + name + ", productId=" + productId
				+ ", amount=" + amount + ", price=" + price + ", hot=" + hot + ", stateId=" + stateId + ", Store="
				+ Store + ", Product=" + Product + ", State=" + State + ", Images=" + Images + "]\r\n";
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

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Store getStore() {
		return Store;
	}

	public Product getProduct() {
		return Product;
	}

	public State getState() {
		return State;
	}

	public Set<Images> getImages() {
		return Images;
	}

}
