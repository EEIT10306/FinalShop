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
	private Integer gM_id;

	@Column(name = "group_ID", columnDefinition = "int", nullable = false)
	private Integer g_id;

	@Column(name = "memG_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idMessage;

	@Column(name = "gM_cont", columnDefinition = "int", nullable = false)
	private Integer gM_context;

	@Column(name = "gM_time", columnDefinition = "daetime", nullable = false)
	private Date gM_time;

	@Column(name = "gM_state", columnDefinition = "int", nullable = false)
	private Integer gM_stateId;

	@ManyToOne
	@JoinColumn(name = "group_ID", insertable = false, updatable = false)
	private Groupon groupon;

	@ManyToOne
	@JoinColumn(name = "memG_IDee", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "gM_state", insertable = false, updatable = false)
	private State state;

	public GroupMessage() {
	}

	public GroupMessage(Integer gM_id, Integer g_id, Integer m_idMessage, Integer gM_context, Date gM_time,
			Integer gM_stateId) {
		super();
		this.gM_id = gM_id;
		this.g_id = g_id;
		this.m_idMessage = m_idMessage;
		this.gM_context = gM_context;
		this.gM_time = gM_time;
		this.gM_stateId = gM_stateId;
	}

	@Override
	public String toString() {
		return "GroupMessage [gM_id=" + gM_id + ", g_id=" + g_id + ", m_idMessage=" + m_idMessage + ", gM_context="
				+ gM_context + ", gM_time=" + gM_time + ", gM_stateId=" + gM_stateId + "]\r\n";
	}

	public Integer getgM_id() {
		return gM_id;
	}

	public void setgM_id(Integer gM_id) {
		this.gM_id = gM_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public Integer getM_idMessage() {
		return m_idMessage;
	}

	public void setM_idMessage(Integer m_idMessage) {
		this.m_idMessage = m_idMessage;
	}

	public Integer getgM_context() {
		return gM_context;
	}

	public void setgM_context(Integer gM_context) {
		this.gM_context = gM_context;
	}

	public Date getgM_time() {
		return gM_time;
	}

	public void setgM_time(Date gM_time) {
		this.gM_time = gM_time;
	}

	public Integer getgM_stateId() {
		return gM_stateId;
	}

	public void setgM_stateId(Integer gM_stateId) {
		this.gM_stateId = gM_stateId;
	}

	public Groupon getGroupon() {
		return groupon;
	}

	public void setGroupon(Groupon groupon) {
		this.groupon = groupon;
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
