package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GroupFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gF_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "group_ID", columnDefinition = "int", nullable = false)
	private Integer groupId;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "group_ID", insertable = false, updatable = false)
	private Groupon Groupon;

	public GroupFavorite() {
	}

	public GroupFavorite(Integer id, Integer memberId, Integer groupId) {
		this.id = id;
		this.memberId = memberId;
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "GroupFavorite [id=" + id + ", memberId=" + memberId + ", groupId=" + groupId + ", Member=" + Member
				+ ", Groupon=" + Groupon + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Member getMember() {
		return Member;
	}

	public Groupon getGroupon() {
		return Groupon;
	}

	public void setMember(Member member) {
		Member = member;
	}

	public void setGroupon(Groupon groupon) {
		Groupon = groupon;
	}

}
