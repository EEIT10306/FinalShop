package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class StoreFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sF_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "sP_ID", columnDefinition = "int", nullable = false)
	private Integer storeProductId;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "sP_ID", insertable = false, updatable = false)
	private StoreProduct StoreProduct;

	public StoreFavorite() {
	}

	public StoreFavorite(Integer id, Integer memberId, Integer storeProductId) {
		this.id = id;
		this.memberId = memberId;
		this.storeProductId = storeProductId;
	}

	@Override
	public String toString() {
		return "StoreFavorite [id=" + id + ", memberId=" + memberId + ", storeProductId=" + storeProductId + ", Member="
				+ Member + ", StoreProduct=" + StoreProduct + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getStoreProductId() {
		return storeProductId;
	}

	public void setStoreProductId(Integer storeProductId) {
		this.storeProductId = storeProductId;
	}

	public Member getMember() {
		return Member;
	}

	public StoreProduct getStoreProduct() {
		return StoreProduct;
	}

}
