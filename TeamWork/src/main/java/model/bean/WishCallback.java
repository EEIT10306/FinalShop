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
public class WishCallback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wC_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "wM_ID", columnDefinition = "int", nullable = false)
	private Integer wishMessageId;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "wC_cont", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String context;

	@Column(name = "wC_time", columnDefinition = "datetime", nullable = false)
	private Date time;

	@Column(name = "wC_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "wM_ID", insertable = false, updatable = false)
	private WishMessage WishMessage;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "wC_state", insertable = false, updatable = false)
	private State State;

	public WishCallback() {
	}

	public WishCallback(Integer id, Integer wishMessageId, Integer memberId, String context, Date time,
			Integer stateId) {
		super();
		this.id = id;
		this.wishMessageId = wishMessageId;
		this.memberId = memberId;
		this.context = context;
		this.time = time;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "WishCallback [id=" + id + ", wishMessageId=" + wishMessageId + ", memberId=" + memberId + ", context="
				+ context + ", time=" + time + ", stateId=" + stateId + ", WishMessage=" + WishMessage + ", Member="
				+ Member + ", State=" + State + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWishMessageId() {
		return wishMessageId;
	}

	public void setWishMessageId(Integer wishMessageId) {
		this.wishMessageId = wishMessageId;
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

	public WishMessage getWishMessage() {
		return WishMessage;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

	public void setWishMessage(WishMessage wishMessage) {
		WishMessage = wishMessage;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public void setState(State state) {
		State = state;
	}

}
