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
	private Integer i_id;

	@Column(name = "wgs_ID", columnDefinition = "int", nullable = false)
	private Integer wgs_id;

	@Column(name = "im_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String i_context;

	@Column(name = "im_from", columnDefinition = "nvarchar(max)", nullable = false)
	private String i_from;

	@ManyToOne
	@JoinColumn(name = "wgs_ID", insertable = false, updatable = false)
	private WishProduct wishProduct;

	@ManyToOne
	@JoinColumn(name = "wgs_ID", insertable = false, updatable = false)
	private GroupProduct groupProduct;

	@ManyToOne
	@JoinColumn(name = "wgs_ID", insertable = false, updatable = false)
	private StoreProduct storeProduct;

	public Images() {
	}

	public Images(Integer i_id, Integer wgs_id, String i_context, String i_from) {
		super();
		this.i_id = i_id;
		this.wgs_id = wgs_id;
		this.i_context = i_context;
		this.i_from = i_from;
	}

	@Override
	public String toString() {
		return "Images [i_id=" + i_id + ", wgs_id=" + wgs_id + ", i_context=" + i_context + ", i_from=" + i_from
				+ ", wishProduct=" + wishProduct + ", groupProduct=" + groupProduct + ", storeProduct=" + storeProduct
				+ "]\r\n";
	}

	public Integer getI_id() {
		return i_id;
	}

	public void setI_id(Integer i_id) {
		this.i_id = i_id;
	}

	public Integer getWgs_id() {
		return wgs_id;
	}

	public void setWgs_id(Integer wgs_id) {
		this.wgs_id = wgs_id;
	}

	public String getI_context() {
		return i_context;
	}

	public void setI_context(String i_context) {
		this.i_context = i_context;
	}

	public String getI_from() {
		return i_from;
	}

	public void setI_from(String i_from) {
		this.i_from = i_from;
	}

	public WishProduct getWishProduct() {
		return wishProduct;
	}

	public void setWishProduct(WishProduct wishProduct) {
		this.wishProduct = wishProduct;
	}

	public GroupProduct getGroupProduct() {
		return groupProduct;
	}

	public void setGroupProduct(GroupProduct groupProduct) {
		this.groupProduct = groupProduct;
	}

	public StoreProduct getStoreProduct() {
		return storeProduct;
	}

	public void setStoreProduct(StoreProduct storeProduct) {
		this.storeProduct = storeProduct;
	}

}
