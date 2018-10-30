package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GroupReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gR_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "group_ID", columnDefinition = "int", nullable = false)
	private Integer groupId;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "gR_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String content;

	@Column(name = "gR_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "group_ID", insertable = false, updatable = false)
	private Groupon Groupon;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "gR_state", insertable = false, updatable = false)
	private State State;

	public GroupReport() {
	}

	public GroupReport(Integer id, Integer groupId, Integer memberId, String content, Integer stateId) {
		super();
		this.id = id;
		this.groupId = groupId;
		this.memberId = memberId;
		this.content = content;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "GroupReport [id=" + id + ", groupId=" + groupId + ", memberId=" + memberId + ", content=" + content
				+ ", stateId=" + stateId + ", Groupon=" + Groupon + ", Member=" + Member + ", State=" + State + "]\r\n";
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public void setGroupon(Groupon groupon) {
		Groupon = groupon;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public void setState(State state) {
		State = state;
	}

}
