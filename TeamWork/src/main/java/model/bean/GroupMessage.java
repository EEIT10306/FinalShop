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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GroupMessage")
public class GroupMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gM_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "gP_ID", columnDefinition = "int", unique = true)
	Integer groupID;

	@Column(name = "memG_IDee", columnDefinition = "int", unique = true)
	Integer memberID;

	@Column(name = "gM_amt", columnDefinition = "int")
	Integer gmAmt;

	@Column(name = "gM_time", columnDefinition = "daetime")
	Date gmTime;

	@Column(name = "gS_ID", columnDefinition = "int")
	Integer gsID;

	@Column(name = "gM_sumPrice", columnDefinition = "int")
	Integer sumPrice;

	@Column(name = "gM_state", columnDefinition = "int")
	Integer gmState;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gP_ID", insertable = false, updatable = false)
	Group group;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "memG_IDee", insertable = false, updatable = false)
	Member member;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gS_ID", insertable = false, updatable = false)
	GroupService groupService;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gM_state", insertable = false, updatable = false)
	State state;

	public GroupMessage() {
	}

	public GroupMessage(Integer id, Integer groupID, Integer memberID, Integer gmAmt, Date gmTime, Integer gsID, Integer sumPrice,
			Integer gmState) {
		this.id = id;
		this.groupID = groupID;
		this.memberID = memberID;
		this.gmAmt = gmAmt;
		this.gmTime = gmTime;
		this.gsID = gsID;
		this.sumPrice = sumPrice;
		this.gmState = gmState;
	}

	@Override
	public String toString() {
		return "GroupMessage [id=" + id + ", groupID=" + groupID + ", memberID=" + memberID + ", gmAmt=" + gmAmt
				+ ", gmTime=" + gmTime + ", gsID=" + gsID + ", sumPrice=" + sumPrice + ", gmState=" + gmState + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupID() {
		return groupID;
	}

	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getGmAmt() {
		return gmAmt;
	}

	public void setGmAmt(Integer gmAmt) {
		this.gmAmt = gmAmt;
	}

	public Date getGmTime() {
		return gmTime;
	}

	public void setGmTime(Date gmTime) {
		this.gmTime = gmTime;
	}

	public Integer getGsID() {
		return gsID;
	}

	public void setGsID(Integer gsID) {
		this.gsID = gsID;
	}

	public Integer getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Integer sumPrice) {
		this.sumPrice = sumPrice;
	}

	public Integer getGmState() {
		return gmState;
	}

	public void setGmState(Integer gmState) {
		this.gmState = gmState;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public GroupService getGroupService() {
		return groupService;
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
