package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CommitAchievement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cA_ID", columnDefinition = "int", nullable = false)
	private Integer cA_id;

	@Column(name = "ach_ID", columnDefinition = "int", nullable = false)
	private Integer a_id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer m_id;

	@Column(name = "cA_amt", columnDefinition = "int", nullable = false)
	private Integer cA_amount;

	@Column(name = "cA_state", columnDefinition = "int", nullable = false)
	private Integer cA_stateId;

	@ManyToOne
	@JoinColumn(name = "ach_ID", insertable = false, updatable = false)
	private Achievement achievement;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member memeber;

	@ManyToOne
	@JoinColumn(name = "cA_state", insertable = false, updatable = false)
	private State state;

	public CommitAchievement() {
	}

	public CommitAchievement(Integer cA_id, Integer a_id, Integer m_id, Integer cA_amount, Integer cA_stateId) {
		super();
		this.cA_id = cA_id;
		this.a_id = a_id;
		this.m_id = m_id;
		this.cA_amount = cA_amount;
		this.cA_stateId = cA_stateId;
	}

	@Override
	public String toString() {
		return "CommitAchievement [cA_id=" + cA_id + ", a_id=" + a_id + ", m_id=" + m_id + ", cA_amount=" + cA_amount
				+ ", cA_stateId=" + cA_stateId + ", achievement=" + achievement + ", memeber=" + memeber + ", state="
				+ state + "]\r\n";
	}

	public Integer getcA_id() {
		return cA_id;
	}

	public void setcA_id(Integer cA_id) {
		this.cA_id = cA_id;
	}

	public Integer getA_id() {
		return a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public Integer getcA_amount() {
		return cA_amount;
	}

	public void setcA_amount(Integer cA_amount) {
		this.cA_amount = cA_amount;
	}

	public Integer getcA_stateId() {
		return cA_stateId;
	}

	public void setcA_stateId(Integer cA_stateId) {
		this.cA_stateId = cA_stateId;
	}

	public Achievement getAchievement() {
		return achievement;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Member getMemeber() {
		return memeber;
	}

	public void setMemeber(Member memeber) {
		this.memeber = memeber;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
