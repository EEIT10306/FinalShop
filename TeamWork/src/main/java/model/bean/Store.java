package model.bean;

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
	@Column(name = "store_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "seller_ID", columnDefinition = "int", nullable = false)
	private Integer sellerId;

	@Column(name = "store_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String name;

	@Column(name = "store_pho", columnDefinition = "nvarchar(max)")
	private String photo;

	@Column(name = "store_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String context;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer productId;

	@Column(name = "store_add", columnDefinition = "nvarchar(max)")
	private String address;

	@Column(name = "store_tel", columnDefinition = "int")
	private Integer telephone;

	@Column(name = "store_web", columnDefinition = "nvarchar(max)")
	private String web;

	@Column(name = "store_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@OneToOne
	@JoinColumn(name = "seller_ID", insertable = false, updatable = false)
	private Seller Seller;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product Product;

	@ManyToOne
	@JoinColumn(name = "store_state", insertable = false, updatable = false)
	private State State;

	public Store() {
	}

	public Store(Integer id, Integer sellerId, String name, String photo, String context, Integer productId,
			String address, Integer telephone, String web, Integer stateId) {
		super();
		this.id = id;
		this.sellerId = sellerId;
		this.name = name;
		this.photo = photo;
		this.context = context;
		this.productId = productId;
		this.address = address;
		this.telephone = telephone;
		this.web = web;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", sellerId=" + sellerId + ", name=" + name + ", photo=" + photo + ", context="
				+ context + ", productId=" + productId + ", address=" + address + ", telephone=" + telephone + ", web="
				+ web + ", stateId=" + stateId + ", Seller=" + Seller + ", Product=" + Product + ", State=" + State
				+ "]\r\n";
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
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

	public String getWeb() {
		return web;
	}

	public void setWeb(String web) {
		this.web = web;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Seller getSeller() {
		return Seller;
	}

	public Product getProduct() {
		return Product;
	}

	public State getState() {
		return State;
	}

}
