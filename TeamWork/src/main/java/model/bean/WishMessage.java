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
public class WishMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wM_ID", columnDefinition = "int", nullable = false)
	private Integer wM_id;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer w_id;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idMessage;

	@Column(name = "wM_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String wM_context;

	@Column(name = "wM_time", columnDefinition = "daetime", nullable = false)
	private Date wM_time;

	@Column(name = "wM_state", columnDefinition = "int", nullable = false)
	private Integer wM_stateId;

	@ManyToOne
	@JoinColumn(name = "wist_ID", insertable = false, updatable = false)
	private Wish wish;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "wM_state", insertable = false, updatable = false)
	private State state;

	public WishMessage() {
	}

	public WishMessage(Integer wM_id, Integer w_id, Integer m_idMessage, String wM_context, Date wM_time,
			Integer wM_stateId) {
		super();
		this.wM_id = wM_id;
		this.w_id = w_id;
		this.m_idMessage = m_idMessage;
		this.wM_context = wM_context;
		this.wM_time = wM_time;
		this.wM_stateId = wM_stateId;
	}

	@Override
	public String toString() {
		return "WishMessage [wM_id=" + wM_id + ", w_id=" + w_id + ", m_idMessage=" + m_idMessage + ", wM_context="
				+ wM_context + ", wM_time=" + wM_time + ", wM_stateId=" + wM_stateId + ", wish=" + wish + ", member="
				+ member + ", state=" + state + "]\r\n";
	}

	public Integer getwM_id() {
		return wM_id;
	}

	public void setwM_id(Integer wM_id) {
		this.wM_id = wM_id;
	}

	public Integer getW_id() {
		return w_id;
	}

	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}

	public Integer getM_idMessage() {
		return m_idMessage;
	}

	public void setM_idMessage(Integer m_idMessage) {
		this.m_idMessage = m_idMessage;
	}

	public String getwM_context() {
		return wM_context;
	}

	public void setwM_context(String wM_context) {
		this.wM_context = wM_context;
	}

	public Date getwM_time() {
		return wM_time;
	}

	public void setwM_time(Date wM_time) {
		this.wM_time = wM_time;
	}

	public Integer getwM_stateId() {
		return wM_stateId;
	}

	public void setwM_stateId(Integer wM_stateId) {
		this.wM_stateId = wM_stateId;
	}

	public Wish getWish() {
		return wish;
	}

	public void setWish(Wish wish) {
		this.wish = wish;
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
