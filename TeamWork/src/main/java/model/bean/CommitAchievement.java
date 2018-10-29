package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class CommitAchievement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cA_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "ach_ID", columnDefinition = "int", nullable = false)
	private Integer achievementId;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "cA_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "ach_ID", insertable = false, updatable = false)
	private Achievement Achievement;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member Memeber;

	@ManyToOne
	@JoinColumn(name = "cA_state", insertable = false, updatable = false)
	private State State;

	public CommitAchievement() {
	}

	public CommitAchievement(Integer id, Integer achievementId, Integer memberId, Integer stateId) {
		super();
		this.id = id;
		this.achievementId = achievementId;
		this.memberId = memberId;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "CommitAchievement [id=" + id + ", achievementId=" + achievementId + ", memberId=" + memberId
				+ ", stateId=" + stateId + ", Achievement=" + Achievement + ", Memeber=" + Memeber + ", State=" + State
				+ "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public Integer getAchievementId() {
		return achievementId;
	}

	public void setAchievementId(Integer achievementId) {
		this.achievementId = achievementId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Achievement getAchievement() {
		return Achievement;
	}

	public Member getMemeber() {
		return Memeber;
	}

	public State getState() {
		return State;
	}

}
