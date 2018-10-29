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
//@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "gP_ID", "memG_IDee" }) })
public class GroupMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gM_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "group_ID", columnDefinition = "int", nullable = false)
	private Integer groupId;

	@Column(name = "memG_IDee", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "gM_cont", columnDefinition = "int", nullable = false)
	private Integer context;

	@Column(name = "gM_time", columnDefinition = "daetime", nullable = false)
	private Date time;

	@Column(name = "gM_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "group_ID", insertable = false, updatable = false)
	private Groupon Groupon;

	@ManyToOne
	@JoinColumn(name = "memG_IDee", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "gM_state", insertable = false, updatable = false)
	private State State;

	public GroupMessage() {
	}

	public GroupMessage(Integer id, Integer groupId, Integer memberId, Integer context, Date time, Integer stateId) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.memberId = memberId;
		this.context = context;
		this.time = time;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "GroupMessage [id=" + id + ", groupId=" + groupId + ", memberId=" + memberId + ", context=" + context
				+ ", time=" + time + ", stateId=" + stateId + ", Groupon=" + Groupon + ", Member=" + Member + ", State="
				+ State + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getContext() {
		return context;
	}

	public void setContext(Integer context) {
		this.context = context;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Groupon getGroupon() {
		return Groupon;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

}
