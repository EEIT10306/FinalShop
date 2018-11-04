package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WishImages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wI_ID", columnDefinition = "int", nullable = false)
	private Integer wI_id;

	@Column(name = "wP_ID", columnDefinition = "int", nullable = false)
	private Integer wP_id;

	@Column(name = "wI_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String wI_context;

	@ManyToOne
	@JoinColumn(name = "wP_ID", insertable = false, updatable = false)
	private WishProduct wishProduct;

	public WishImages() {
	}

	public WishImages(Integer wI_id, Integer wP_id, String wI_context) {
		super();
		this.wI_id = wI_id;
		this.wP_id = wP_id;
		this.wI_context = wI_context;
	}

	@Override
	public String toString() {
		return "WishImages [wI_id=" + wI_id + ", wP_id=" + wP_id + ", wI_context=" + wI_context + ", wishProduct="
				+ wishProduct + "]\r\n";
	}

	public Integer getwI_id() {
		return wI_id;
	}

	public void setwI_id(Integer wI_id) {
		this.wI_id = wI_id;
	}

	public Integer getwP_id() {
		return wP_id;
	}

	public void setwP_id(Integer wP_id) {
		this.wP_id = wP_id;
	}

	public String getwI_context() {
		return wI_context;
	}

	public void setwI_context(String wI_context) {
		this.wI_context = wI_context;
	}

	public WishProduct getWishProduct() {
		return wishProduct;
	}

	public void setWishProduct(WishProduct wishProduct) {
		this.wishProduct = wishProduct;
	}

}
