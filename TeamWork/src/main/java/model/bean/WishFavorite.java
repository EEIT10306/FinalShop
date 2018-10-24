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
@Table(name = "WishFavorite")
public class WishFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wF_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "mem_ID", columnDefinition = "int")
	Integer memberId;

	@Column(name = "wP_ID", columnDefinition = "int")
	Integer wishProductId;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wP_ID", insertable = false, updatable = false)
	WishProduct wishProductBean;

	public WishFavorite() {
	}

	public WishFavorite(Integer id, Integer memberId, Integer wishProductId) {
		this.id = id;
		this.memberId = memberId;
		this.wishProductId = wishProductId;
	}

	@Override
	public String toString() {
		return "WishFavorite [id=" + id + ", memberId=" + memberId + ", wishProductId=" + wishProductId
				+ "]\r\n  [memberBean=" + memberBean + "]\r\n  [wishProductBean=" + wishProductBean + "]\r\n";
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

	public Integer getWishProductId() {
		return wishProductId;
	}

	public void setWishProductId(Integer wishProductId) {
		this.wishProductId = wishProductId;
	}

	public Member getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(Member memberBean) {
		this.memberBean = memberBean;
	}

	public WishProduct getWishProductBean() {
		return wishProductBean;
	}

	public void setWishProductBean(WishProduct wishProductBean) {
		this.wishProductBean = wishProductBean;
	}

}
