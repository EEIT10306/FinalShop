package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WishReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wR_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer wishId;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "wR_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String content;

	@Column(name = "wR_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	private Wish Wish;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "wR_state", insertable = false, updatable = false)
	private State State;

	public WishReport() {
	}

	public WishReport(Integer id, Integer wishId, Integer memberId, String content, Integer stateId) {
		super();
		this.id = id;
		this.wishId = wishId;
		this.memberId = memberId;
		this.content = content;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "WishReport [id=" + id + ", wishId=" + wishId + ", memberId=" + memberId + ", content=" + content
				+ ", stateId=" + stateId + ", Wish=" + Wish + ", Member=" + Member + ", State=" + State + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWishId() {
		return wishId;
	}

	public void setWishId(Integer wishId) {
		this.wishId = wishId;
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

	public Wish getWish() {
		return Wish;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

	public void setWish(Wish wish) {
		Wish = wish;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public void setState(State state) {
		State = state;
	}

}
