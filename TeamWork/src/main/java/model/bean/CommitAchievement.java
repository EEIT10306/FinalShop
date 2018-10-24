package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CommitAchievement")
public class CommitAchievement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cA_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "ach_ID", columnDefinition = "int")
	Integer achievementID;

	@Column(name = "mem_ID", columnDefinition = "int")
	Integer memberID;

	@Column(name = "cA_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "ach_ID", insertable = false, updatable = false)
	Achievement achievement;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	Member memeberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cA_state", insertable = false, updatable = false)
	State stateBean;

	public CommitAchievement() {
	}

	public CommitAchievement(Integer id, Integer achievementID, Integer memberID) {
		this.id = id;
		this.achievementID = achievementID;
		this.memberID = memberID;
	}

	@Override
	public String toString() {
		return "CommitAchievement [id=" + id + ", achievementID=" + achievementID + ", memberID=" + memberID
				+ "]\r\n  [achievement=" + achievement + "]\r\n    [memeberBean=" + memeberBean + "]\r\n  [stateBean="
				+ stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAchievementID() {
		return achievementID;
	}

	public void setAchievementID(Integer achievementID) {
		this.achievementID = achievementID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Achievement getAchievement() {
		return achievement;
	}

	public void setAchievement(Achievement achievement) {
		this.achievement = achievement;
	}

	public Member getMemeberBean() {
		return memeberBean;
	}

	public void setMemeberBean(Member memeberBean) {
		this.memeberBean = memeberBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
