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
	private Integer sC_id;

	@Column(name = "sM_ID", columnDefinition = "int", nullable = false)
	private Integer sM_id;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idCallback;

	@Column(name = "sC_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String sC_context;

	@Column(name = "sC_time", columnDefinition = "datetime", nullable = false)
	private Date sC_time;

	@Column(name = "sC_state", columnDefinition = "int", nullable = false)
	private Integer sC_stateId;

	@ManyToOne
	@JoinColumn(name = "sM_ID", insertable = false, updatable = false)
	private StoreMessage storeMessage;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "sC_state", insertable = false, updatable = false)
	private State state;

	public StoreCallback() {
	}

	public StoreCallback(Integer sC_id, Integer sM_id, Integer m_idCallback, String sC_context, Date sC_time,
			Integer sC_stateId) {
		super();
		this.sC_id = sC_id;
		this.sM_id = sM_id;
		this.m_idCallback = m_idCallback;
		this.sC_context = sC_context;
		this.sC_time = sC_time;
		this.sC_stateId = sC_stateId;
	}


	@Override
	public String toString() {
		return "StoreCallback [sC_id=" + sC_id + ", sM_id=" + sM_id + ", m_idCallback=" + m_idCallback + ", sC_context="
				+ sC_context + ", sC_time=" + sC_time + ", sC_stateId=" + sC_stateId + ", storeMessage=" + storeMessage
				+ "]\r\n";
	}

	public Integer getsC_id() {
		return sC_id;
	}

	public void setsC_id(Integer sC_id) {
		this.sC_id = sC_id;
	}

	public Integer getsM_id() {
		return sM_id;
	}

	public void setsM_id(Integer sM_id) {
		this.sM_id = sM_id;
	}

	public Integer getM_idCallback() {
		return m_idCallback;
	}

	public void setM_idCallback(Integer m_idCallback) {
		this.m_idCallback = m_idCallback;
	}

	public String getsC_context() {
		return sC_context;
	}

	public void setsC_context(String sC_context) {
		this.sC_context = sC_context;
	}

	public Date getsC_time() {
		return sC_time;
	}

	public void setsC_time(Date sC_time) {
		this.sC_time = sC_time;
	}

	public Integer getsC_stateId() {
		return sC_stateId;
	}

	public void setsC_stateId(Integer sC_stateId) {
		this.sC_stateId = sC_stateId;
	}

	public StoreMessage getStoreMessage() {
		return storeMessage;
	}

	public void setStoreMessage(StoreMessage storeMessage) {
		this.storeMessage = storeMessage;
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
