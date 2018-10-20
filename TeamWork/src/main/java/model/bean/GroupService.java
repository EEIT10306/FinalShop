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
@Table(name = "GroupService")
public class GroupService {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gS_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "gP_ID", columnDefinition = "int")
	Integer groupID;

	@Column(name = "gS_rule", columnDefinition = "nvarchar(max)")
	String rule;

	@Column(name = "gS_off", columnDefinition = "float")
	Double off;

	@Column(name = "gS_state", columnDefinition = "int")
	Integer groupState;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gP_ID", insertable = false, updatable = false)
	Group group;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gS_state", insertable = false, updatable = false)
	State state;

	public GroupService() {

	}

	public GroupService(Integer id, Integer groupID, String rule, Double off, Integer groupState) {
		this.id = id;
		this.groupID = groupID;
		this.rule = rule;
		this.off = off;
		this.groupState = groupState;
	}

	@Override
	public String toString() {
		return "GroupService [id=" + id + ", groupID=" + groupID + ", rule=" + rule + ", off=" + off + ", groupState="
				+ groupState + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupID() {
		return groupID;
	}

	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}

	public String getRule() {
		return rule;
	}

	public void setRule(String rule) {
		this.rule = rule;
	}

	public Double getOff() {
		return off;
	}

	public void setOff(Double off) {
		this.off = off;
	}

	public Integer getGroupState() {
		return groupState;
	}

	public void setGroupState(Integer groupState) {
		this.groupState = groupState;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
