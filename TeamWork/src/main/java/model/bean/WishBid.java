package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class WishBid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wB_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer wishId;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "wB_bid", columnDefinition = "int", nullable = false)
	private Integer bid;

	@Column(name = "wB_cont", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String context;

	@Column(name = "wB_freight", columnDefinition = "int")
	private Integer freight;

	@Column(name = "wB_time", columnDefinition = "datetime", nullable = false)
	private Date time;

	@Column(name = "wB_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@OneToOne
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	private Wish Wish;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "wB_state", insertable = false, updatable = false)
	private State State;

	public WishBid() {
	}

	public WishBid(Integer id, Integer wishId, Integer memberId, Integer bid, String context, Integer freight,
			Date time, Integer stateId) {
		super();
		this.id = id;
		this.wishId = wishId;
		this.memberId = memberId;
		this.bid = bid;
		this.context = context;
		this.freight = freight;
		this.time = time;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "WishBid [id=" + id + ", wishId=" + wishId + ", memberId=" + memberId + ", bid=" + bid + ", context="
				+ context + ", freight=" + freight + ", time=" + time + ", stateId=" + stateId + ", Wish=" + Wish
				+ ", Member=" + Member + ", State=" + State + "]\r\n";
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

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getFreight() {
		return freight;
	}

	public void setFreight(Integer freight) {
		this.freight = freight;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
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

	public void setWish(Wish wish) {
		Wish = wish;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public void setState(State state) {
		State = state;
	}

}
