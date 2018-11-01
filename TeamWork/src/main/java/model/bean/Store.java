package model.bean;

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
	@Column(name = "store_ID", columnDefinition = "int", nullable = false)
	private Integer s_id;

	@Column(name = "seller_ID", columnDefinition = "int", nullable = false)
	private Integer seller_id;

	@Column(name = "store_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String s_name;

	@Column(name = "store_pho", columnDefinition = "nvarchar(max)")
	private String s_photo;

	@Column(name = "store_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String s_context;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer p_id;

	@Column(name = "store_add", columnDefinition = "nvarchar(max)")
	private String s_address;

	@Column(name = "store_tel", columnDefinition = "nvarchar(max)")
	private String s_telephone;

	@Column(name = "store_web", columnDefinition = "nvarchar(max)")
	private String s_web;

	@Column(name = "store_state", columnDefinition = "int", nullable = false)
	private Integer s_stateId;

	@OneToOne
	@JoinColumn(name = "seller_ID", insertable = false, updatable = false)
	private Seller seller;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "store_state", insertable = false, updatable = false)
	private State state;

	public Store() {
	}

	public Store(Integer s_id, Integer seller_id, String s_name, String s_photo, String s_context, Integer p_id,
			String s_address, String s_telephone, String s_web, Integer s_stateId) {
		super();
		this.s_id = s_id;
		this.seller_id = seller_id;
		this.s_name = s_name;
		this.s_photo = s_photo;
		this.s_context = s_context;
		this.p_id = p_id;
		this.s_address = s_address;
		this.s_telephone = s_telephone;
		this.s_web = s_web;
		this.s_stateId = s_stateId;
	}

	@Override
	public String toString() {
		return "Store [s_id=" + s_id + ", seller_id=" + seller_id + ", s_name=" + s_name + ", s_photo=" + s_photo
				+ ", s_context=" + s_context + ", p_id=" + p_id + ", s_address=" + s_address + ", s_telephone="
				+ s_telephone + ", s_web=" + s_web + ", s_stateId=" + s_stateId + ", seller=" + seller + ", product="
				+ product + ", state=" + state + "]\r\n";
	}

	public Integer getS_id() {
		return s_id;
	}

	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}

	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_photo() {
		return s_photo;
	}

	public void setS_photo(String s_photo) {
		this.s_photo = s_photo;
	}

	public String getS_context() {
		return s_context;
	}

	public void setS_context(String s_context) {
		this.s_context = s_context;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getS_address() {
		return s_address;
	}

	public void setS_address(String s_address) {
		this.s_address = s_address;
	}

	public String getS_telephone() {
		return s_telephone;
	}

	public void setS_telephone(String s_telephone) {
		this.s_telephone = s_telephone;
	}

	public String getS_web() {
		return s_web;
	}

	public void setS_web(String s_web) {
		this.s_web = s_web;
	}

	public Integer getS_stateId() {
		return s_stateId;
	}

	public void setS_stateId(Integer s_stateId) {
		this.s_stateId = s_stateId;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
