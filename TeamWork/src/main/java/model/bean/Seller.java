package model.bean;

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
@Table(name = "Seller")
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sel_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "mem_ID", columnDefinition = "int")
	Integer memberId;

	@Column(name = "mem_idcard", columnDefinition = "nvarchar(MAX)")
	String idCard;

	@Column(name = "mem_mailVer", columnDefinition = "nvarchar(MAX)")
	String mailVerification;

	@Column(name = "seller_state", columnDefinition = "int")
	Integer state;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "seller_state", insertable = false, updatable = false)
	State stateBean;

	public Seller() {
	}

	public Seller(Integer id, Integer memberId, String idCard, String mailVerification, Integer state) {
		this.id = id;
		this.memberId = memberId;
		this.idCard = idCard;
		this.mailVerification = mailVerification;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", memberId=" + memberId + ", idCard=" + idCard + ", mailVerification="
				+ mailVerification + ", state=" + state + "]\r\n  [memberBean=" + memberBean + "]\r\n  [stateBean=" + stateBean
				+ "]\r\n";
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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getMailVerification() {
		return mailVerification;
	}

	public void setMailVerification(String mailVerification) {
		this.mailVerification = mailVerification;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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
