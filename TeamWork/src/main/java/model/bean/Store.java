package model.bean;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "seller_ID", columnDefinition = "int")
	Integer sellerId;

	@Column(name = "store_name", columnDefinition = "nvarchar(max)")
	String name;

	@Column(name = "store_pho", columnDefinition = "varbinary(max)")
	Blob photo;

	@Column(name = "prod_ID", columnDefinition = "int")
	Integer productId;

	@Column(name = "store_add", columnDefinition = "nvarchar(max)")
	String address;

	@Column(name = "store_tel", columnDefinition = "int")
	Integer telephone;

	@Column(name = "store_state", columnDefinition = "int")
	Integer state;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "seller_ID", insertable = false, updatable = false)
	Seller sellerBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	Product productBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "store_state", insertable = false, updatable = false)
	State stateBean;

	public Store() {
	}

	public Store(Integer id, Integer sellerId, String name, Blob photo, Integer productId, String address,
			Integer telephone, Integer state) {
		this.id = id;
		this.sellerId = sellerId;
		this.name = name;
		this.photo = photo;
		this.productId = productId;
		this.address = address;
		this.telephone = telephone;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", sellerId=" + sellerId + ", name=" + name + ", photo=" + photo + ", productId="
				+ productId + ", address=" + address + ", telephone=" + telephone + ", state=" + state + "]\r\n  [sellerBean="
				+ sellerBean + "]\r\n  [productBean=" + productBean + "]\r\n  [stateBean=" + stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTelephone() {
		return telephone;
	}

	public void setTelephone(Integer telephone) {
		this.telephone = telephone;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Seller getSellerBean() {
		return sellerBean;
	}

	public void setSellerBean(Seller sellerBean) {
		this.sellerBean = sellerBean;
	}

	public Product getProductBean() {
		return productBean;
	}

	public void setProductBean(Product productBean) {
		this.productBean = productBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
