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
public class StoreOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sO_ID", columnDefinition = "int", nullable = false)
	private Integer sO_id;

	@Column(name = "sP_ID", columnDefinition = "int", nullable = false)
	private Integer sP_id;

	@Column(name = "memS_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idOrder;

	@Column(name = "sO_tran", columnDefinition = "nvarchar(max)", nullable = false)
	private String sO_transport;

	@Column(name = "sO_pay", columnDefinition = "nvarchar(max)", nullable = false)
	private String sO_pay;

	@Column(name = "sO_rem", columnDefinition = "nvarchar(max)")
	private String sO_remarks;

	@Column(name = "sO_amt", columnDefinition = "int", nullable = false)
	private Integer sO_amount;

	@Column(name = "sO_sumPri", columnDefinition = "int", nullable = false)
	private Integer sO_sumPrice;

	@Column(name = "sO_time", columnDefinition = "datetime", nullable = false)
	private Date sO_time;

	@Column(name = "sO_state", columnDefinition = "int", nullable = false)
	private Integer sO_stateId;

	@ManyToOne
	@JoinColumn(name = "sP_ID", insertable = false, updatable = false)
	private StoreProduct storeProduct;

	@ManyToOne
	@JoinColumn(name = "memS_IDee", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "sO_state", insertable = false, updatable = false)
	private State state;

	public StoreOrder() {
	}

	public StoreOrder(Integer sO_id, Integer sP_id, Integer m_idOrder, String sO_transport, String sO_pay,
			String sO_remarks, Integer sO_amount, Integer sO_sumPrice, Date sO_time, Integer sO_stateId) {
		super();
		this.sO_id = sO_id;
		this.sP_id = sP_id;
		this.m_idOrder = m_idOrder;
		this.sO_transport = sO_transport;
		this.sO_pay = sO_pay;
		this.sO_remarks = sO_remarks;
		this.sO_amount = sO_amount;
		this.sO_sumPrice = sO_sumPrice;
		this.sO_time = sO_time;
		this.sO_stateId = sO_stateId;
	}

	@Override
	public String toString() {
		return "StoreOrder [sO_id=" + sO_id + ", sP_id=" + sP_id + ", m_idOrder=" + m_idOrder + ", sO_transport="
				+ sO_transport + ", sO_pay=" + sO_pay + ", sO_remarks=" + sO_remarks + ", sO_amount=" + sO_amount
				+ ", sO_sumPrice=" + sO_sumPrice + ", sO_time=" + sO_time + ", sO_stateId=" + sO_stateId
				+ ", storeProduct=" + storeProduct + "]\r\n";
	}

	public Integer getsO_id() {
		return sO_id;
	}

	public void setsO_id(Integer sO_id) {
		this.sO_id = sO_id;
	}

	public Integer getsP_id() {
		return sP_id;
	}

	public void setsP_id(Integer sP_id) {
		this.sP_id = sP_id;
	}

	public Integer getM_idOrder() {
		return m_idOrder;
	}

	public void setM_idOrder(Integer m_idOrder) {
		this.m_idOrder = m_idOrder;
	}

	public String getsO_transport() {
		return sO_transport;
	}

	public void setsO_transport(String sO_transport) {
		this.sO_transport = sO_transport;
	}

	public String getsO_pay() {
		return sO_pay;
	}

	public void setsO_pay(String sO_pay) {
		this.sO_pay = sO_pay;
	}

	public String getsO_remarks() {
		return sO_remarks;
	}

	public void setsO_remarks(String sO_remarks) {
		this.sO_remarks = sO_remarks;
	}

	public Integer getsO_amount() {
		return sO_amount;
	}

	public void setsO_amount(Integer sO_amount) {
		this.sO_amount = sO_amount;
	}

	public Integer getsO_sumPrice() {
		return sO_sumPrice;
	}

	public void setsO_sumPrice(Integer sO_sumPrice) {
		this.sO_sumPrice = sO_sumPrice;
	}

	public Date getsO_time() {
		return sO_time;
	}

	public void setsO_time(Date sO_time) {
		this.sO_time = sO_time;
	}

	public Integer getsO_stateId() {
		return sO_stateId;
	}

	public void setsO_stateId(Integer sO_stateId) {
		this.sO_stateId = sO_stateId;
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
