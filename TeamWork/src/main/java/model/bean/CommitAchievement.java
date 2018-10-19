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

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "achID", insertable = false, updatable = false)
	Achievement ach;

	public CommitAchievement() {}
	
	public CommitAchievement(Integer id, Integer achievementID, Integer memberID) {
		this.id = id;
		this.achievementID = achievementID;
		this.memberID = memberID;
	}
	
	@Override
	public String toString() {
		return "CommitAchievement [id=" + id + ", achievementID=" + achievementID + ", memberID=" + memberID + "]";
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

	public Achievement getAch() {
		return ach;
	}

	public void setAch(Achievement ach) {
		this.ach = ach;
	}
}
