package model.bean;

import java.util.Date;
import java.util.LinkedHashSet;
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
	private Integer sP_id;

	@Column(name = "store_ID", columnDefinition = "int", nullable = false)
	private Integer s_id;

	@Column(name = "sP_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String sP_name;

	@Column(name = "sP_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String sP_context;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer p_id;

	@Column(name = "sP_amt", columnDefinition = "int", nullable = false)
	private Integer sP_amount;

	@Column(name = "sP_price", columnDefinition = "int", nullable = false)
	private Integer sP_price;

	@Column(name = "sP_tran", columnDefinition = "nvarchar(max)")
	private String sP_transport;

	@Column(name = "sP_new", columnDefinition = "bit")
	private Boolean sP_new;

	@Column(name = "sP_hot", columnDefinition = "int", nullable = false)
	private Integer sP_hot;

	@Column(name = "sP_amtFav", columnDefinition = "int", nullable = false)
	private Integer sP_amountFavorite;

	@Column(name = "sP_time", columnDefinition = "datetime", nullable = false)
	private Date sP_time;

	@Column(name = "sP_avgAss", columnDefinition = "float", nullable = false)
	private Integer sP_averageAssess;

	@Column(name = "sP_amtAss", columnDefinition = "int", nullable = false)
	private Integer sP_amountAssess;

	@Column(name = "sP_state", columnDefinition = "int", nullable = false)
	private Integer sP_stateId;

	@ManyToOne
	@JoinColumn(name = "store_ID", insertable = false, updatable = false)
	private Store store;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "sP_state", insertable = false, updatable = false)
	private State state;

	@OneToMany(mappedBy = "sP_id")
	private Set<StoreImages> storeImages = new LinkedHashSet<>();

	public StoreProduct() {
	}

	public StoreProduct(Integer sP_id, Integer s_id, String sP_name, String sP_context, Integer p_id, Integer sP_amount,
			Integer sP_price, String sP_transport, Boolean sP_new, Integer sP_hot, Integer sP_amountFavorite,
			Date sP_time, Integer sP_averageAssess, Integer sP_amountAssess, Integer sP_stateId) {
		super();
		this.sP_id = sP_id;
		this.s_id = s_id;
		this.sP_name = sP_name;
		this.sP_context = sP_context;
		this.p_id = p_id;
		this.sP_amount = sP_amount;
		this.sP_price = sP_price;
		this.sP_transport = sP_transport;
		this.sP_new = sP_new;
		this.sP_hot = sP_hot;
		this.sP_amountFavorite = sP_amountFavorite;
		this.sP_time = sP_time;
		this.sP_averageAssess = sP_averageAssess;
		this.sP_amountAssess = sP_amountAssess;
		this.sP_stateId = sP_stateId;
	}

	@Override
	public String toString() {
		return "StoreProduct [sP_id=" + sP_id + ", s_id=" + s_id + ", sP_name=" + sP_name + ", sP_context=" + sP_context
				+ ", p_id=" + p_id + ", sP_amount=" + sP_amount + ", sP_price=" + sP_price + ", sP_transport="
				+ sP_transport + ", sP_new=" + sP_new + ", sP_hot=" + sP_hot + ", sP_amountFavorite="
				+ sP_amountFavorite + ", sP_time=" + sP_time + ", sP_averageAssess=" + sP_averageAssess
				+ ", sP_amountAssess=" + sP_amountAssess + ", sP_stateId=" + sP_stateId + ", storeImages=" + storeImages
				+ "]\r\n";
	}

	public Integer getsP_id() {
		return sP_id;
	}

	public void setsP_id(Integer sP_id) {
		this.sP_id = sP_id;
	}

	public Integer getS_id() {
		return s_id;
	}

	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}

	public String getsP_name() {
		return sP_name;
	}

	public void setsP_name(String sP_name) {
		this.sP_name = sP_name;
	}

	public String getsP_context() {
		return sP_context;
	}

	public void setsP_context(String sP_context) {
		this.sP_context = sP_context;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public Integer getsP_amount() {
		return sP_amount;
	}

	public void setsP_amount(Integer sP_amount) {
		this.sP_amount = sP_amount;
	}

	public Integer getsP_price() {
		return sP_price;
	}

	public void setsP_price(Integer sP_price) {
		this.sP_price = sP_price;
	}

	public String getsP_transport() {
		return sP_transport;
	}

	public void setsP_transport(String sP_transport) {
		this.sP_transport = sP_transport;
	}

	public Boolean getsP_new() {
		return sP_new;
	}

	public void setsP_new(Boolean sP_new) {
		this.sP_new = sP_new;
	}

	public Integer getsP_hot() {
		return sP_hot;
	}

	public void setsP_hot(Integer sP_hot) {
		this.sP_hot = sP_hot;
	}

	public Integer getsP_amountFavorite() {
		return sP_amountFavorite;
	}

	public void setsP_amountFavorite(Integer sP_amountFavorite) {
		this.sP_amountFavorite = sP_amountFavorite;
	}

	public Date getsP_time() {
		return sP_time;
	}

	public void setsP_time(Date sP_time) {
		this.sP_time = sP_time;
	}

	public Integer getsP_averageAssess() {
		return sP_averageAssess;
	}

	public void setsP_averageAssess(Integer sP_averageAssess) {
		this.sP_averageAssess = sP_averageAssess;
	}

	public Integer getsP_amountAssess() {
		return sP_amountAssess;
	}

	public void setsP_amountAssess(Integer sP_amountAssess) {
		this.sP_amountAssess = sP_amountAssess;
	}

	public Integer getsP_stateId() {
		return sP_stateId;
	}

	public void setsP_stateId(Integer sP_stateId) {
		this.sP_stateId = sP_stateId;
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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Set<StoreImages> getStoreImages() {
		return storeImages;
	}

	public void setStoreImages(Set<StoreImages> storeImages) {
		this.storeImages = storeImages;
	}

}
