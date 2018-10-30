package model.bean;

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
	private Integer id;

	@Column(name = "gP_ID", columnDefinition = "int", nullable = false)
	private Integer groupProductId;

	@Column(name = "memG_IDee", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "gO_amt", columnDefinition = "int", nullable = false)
	private Integer amount;

	@Column(name = "gO_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "gP_ID", insertable = false, updatable = false)
	private GroupProduct GroupProduct;

	@ManyToOne
	@JoinColumn(name = "memG_IDee", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "state", insertable = false, updatable = false)
	private State State;

	public GroupOrder() {
	}

	public GroupOrder(Integer id, Integer groupProductId, Integer memberId, Integer amount, Integer stateId) {
		super();
		this.id = id;
		this.groupProductId = groupProductId;
		this.memberId = memberId;
		this.amount = amount;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "GroupOrder [id=" + id + ", groupProductId=" + groupProductId + ", memberId=" + memberId + ", amount="
				+ amount + ", stateId=" + stateId + ", GroupProduct=" + GroupProduct + ", Member=" + Member + ", State="
				+ State + "]\r\n";
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

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public GroupProduct getGroupProduct() {
		return GroupProduct;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

	public void setGroupProduct(GroupProduct groupProduct) {
		GroupProduct = groupProduct;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public void setState(State state) {
		State = state;
	}

}
