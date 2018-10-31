package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WishReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wR_ID", columnDefinition = "int", nullable = false)
	private Integer wR_id;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer w_id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer m_idReport;

	@Column(name = "wR_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String wR_content;

	@Column(name = "wR_state", columnDefinition = "int", nullable = false)
	private Integer wR_stateId;

	@ManyToOne
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	private Wish wish;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "wR_state", insertable = false, updatable = false)
	private State state;

	public WishReport() {
	}

	public WishReport(Integer wR_id, Integer w_id, Integer m_idReport, String wR_content, Integer wR_stateId) {
		super();
		this.wR_id = wR_id;
		this.w_id = w_id;
		this.m_idReport = m_idReport;
		this.wR_content = wR_content;
		this.wR_stateId = wR_stateId;
	}

	@Override
	public String toString() {
		return "WishReport [wR_id=" + wR_id + ", w_id=" + w_id + ", m_idReport=" + m_idReport + ", wR_content="
				+ wR_content + ", wR_stateId=" + wR_stateId + ", wish=" + wish + ", member=" + member + ", state="
				+ state + "]\r\n";
	}

	public Integer getwR_id() {
		return wR_id;
	}

	public void setwR_id(Integer wR_id) {
		this.wR_id = wR_id;
	}

	public Integer getW_id() {
		return w_id;
	}

	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}

	public Integer getM_idReport() {
		return m_idReport;
	}

	public void setM_idReport(Integer m_idReport) {
		this.m_idReport = m_idReport;
	}

	public String getwR_content() {
		return wR_content;
	}

	public void setwR_content(String wR_content) {
		this.wR_content = wR_content;
	}

	public Integer getwR_stateId() {
		return wR_stateId;
	}

	public void setwR_stateId(Integer wR_stateId) {
		this.wR_stateId = wR_stateId;
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
