package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "im_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "wgs_ID", columnDefinition = "int", nullable = false)
	private Integer wgsId;

	@Column(name = "im_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String context;

	@Column(name = "im_from", columnDefinition = "nvarchar(max)", nullable = false)
	private String from;

	@ManyToOne
	@JoinColumn(name = "wgs_ID", insertable = false, updatable = false)
	private WishProduct WishProduct;

	@ManyToOne
	@JoinColumn(name = "wgs_ID", insertable = false, updatable = false)
	private GroupProduct GroupProduct;

	@ManyToOne
	@JoinColumn(name = "wgs_ID", insertable = false, updatable = false)
	private StoreProduct StoreProduct;

	public Images() {
	}

	public Images(Integer id, Integer wgsId, String context, String from) {
		super();
		this.id = id;
		this.wgsId = wgsId;
		this.context = context;
		this.from = from;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", wgsId=" + wgsId + ", context=" + context + ", from=" + from + ", WishProduct="
				+ WishProduct + ", GroupProduct=" + GroupProduct + ", StoreProduct=" + StoreProduct + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWgsId() {
		return wgsId;
	}

	public void setWgsId(Integer wgsId) {
		this.wgsId = wgsId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public WishProduct getWishProduct() {
		return WishProduct;
	}

	public GroupProduct getGroupProduct() {
		return GroupProduct;
	}

	public StoreProduct getStoreProduct() {
		return StoreProduct;
	}

	public void setWishProduct(WishProduct wishProduct) {
		WishProduct = wishProduct;
	}

	public void setGroupProduct(GroupProduct groupProduct) {
		GroupProduct = groupProduct;
	}

	public void setStoreProduct(StoreProduct storeProduct) {
		StoreProduct = storeProduct;
	}

}
