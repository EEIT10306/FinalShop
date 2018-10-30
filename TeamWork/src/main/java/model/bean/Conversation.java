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
public class Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "con_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "memC_IDee", columnDefinition = "int", nullable = false)
	private Integer memberIdEE;

	@Column(name = "memC_ID", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "con_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String context;

	@Column(name = "con_time", columnDefinition = "datetime", nullable = false)
	private Date time;

	@Column(name = "con_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "memC_IDee", insertable = false, updatable = false)
	private Member MemberEE;

	@ManyToOne
	@JoinColumn(name = "memC_ID", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "con_state", insertable = false, updatable = false)
	private State State;

	public Conversation() {
	}

	public Conversation(Integer id, Integer memberIdEE, Integer memberId, String context, Date time, Integer stateId) {
		super();
		this.id = id;
		this.memberIdEE = memberIdEE;
		this.memberId = memberId;
		this.context = context;
		this.time = time;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "Conversation [id=" + id + ", memberIdEE=" + memberIdEE + ", memberId=" + memberId + ", context="
				+ context + ", time=" + time + ", stateId=" + stateId + ", MemberEE=" + MemberEE + ", Member=" + Member
				+ ", State=" + State + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberIdEE() {
		return memberIdEE;
	}

	public void setMemberIdEE(Integer memberIdEE) {
		this.memberIdEE = memberIdEE;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public Member getMemberEE() {
		return MemberEE;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

	public void setMemberEE(Member memberEE) {
		MemberEE = memberEE;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public void setState(State state) {
		State = state;
	}

}
