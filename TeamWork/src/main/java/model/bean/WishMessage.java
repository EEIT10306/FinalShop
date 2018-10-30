package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WishMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wM_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer wishId;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "wM_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String context;

	@Column(name = "wM_time", columnDefinition = "daetime", nullable = false)
	private Date time;

	@Column(name = "wM_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "wist_ID", insertable = false, updatable = false)
	private Wish Wish;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "wM_state", insertable = false, updatable = false)
	private State State;

	public WishMessage() {
	}

	public WishMessage(Integer id, Integer wishId, Integer memberId, String context, Date time, Integer stateId) {
		super();
		this.id = id;
		this.wishId = wishId;
		this.memberId = memberId;
		this.context = context;
		this.time = time;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "WishMessage [id=" + id + ", wishId=" + wishId + ", memberId=" + memberId + ", context=" + context
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

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
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
