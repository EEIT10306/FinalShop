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
	Integer groupProductID;

	@Column(name = "gS_rule", columnDefinition = "nvarchar(max)")
	String rule;

	@Column(name = "gS_off", columnDefinition = "float")
	Double off;

	@Column(name = "gS_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gP_ID", insertable = false, updatable = false)
	GroupProduct groupProductBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gS_state", insertable = false, updatable = false)
	State stateBean;

	public GroupService() {
	}

	public GroupService(Integer id, Integer groupProductID, String rule, Double off, Integer state) {
		this.id = id;
		this.groupProductID = groupProductID;
		this.rule = rule;
		this.off = off;
		this.state = state;
	}

	@Override
	public String toString() {
		return "GroupService [id=" + id + ", groupProductID=" + groupProductID + ", rule=" + rule + ", off=" + off
				+ ", state=" + state + "]\r\n  [groupProductBean=" + groupProductBean + "]\r\n  [stateBean=" + stateBean
				+ "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupProductID() {
		return groupProductID;
	}

	public void setGroupProductID(Integer groupProductID) {
		this.groupProductID = groupProductID;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public GroupProduct getGroupProductBean() {
		return groupProductBean;
	}

	public State getStateBean() {
		return stateBean;
	}
}
