package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StoreOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sO_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "sP_ID", columnDefinition = "int", nullable = false)
	private Integer storeProductId;

	@Column(name = "memS_IdEE", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "sO_amt", columnDefinition = "int", nullable = false)
	private Integer amount;

	@Column(name = "sO_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "prod_id", insertable = false, updatable = false)
	private StoreProduct StoreProduct;

	@ManyToOne
	@JoinColumn(name = "memS_IDee", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "state", insertable = false, updatable = false)
	private State State;

	public StoreOrder() {
	}

	public StoreOrder(Integer id, Integer storeProductId, Integer memberId, Integer amount, Integer stateId) {
		super();
		this.id = id;
		this.storeProductId = storeProductId;
		this.memberId = memberId;
		this.amount = amount;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "StoreOrder [id=" + id + ", storeProductId=" + storeProductId + ", memberId=" + memberId + ", amount="
				+ amount + ", stateId=" + stateId + ", StoreProduct=" + StoreProduct + ", Member=" + Member + ", State="
				+ State + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreProductId() {
		return storeProductId;
	}

	public void setStoreProductId(Integer storeProductId) {
		this.storeProductId = storeProductId;
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

	public StoreProduct getStoreProduct() {
		return StoreProduct;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

	public void setStoreProduct(StoreProduct storeProduct) {
		StoreProduct = storeProduct;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public void setState(State state) {
		State = state;
	}

}
