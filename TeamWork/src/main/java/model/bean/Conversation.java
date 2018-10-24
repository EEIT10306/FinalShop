package model.bean;

import java.util.Date;

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
public class Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "con_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "memC_IDee", columnDefinition = "int")
	Integer memberIdEE;

	@Column(name = "memC_ID", columnDefinition = "int")
	Integer memberId;

	@Column(name = "con_cont", columnDefinition = "nvarchar(max)")
	String context;

	@Column(name = "con_time", columnDefinition = "datetime")
	Date achievementID;

	@Column(name = "con_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "memC_IDee", insertable = false, updatable = false)
	Member memberEEBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "memC_ID", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "con_state", insertable = false, updatable = false)
	State stateBean;

	public Conversation() {
	}

	public Conversation(Integer id, Integer memberIdEE, Integer memberId, String context, Date achievementID,
			Integer state) {
		this.id = id;
		this.memberIdEE = memberIdEE;
		this.memberId = memberId;
		this.context = context;
		this.achievementID = achievementID;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Conversation [id=" + id + ", memberIdEE=" + memberIdEE + ", memberId=" + memberId + ", context="
				+ context + ", achievementID=" + achievementID + ", state=" + state + "]\r\n  [memberEEBean="
				+ memberEEBean + "]\r\n  [memberBean=" + memberBean + "]\r\n  [stateBean=" + stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberIdEE() {
		return memberIdEE;
	}

	public void setMemberIdEE(Integer memberIdEE) {
		this.memberIdEE = memberIdEE;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getAchievementID() {
		return achievementID;
	}

	public void setAchievementID(Date achievementID) {
		this.achievementID = achievementID;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Member getMemberEEBean() {
		return memberEEBean;
	}

	public void setMemberEEBean(Member memberEEBean) {
		this.memberEEBean = memberEEBean;
	}

	public Member getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(Member memberBean) {
		this.memberBean = memberBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
