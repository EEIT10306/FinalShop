package model.bean;

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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "group_ID", "mem_ID" }) })
public class GroupReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gR_ID", columnDefinition = "int", nullable = false)
	private Integer gR_id;

	@Column(name = "group_ID", columnDefinition = "int", nullable = false)
	private Integer g_id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer m_idReport;

	@Column(name = "gR_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String gR_content;

	@Column(name = "gR_state", columnDefinition = "int", nullable = false)
	private Integer gR_stateId;

	@ManyToOne
	@JoinColumn(name = "group_ID", insertable = false, updatable = false)
	private Groupon groupon;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "gR_state", insertable = false, updatable = false)
	private State state;

	public GroupReport() {
	}

	public GroupReport(Integer gR_id, Integer g_id, Integer m_idReport, String gR_content, Integer gR_stateId) {
		super();
		this.gR_id = gR_id;
		this.g_id = g_id;
		this.m_idReport = m_idReport;
		this.gR_content = gR_content;
		this.gR_stateId = gR_stateId;
	}

	@Override
	public String toString() {
		return "GroupReport [gR_id=" + gR_id + ", g_id=" + g_id + ", m_idReport=" + m_idReport + ", gR_content="
				+ gR_content + ", gR_stateId=" + gR_stateId + ", groupon=" + groupon + "]\r\n";
	}

	public Integer getgR_id() {
		return gR_id;
	}

	public void setgR_id(Integer gR_id) {
		this.gR_id = gR_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public Integer getM_idReport() {
		return m_idReport;
	}

	public void setM_idReport(Integer m_idReport) {
		this.m_idReport = m_idReport;
	}

	public String getgR_content() {
		return gR_content;
	}

	public void setgR_content(String gR_content) {
		this.gR_content = gR_content;
	}

	public Integer getgR_stateId() {
		return gR_stateId;
	}

	public void setgR_stateId(Integer gR_stateId) {
		this.gR_stateId = gR_stateId;
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
