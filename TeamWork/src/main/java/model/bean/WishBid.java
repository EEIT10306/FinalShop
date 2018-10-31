package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class WishBid {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wB_ID", columnDefinition = "int", nullable = false)
	private Integer wB_id;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer w_id;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idBid;

	@Column(name = "wB_bid", columnDefinition = "int", nullable = false)
	private Integer wB_bid;

	@Column(name = "wB_cont", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String wB_context;

	@Column(name = "wB_freight", columnDefinition = "int")
	private Integer wB_freight;

	@Column(name = "wB_time", columnDefinition = "datetime", nullable = false)
	private Date wB_time;

	@Column(name = "wB_state", columnDefinition = "int", nullable = false)
	private Integer wB_stateId;

	@OneToOne
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	private Wish wish;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "wB_state", insertable = false, updatable = false)
	private State state;

	public WishBid() {
	}

	public WishBid(Integer wB_id, Integer w_id, Integer m_idBid, Integer wB_bid, String wB_context, Integer wB_freight,
			Date wB_time, Integer wB_stateId) {
		super();
		this.wB_id = wB_id;
		this.w_id = w_id;
		this.m_idBid = m_idBid;
		this.wB_bid = wB_bid;
		this.wB_context = wB_context;
		this.wB_freight = wB_freight;
		this.wB_time = wB_time;
		this.wB_stateId = wB_stateId;
	}

	@Override
	public String toString() {
		return "WishBid [wB_id=" + wB_id + ", w_id=" + w_id + ", m_idBid=" + m_idBid + ", wB_bid=" + wB_bid
				+ ", wB_context=" + wB_context + ", wB_freight=" + wB_freight + ", wB_time=" + wB_time + ", wB_stateId="
				+ wB_stateId + ", wish=" + wish + ", member=" + member + ", state=" + state + "]\r\n";
	}

	public Integer getwB_id() {
		return wB_id;
	}

	public void setwB_id(Integer wB_id) {
		this.wB_id = wB_id;
	}

	public Integer getW_id() {
		return w_id;
	}

	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}

	public Integer getM_idBid() {
		return m_idBid;
	}

	public void setM_idBid(Integer m_idBid) {
		this.m_idBid = m_idBid;
	}

	public Integer getwB_bid() {
		return wB_bid;
	}

	public void setwB_bid(Integer wB_bid) {
		this.wB_bid = wB_bid;
	}

	public String getwB_context() {
		return wB_context;
	}

	public void setwB_context(String wB_context) {
		this.wB_context = wB_context;
	}

	public Integer getwB_freight() {
		return wB_freight;
	}

	public void setwB_freight(Integer wB_freight) {
		this.wB_freight = wB_freight;
	}

	public Date getwB_time() {
		return wB_time;
	}

	public void setwB_time(Date wB_time) {
		this.wB_time = wB_time;
	}

	public Integer getwB_stateId() {
		return wB_stateId;
	}

	public void setwB_stateId(Integer wB_stateId) {
		this.wB_stateId = wB_stateId;
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
