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
public class WishOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wO_ID", columnDefinition = "int", nullable = false)
	private Integer wO_id;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer w_id;

	@Column(name = "memW_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idOrder;

	@Column(name = "wB_sumPri", columnDefinition = "int", nullable = false)
	private String wO_sumPrice;

	@Column(name = "wO_time", columnDefinition = "datetime", nullable = false)
	private Date wO_time;

	@Column(name = "wO_state", columnDefinition = "int", nullable = false)
	private Integer wO_stateId;

	@ManyToOne
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	private Wish wish;

	@ManyToOne
	@JoinColumn(name = "memW_IDee", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "wO_state", insertable = false, updatable = false)
	private State state;

	public WishOrder() {
	}

	public WishOrder(Integer wO_id, Integer w_id, Integer m_idOrder, String wO_sumPrice, Date wO_time,
			Integer wO_stateId) {
		super();
		this.wO_id = wO_id;
		this.w_id = w_id;
		this.m_idOrder = m_idOrder;
		this.wO_sumPrice = wO_sumPrice;
		this.wO_time = wO_time;
		this.wO_stateId = wO_stateId;
	}

	@Override
	public String toString() {
		return "WishOrder [wO_id=" + wO_id + ", w_id=" + w_id + ", m_idOrder=" + m_idOrder + ", wO_sumPrice="
				+ wO_sumPrice + ", wO_time=" + wO_time + ", wO_stateId=" + wO_stateId + ", wish=" + wish + ", member="
				+ member + ", state=" + state + "]\r\n";
	}

	public Integer getwO_id() {
		return wO_id;
	}

	public void setwO_id(Integer wO_id) {
		this.wO_id = wO_id;
	}

	public Integer getW_id() {
		return w_id;
	}

	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}

	public Integer getM_idOrder() {
		return m_idOrder;
	}

	public void setM_idOrder(Integer m_idOrder) {
		this.m_idOrder = m_idOrder;
	}

	public String getwO_sumPrice() {
		return wO_sumPrice;
	}

	public void setwO_sumPrice(String wO_sumPrice) {
		this.wO_sumPrice = wO_sumPrice;
	}

	public Date getwO_time() {
		return wO_time;
	}

	public void setwO_time(Date wO_time) {
		this.wO_time = wO_time;
	}

	public Integer getwO_stateId() {
		return wO_stateId;
	}

	public void setwO_stateId(Integer wO_stateId) {
		this.wO_stateId = wO_stateId;
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
