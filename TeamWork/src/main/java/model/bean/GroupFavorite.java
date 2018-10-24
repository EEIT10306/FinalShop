package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GroupFavorite")
public class GroupFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gF_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "mem_ID", columnDefinition = "int")
	Integer memberId;

	@Column(name = "gP_ID", columnDefinition = "int")
	Integer groupProductId;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gP_ID", insertable = false, updatable = false)
	GroupProduct groupProductBean;

	public GroupFavorite() {
	}

	public GroupFavorite(Integer id, Integer memberId, Integer groupProductId) {
		this.id = id;
		this.memberId = memberId;
		this.groupProductId = groupProductId;
	}

	@Override
	public String toString() {
		return "GroupFavorite [id=" + id + ", memberId=" + memberId + ", groupProductId=" + groupProductId
				+ "]\r\n  [memberBean=" + memberBean + "]\r\n  [groupProductBean=" + groupProductBean + "]\r\n";
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

	public Integer getGroupProductId() {
		return groupProductId;
	}

	public void setGroupProductId(Integer groupProductId) {
		this.groupProductId = groupProductId;
	}

	public Member getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(Member memberBean) {
		this.memberBean = memberBean;
	}

	public GroupProduct getGroupProductBean() {
		return groupProductBean;
	}

	public void setGroupProductBean(GroupProduct groupProductBean) {
		this.groupProductBean = groupProductBean;
	}

}
