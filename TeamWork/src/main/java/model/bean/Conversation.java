package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "memC_IDee", "memC_ID" }) })
public class Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "con_ID", columnDefinition = "int", nullable = false)
	private Integer c_id;

	@Column(name = "memC_IDee", columnDefinition = "int", nullable = false)
	private Integer m_idConversation;

	@Column(name = "memC_ID", columnDefinition = "int", nullable = false)
	private Integer m_id;

	@Column(name = "con_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String c_context;

	@Column(name = "con_time", columnDefinition = "datetime", nullable = false)
	private Date c_time;

	@Column(name = "con_state", columnDefinition = "int", nullable = false)
	private Integer c_stateId;

	@ManyToOne
	@JoinColumn(name = "memC_IDee", insertable = false, updatable = false)
	private Member memberConversation;

	@ManyToOne
	@JoinColumn(name = "memC_ID", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "con_state", insertable = false, updatable = false)
	private State state;

	public Conversation() {
	}

	public Conversation(Integer c_id, Integer m_idConversation, Integer m_id, String c_context, Date c_time,
			Integer c_stateId) {
		super();
		this.c_id = c_id;
		this.m_idConversation = m_idConversation;
		this.m_id = m_id;
		this.c_context = c_context;
		this.c_time = c_time;
		this.c_stateId = c_stateId;
	}

	@Override
	public String toString() {
		return "Conversation [c_id=" + c_id + ", m_idConversation=" + m_idConversation + ", m_id=" + m_id
				+ ", c_context=" + c_context + ", c_time=" + c_time + ", c_stateId=" + c_stateId
				+ ", memberConversation=" + memberConversation + ", member=" + member + ", state=" + state + "]\r\n";
	}

	public Integer getC_id() {
		return c_id;
	}

	public void setC_id(Integer c_id) {
		this.c_id = c_id;
	}

	public Integer getM_idConversation() {
		return m_idConversation;
	}

	public void setM_idConversation(Integer m_idConversation) {
		this.m_idConversation = m_idConversation;
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public String getC_context() {
		return c_context;
	}

	public void setC_context(String c_context) {
		this.c_context = c_context;
	}

	public Date getC_time() {
		return c_time;
	}

	public void setC_time(Date c_time) {
		this.c_time = c_time;
	}

	public Integer getC_stateId() {
		return c_stateId;
	}

	public void setC_stateId(Integer c_stateId) {
		this.c_stateId = c_stateId;
	}

	public Member getMemberConversation() {
		return memberConversation;
	}

	public void setMemberConversation(Member memberConversation) {
		this.memberConversation = memberConversation;
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
