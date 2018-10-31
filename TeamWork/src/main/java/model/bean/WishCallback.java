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
public class WishCallback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wC_ID", columnDefinition = "int", nullable = false)
	private Integer wC_id;

	@Column(name = "wM_ID", columnDefinition = "int", nullable = false)
	private Integer wM_id;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idCallback;

	@Column(name = "wC_cont", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String wC_context;

	@Column(name = "wC_time", columnDefinition = "datetime", nullable = false)
	private Date wC_time;

	@Column(name = "wC_state", columnDefinition = "int", nullable = false)
	private Integer wC_stateId;

	@ManyToOne
	@JoinColumn(name = "wM_ID", insertable = false, updatable = false)
	private WishMessage wishMessage;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "wC_state", insertable = false, updatable = false)
	private State state;

	public WishCallback() {
	}

	public WishCallback(Integer wC_id, Integer wM_id, Integer m_idCallback, String wC_context, Date wC_time,
			Integer wC_stateId) {
		super();
		this.wC_id = wC_id;
		this.wM_id = wM_id;
		this.m_idCallback = m_idCallback;
		this.wC_context = wC_context;
		this.wC_time = wC_time;
		this.wC_stateId = wC_stateId;
	}

	@Override
	public String toString() {
		return "WishCallback [wC_id=" + wC_id + ", wM_id=" + wM_id + ", m_idCallback=" + m_idCallback + ", wC_context="
				+ wC_context + ", wC_time=" + wC_time + ", wC_stateId=" + wC_stateId + ", wishMessage=" + wishMessage
				+ ", member=" + member + ", state=" + state + "]\r\n";
	}

	public Integer getwC_id() {
		return wC_id;
	}

	public void setwC_id(Integer wC_id) {
		this.wC_id = wC_id;
	}

	public Integer getwM_id() {
		return wM_id;
	}

	public void setwM_id(Integer wM_id) {
		this.wM_id = wM_id;
	}

	public Integer getM_idCallback() {
		return m_idCallback;
	}

	public void setM_idCallback(Integer m_idCallback) {
		this.m_idCallback = m_idCallback;
	}

	public String getwC_context() {
		return wC_context;
	}

	public void setwC_context(String wC_context) {
		this.wC_context = wC_context;
	}

	public Date getwC_time() {
		return wC_time;
	}

	public void setwC_time(Date wC_time) {
		this.wC_time = wC_time;
	}

	public Integer getwC_stateId() {
		return wC_stateId;
	}

	public void setwC_stateId(Integer wC_stateId) {
		this.wC_stateId = wC_stateId;
	}

	public WishMessage getWishMessage() {
		return wishMessage;
	}

	public void setWishMessage(WishMessage wishMessage) {
		this.wishMessage = wishMessage;
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
