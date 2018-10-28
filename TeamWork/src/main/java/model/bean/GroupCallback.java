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
public class GroupCallback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gC_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "gM_ID", columnDefinition = "int", nullable = false)
	private Integer groupMessageId;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer memberIdEE;

	@Column(name = "gC_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String context;

	@Column(name = "gC_time", columnDefinition = "datetime", nullable = false)
	private Date time;

	@Column(name = "gC_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "gM_ID", insertable = false, updatable = false)
	private GroupMessage GroupMessage;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "gC_state", insertable = false, updatable = false)
	private State State;

	public GroupCallback() {
	}

	public GroupCallback(Integer id, Integer groupMessageId, Integer memberIdEE, String context, Date time,
			Integer stateId) {
		super();
		this.id = id;
		this.groupMessageId = groupMessageId;
		this.memberIdEE = memberIdEE;
		this.context = context;
		this.time = time;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "GroupCallback [id=" + id + ", groupMessageId=" + groupMessageId + ", memberIdEE=" + memberIdEE
				+ ", context=" + context + ", time=" + time + ", stateId=" + stateId + ", GroupMessage=" + GroupMessage
				+ ", Member=" + Member + ", State=" + State + "]\r\n";
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

	public Integer getMemberIdEE() {
		return memberIdEE;
	}

	public void setMemberIdEE(Integer memberIdEE) {
		this.memberIdEE = memberIdEE;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
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

	public GroupMessage getGroupMessage() {
		return GroupMessage;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

}
