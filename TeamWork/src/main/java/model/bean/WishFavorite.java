package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WishFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wF_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer wishId;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	private Wish Wish;

	public WishFavorite() {
	}

	public WishFavorite(Integer id, Integer memberId, Integer wishId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.wishId = wishId;
	}

	@Override
	public String toString() {
		return "WishFavorite [id=" + id + ", memberId=" + memberId + ", wishId=" + wishId + ", Member=" + Member
				+ ", Wish=" + Wish + "]\r\n";
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

	public Integer getWishId() {
		return wishId;
	}

	public void setWishId(Integer wishId) {
		this.wishId = wishId;
	}

	public Member getMember() {
		return Member;
	}

	public Wish getWish() {
		return Wish;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public void setWish(Wish wish) {
		Wish = wish;
	}

}
