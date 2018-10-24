package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StoreFavorite")
public class StoreFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sF_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "mem_ID", columnDefinition = "int")
	Integer memberId;

	@Column(name = "sP_ID", columnDefinition = "int")
	Integer storeProductId;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sP_ID", insertable = false, updatable = false)
	StoreProduct storeProductBean;

	public StoreFavorite() {
	}

	public StoreFavorite(Integer id, Integer memberId, Integer storeProductId) {
		this.id = id;
		this.memberId = memberId;
		this.storeProductId = storeProductId;
	}

	@Override
	public String toString() {
		return "storeFavorite [id=" + id + ", memberId=" + memberId + ", storeProductId=" + storeProductId
				+ "]\r\n  [memberBean=" + memberBean + "]\r\n  [storeProductBean=" + storeProductBean + "]\r\n";
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

	public Member getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(Member memberBean) {
		this.memberBean = memberBean;
	}

	public StoreProduct getStoreProductBean() {
		return storeProductBean;
	}

	public void setStoreProductBean(StoreProduct storeProductBean) {
		this.storeProductBean = storeProductBean;
	}

}
