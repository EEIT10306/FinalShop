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
public class StoreReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sR_ID", columnDefinition = "int", nullable = false)
	private Integer sR_id;

	@Column(name = "sP_ID", columnDefinition = "int", nullable = false)
	private Integer sP_id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer m_idReport;

	@Column(name = "sR_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String sR_content;

	@Column(name = "sR_time", columnDefinition = "datetime", nullable = false)
	private Date sR_time;

	@Column(name = "sR_state", columnDefinition = "int", nullable = false)
	private Integer sR_stateId;

	@ManyToOne
	@JoinColumn(name = "sP_ID", insertable = false, updatable = false)
	private StoreProduct storeProduct;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "sR_state", insertable = false, updatable = false)
	private State state;

	public StoreReport() {
	}

	public StoreReport(Integer sR_id, Integer sP_id, Integer m_idReport, String sR_content, Date sR_time,
			Integer sR_stateId) {
		super();
		this.sR_id = sR_id;
		this.sP_id = sP_id;
		this.m_idReport = m_idReport;
		this.sR_content = sR_content;
		this.sR_time = sR_time;
		this.sR_stateId = sR_stateId;
	}

	@Override
	public String toString() {
		return "StoreReport [sR_id=" + sR_id + ", sP_id=" + sP_id + ", m_idReport=" + m_idReport + ", sR_content="
				+ sR_content + ", sR_time=" + sR_time + ", sR_stateId=" + sR_stateId + ", storeProduct=" + storeProduct
				+ "]\r\n";
	}

	public Integer getsR_id() {
		return sR_id;
	}

	public void setsR_id(Integer sR_id) {
		this.sR_id = sR_id;
	}

	public Integer getsP_id() {
		return sP_id;
	}

	public void setsP_id(Integer sP_id) {
		this.sP_id = sP_id;
	}

	public Integer getM_idReport() {
		return m_idReport;
	}

	public void setM_idReport(Integer m_idReport) {
		this.m_idReport = m_idReport;
	}

	public String getsR_content() {
		return sR_content;
	}

	public void setsR_content(String sR_content) {
		this.sR_content = sR_content;
	}

	public Integer getsR_stateId() {
		return sR_stateId;
	}

	public void setsR_stateId(Integer sR_stateId) {
		this.sR_stateId = sR_stateId;
	}

	public Date getsR_time() {
		return sR_time;
	}

	public void setsR_time(Date sR_time) {
		this.sR_time = sR_time;
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
