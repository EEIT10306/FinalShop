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
	private Integer gC_id;

	@Column(name = "gM_ID", columnDefinition = "int", nullable = false)
	private Integer gM_id;

	@Column(name = "mem_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idCallback;

	@Column(name = "gC_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String gC_context;

	@Column(name = "gC_time", columnDefinition = "datetime", nullable = false)
	private Date gC_time;

	@Column(name = "gC_state", columnDefinition = "int", nullable = false)
	private Integer gC_stateId;

	@ManyToOne
	@JoinColumn(name = "gM_ID", insertable = false, updatable = false)
	private GroupMessage groupMessage;

	@ManyToOne
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "gC_state", insertable = false, updatable = false)
	private State state;

	public GroupCallback() {
	}

	public GroupCallback(Integer gC_id, Integer gM_id, Integer m_idCallback, String gC_context, Date gC_time,
			Integer gC_stateId) {
		super();
		this.gC_id = gC_id;
		this.gM_id = gM_id;
		this.m_idCallback = m_idCallback;
		this.gC_context = gC_context;
		this.gC_time = gC_time;
		this.gC_stateId = gC_stateId;
	}

	@Override
	public String toString() {
		return "GroupCallback [gC_id=" + gC_id + ", gM_id=" + gM_id + ", m_idCallback=" + m_idCallback + ", gC_context="
				+ gC_context + ", gC_time=" + gC_time + ", gC_stateId=" + gC_stateId + "]\r\n";
	}

	public Integer getgC_id() {
		return gC_id;
	}

	public void setgC_id(Integer gC_id) {
		this.gC_id = gC_id;
	}

	public Integer getgM_id() {
		return gM_id;
	}

	public void setgM_id(Integer gM_id) {
		this.gM_id = gM_id;
	}

	public Integer getM_idCallback() {
		return m_idCallback;
	}

	public void setM_idCallback(Integer m_idCallback) {
		this.m_idCallback = m_idCallback;
	}

	public String getgC_context() {
		return gC_context;
	}

	public void setgC_context(String gC_context) {
		this.gC_context = gC_context;
	}

	public Date getgC_time() {
		return gC_time;
	}

	public void setgC_time(Date gC_time) {
		this.gC_time = gC_time;
	}

	public Integer getgC_stateId() {
		return gC_stateId;
	}

	public void setgC_stateId(Integer gC_stateId) {
		this.gC_stateId = gC_stateId;
	}

	public GroupMessage getGroupMessage() {
		return groupMessage;
	}

	public void setGroupMessage(GroupMessage groupMessage) {
		this.groupMessage = groupMessage;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
