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
public class StoreCallback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sC_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "sM_ID", columnDefinition = "int", nullable = false)
	private Integer storeMessageId;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "sC_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String context;

	@Column(name = "sC_time", columnDefinition = "datetime", nullable = false)
	private Date time;

	@Column(name = "sC_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "sM_ID", insertable = false, updatable = false)
	private StoreMessage StoreMessage;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "sC_state", insertable = false, updatable = false)
	private State State;

	public StoreCallback() {
	}

	public StoreCallback(Integer id, Integer storeMessageId, Integer memberId, String context, Date time,
			Integer stateId) {
		super();
		this.id = id;
		this.storeMessageId = storeMessageId;
		this.memberId = memberId;
		this.context = context;
		this.time = time;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "StoreCallback [id=" + id + ", storeMessageId=" + storeMessageId + ", memberId=" + memberId
				+ ", context=" + context + ", time=" + time + ", stateId=" + stateId + ", StoreMessage=" + StoreMessage
				+ ", Member=" + Member + ", State=" + State + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreMessageId() {
		return storeMessageId;
	}

	public void setStoreMessageId(Integer storeMessageId) {
		this.storeMessageId = storeMessageId;
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

	public StoreMessage getStoreMessage() {
		return StoreMessage;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

}
