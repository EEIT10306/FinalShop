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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "GroupMessage", uniqueConstraints = { @UniqueConstraint(columnNames = { "gP_ID", "memG_IDee" }) })
public class GroupMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gM_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "gP_ID", columnDefinition = "int")
	Integer groupProductId;

	@Column(name = "memG_IDee", columnDefinition = "int")
	Integer memberId;

	@Column(name = "gM_amt", columnDefinition = "int")
	Integer amount;

	@Column(name = "gM_time", columnDefinition = "daetime")
	Date time;

	@Column(name = "gS_ID", columnDefinition = "int")
	Integer groupServiceId;

	@Column(name = "gM_sumPrice", columnDefinition = "int")
	Integer sumPrice;

	@Column(name = "gM_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gP_ID", insertable = false, updatable = false)
	GroupProduct groupProductBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "memG_IDee", insertable = false, updatable = false)
	Member memberBean;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gS_ID", insertable = false, updatable = false)
	GroupService groupServiceBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gM_state", insertable = false, updatable = false)
	State stateBean;

	public GroupMessage() {
	}

	public GroupMessage(Integer id, Integer groupProductId, Integer memberId, Integer amount, Date time,
			Integer groupServiceId, Integer sumPrice, Integer state) {
		this.id = id;
		this.groupProductId = groupProductId;
		this.memberId = memberId;
		this.amount = amount;
		this.time = time;
		this.groupServiceId = groupServiceId;
		this.sumPrice = sumPrice;
		this.state = state;
	}

	@Override
	public String toString() {
		return "GroupMessage [id=" + id + ", groupProductId=" + groupProductId + ", memberId=" + memberId + ", amount="
				+ amount + ", time=" + time + ", groupServiceId=" + groupServiceId + ", sumPrice=" + sumPrice
				+ ", state=" + state + "]\r\n  [groupProductBean=" + groupProductBean + "]\r\n  [memberBean="
				+ memberBean + "]\r\n  [groupServiceBean=" + groupServiceBean + "]\r\n  [stateBean=" + stateBean
				+ "]\r\n";
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

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getGroupServiceId() {
		return groupServiceId;
	}

	public void setGroupServiceId(Integer groupServiceId) {
		this.groupServiceId = groupServiceId;
	}

	public Integer getSumPrice() {
		return sumPrice;
	}

	public void setSumPrice(Integer sumPrice) {
		this.sumPrice = sumPrice;
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

	public GroupService getGroupServiceBean() {
		return groupServiceBean;
	}

	public void setGroupServiceBean(GroupService groupServiceBean) {
		this.groupServiceBean = groupServiceBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
