package model.bean;

import java.util.Date;

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
@Table(name = "WishMessage")
public class WishMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wM_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "wP_ID", columnDefinition = "int")
	Integer groupProductId;

	@Column(name = "mem_IDee", columnDefinition = "int")
	Member buyerMemberIdEE;

	@Column(name = "wM_bid", columnDefinition = "int")
	Integer bid;

	@Column(name = "wM_cont", columnDefinition = "nvarchar(max)")
	String amount;

	@Column(name = "wM_time", columnDefinition = "daetime")
	Date time;

	@Column(name = "wM_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gP_ID", insertable = false, updatable = false)
	GroupProduct groupProductBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gM_state", insertable = false, updatable = false)
	State stateBean;

	public WishMessage() {
	}

	public WishMessage(Integer id, Integer groupProductId, Member buyerMemberIdEE, Integer bid, String amount,
			Date time, Integer state) {
		this.id = id;
		this.groupProductId = groupProductId;
		this.buyerMemberIdEE = buyerMemberIdEE;
		this.bid = bid;
		this.amount = amount;
		this.time = time;
		this.state = state;
	}

	@Override
	public String toString() {
		return "WishMessage [id=" + id + ", groupProductId=" + groupProductId + ", buyerMemberIdEE=" + buyerMemberIdEE
				+ ", bid=" + bid + ", amount=" + amount + ", time=" + time + ", state=" + state + "]\r\n  [groupProductBean="
				+ groupProductBean + "]\r\n  [memberBean=" + memberBean + "]\r\n  [stateBean=" + stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupProductId() {
		return groupProductId;
	}

	public void setGroupProductId(Integer groupProductId) {
		this.groupProductId = groupProductId;
	}

	public Member getBuyerMemberIdEE() {
		return buyerMemberIdEE;
	}

	public void setBuyerMemberIdEE(Member buyerMemberIdEE) {
		this.buyerMemberIdEE = buyerMemberIdEE;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public GroupProduct getGroupProductBean() {
		return groupProductBean;
	}

	public void setGroupProductBean(GroupProduct groupProductBean) {
		this.groupProductBean = groupProductBean;
	}

	public Member getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(Member memberBean) {
		this.memberBean = memberBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
