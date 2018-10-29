package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WishOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wO_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer wishId;

	@Column(name = "memW_IDee", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "wB_sumPrice", columnDefinition = "int", nullable = false)
	private String sumPrice;

	@Column(name = "wO_time", columnDefinition = "datetime", nullable = false)
	private Integer time;

	@Column(name = "wO_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	private Wish Wish;

	@ManyToOne
	@JoinColumn(name = "memW_IDee", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "wO_state", insertable = false, updatable = false)
	private State State;

	public WishOrder() {
	}

	public WishOrder(Integer id, Integer wishId, Integer memberId, String sumPrice, Integer time, Integer stateId) {
		super();
		this.id = id;
		this.wishId = wishId;
		this.memberId = memberId;
		this.sumPrice = sumPrice;
		this.time = time;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "WishOrder [id=" + id + ", wishId=" + wishId + ", memberId=" + memberId + ", sumPrice=" + sumPrice
				+ ", time=" + time + ", stateId=" + stateId + ", Wish=" + Wish + ", Member=" + Member + ", State="
				+ State + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWishId() {
		return wishId;
	}

	public void setWishId(Integer wishId) {
		this.wishId = wishId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(String sumPrice) {
		this.sumPrice = sumPrice;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Wish getWish() {
		return Wish;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

}
