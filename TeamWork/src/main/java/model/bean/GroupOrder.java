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
public class GroupOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gO_ID", columnDefinition = "int", nullable = false)
	private Integer gO_id;

	@Column(name = "gP_ID", columnDefinition = "int", nullable = false)
	private Integer gP_id;

	@Column(name = "memG_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idOrder;

	@Column(name = "gO_amt", columnDefinition = "int", nullable = false)
	private Integer gO_amount;
	
	@Column(name = "gO_sumPri", columnDefinition = "int", nullable = false)
	private Integer gO_sumPrice;

	
	@Column(name = "gO_time", columnDefinition = "datetime", nullable = false)
	private Date gO_time;


	@Column(name = "gO_state", columnDefinition = "int", nullable = false)
	private Integer gO_stateId;

	@ManyToOne
	@JoinColumn(name = "gP_ID", insertable = false, updatable = false)
	private GroupProduct groupProduct;

	@ManyToOne
	@JoinColumn(name = "memG_IDee", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "gO_state", insertable = false, updatable = false)
	private State state;

	public GroupOrder() {
	}

	public GroupOrder(Integer gO_id, Integer gP_id, Integer m_idOrder, Integer gO_amount, Integer gO_stateId) {
		super();
		this.gO_id = gO_id;
		this.gP_id = gP_id;
		this.m_idOrder = m_idOrder;
		this.gO_amount = gO_amount;
		this.gO_stateId = gO_stateId;
	}

	@Override
	public String toString() {
		return "GroupOrder [gO_id=" + gO_id + ", gP_id=" + gP_id + ", m_idOrder=" + m_idOrder + ", gO_amount="
				+ gO_amount + ", gO_stateId=" + gO_stateId + ", groupProduct=" + groupProduct + ", member=" + member
				+ ", state=" + state + "]\r\n";
	}

	public Integer getgO_id() {
		return gO_id;
	}

	public void setgO_id(Integer gO_id) {
		this.gO_id = gO_id;
	}

	public Integer getgP_id() {
		return gP_id;
	}

	public void setgP_id(Integer gP_id) {
		this.gP_id = gP_id;
	}

	public Integer getM_idOrder() {
		return m_idOrder;
	}

	public void setM_idOrder(Integer m_idOrder) {
		this.m_idOrder = m_idOrder;
	}

	public Integer getgO_amount() {
		return gO_amount;
	}

	public void setgO_amount(Integer gO_amount) {
		this.gO_amount = gO_amount;
	}

	public Integer getgO_stateId() {
		return gO_stateId;
	}

	public void setgO_stateId(Integer gO_stateId) {
		this.gO_stateId = gO_stateId;
	}

	public GroupProduct getGroupProduct() {
		return groupProduct;
	}

	public void setGroupProduct(GroupProduct groupProduct) {
		this.groupProduct = groupProduct;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
