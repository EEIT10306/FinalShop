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
	private Integer sM_id;

	@Column(name = "sP_ID", columnDefinition = "int", nullable = false)
	private Integer sP_id;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idMessage;

	@Column(name = "sM_cont", columnDefinition = "int", nullable = false)
	private Integer sM_context;

	@Column(name = "sM_time", columnDefinition = "daetime", nullable = false)
	private Date sM_time;

	@Column(name = "sM_state", columnDefinition = "int", nullable = false)
	private Integer sM_stateId;

	@ManyToOne
	@JoinColumn(name = "sP_ID", insertable = false, updatable = false)
	private StoreProduct storeProduct;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "sM_state", insertable = false, updatable = false)
	private State state;

	public StoreMessage() {
	}

	public StoreMessage(Integer sM_id, Integer sP_id, Integer m_idMessage, Integer sM_context, Date sM_time,
			Integer sM_stateId) {
		super();
		this.sM_id = sM_id;
		this.sP_id = sP_id;
		this.m_idMessage = m_idMessage;
		this.sM_context = sM_context;
		this.sM_time = sM_time;
		this.sM_stateId = sM_stateId;
	}

	@Override
	public String toString() {
		return "StoreMessage [sM_id=" + sM_id + ", sP_id=" + sP_id + ", m_idMessage=" + m_idMessage + ", sM_context="
				+ sM_context + ", sM_time=" + sM_time + ", sM_stateId=" + sM_stateId + ", storeProduct=" + storeProduct
				+ ", member=" + member + ", state=" + state + "]\r\n";
	}

	public Integer getsM_id() {
		return sM_id;
	}

	public void setsM_id(Integer sM_id) {
		this.sM_id = sM_id;
	}

	public Integer getsP_id() {
		return sP_id;
	}

	public void setsP_id(Integer sP_id) {
		this.sP_id = sP_id;
	}

	public Integer getM_idMessage() {
		return m_idMessage;
	}

	public void setM_idMessage(Integer m_idMessage) {
		this.m_idMessage = m_idMessage;
	}

	public Integer getsM_context() {
		return sM_context;
	}

	public void setsM_context(Integer sM_context) {
		this.sM_context = sM_context;
	}

	public Date getsM_time() {
		return sM_time;
	}

	public void setsM_time(Date sM_time) {
		this.sM_time = sM_time;
	}

	public Integer getsM_stateId() {
		return sM_stateId;
	}

	public void setsM_stateId(Integer sM_stateId) {
		this.sM_stateId = sM_stateId;
	}

	public StoreProduct getStoreProduct() {
		return storeProduct;
	}

	public void setStoreProduct(StoreProduct storeProduct) {
		this.storeProduct = storeProduct;
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
