package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GroupAssess")
public class GroupAssess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gA_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "gM_ID", columnDefinition = "int")
	Integer groupMessageId;

	@Column(name = "gA_point", columnDefinition = "int")
	Integer point;

	@Column(name = "gA_cont", columnDefinition = "nvarchar(max)")
	String context;

	@Column(name = "gA_pointee", columnDefinition = "int")
	Integer pointEE;

	@Column(name = "gA_contee", columnDefinition = "nvarchar(max)")
	String contextEE;

	@Column(name = "gA_state", columnDefinition = "int")
	Integer state;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gM_ID", insertable = false, updatable = false)
	GroupMessage groupMessageBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gA_state", insertable = false, updatable = false)
	State stateBean;

	public GroupAssess() {
	}

	public GroupAssess(Integer id, Integer groupMessageId, Integer point, String context, Integer pointEE,
			String contextEE, Integer state) {
		this.id = id;
		this.groupMessageId = groupMessageId;
		this.point = point;
		this.context = context;
		this.pointEE = pointEE;
		this.contextEE = contextEE;
		this.state = state;
	}

	@Override
	public String toString() {
		return "GroupAssess [id=" + id + ", groupMessageId=" + groupMessageId + ", point=" + point + ", context="
				+ context + ", pointEE=" + pointEE + ", contextEE=" + contextEE + ", state=" + state
				+ "]\r\n  [groupMessageBean=" + groupMessageBean + "]\r\n  [stateBean=" + stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupMessageId() {
		return groupMessageId;
	}

	public void setGroupMessageId(Integer groupMessageId) {
		this.groupMessageId = groupMessageId;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getPointEE() {
		return pointEE;
	}

	public void setPointEE(Integer pointEE) {
		this.pointEE = pointEE;
	}

	public String getContextEE() {
		return contextEE;
	}

	public void setContextEE(String contextEE) {
		this.contextEE = contextEE;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public GroupMessage getGroupMessageBean() {
		return groupMessageBean;
	}

	public State getStateBean() {
		return stateBean;
	}
}
