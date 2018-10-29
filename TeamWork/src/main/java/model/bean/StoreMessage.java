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
public class StoreMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sM_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "sP_ID", columnDefinition = "int", nullable = false)
	private Integer storeProductId;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "sM_cont", columnDefinition = "int", nullable = false)
	private Integer context;

	@Column(name = "sM_time", columnDefinition = "daetime", nullable = false)
	private Date time;

	@Column(name = "sM_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "sP_ID", insertable = false, updatable = false)
	private StoreProduct StoreProduct;

	@ManyToOne
	@JoinColumn(name = "memG_IDee", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "gM_state", insertable = false, updatable = false)
	private State State;

	public StoreMessage() {
	}

	public StoreMessage(Integer id, Integer storeProductId, Integer memberId, Integer context, Date time,
			Integer stateId) {
		super();
		this.id = id;
		this.storeProductId = storeProductId;
		this.memberId = memberId;
		this.context = context;
		this.time = time;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "StoreMessage [id=" + id + ", storeProductId=" + storeProductId + ", memberId=" + memberId + ", context="
				+ context + ", time=" + time + ", stateId=" + stateId + ", StoreProduct=" + StoreProduct + ", Member="
				+ Member + ", State=" + State + "]\r\n";
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

	public Integer getContext() {
		return context;
	}

	public void setContext(Integer context) {
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

	public StoreProduct getStoreProduct() {
		return StoreProduct;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

}
