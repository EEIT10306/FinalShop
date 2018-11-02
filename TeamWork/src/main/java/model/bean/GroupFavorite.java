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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "mem_ID", "group_ID" }) })
public class GroupFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gF_ID", columnDefinition = "int", nullable = false)
	private Integer gF_id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer m_idFavorite;

	@Column(name = "group_ID", columnDefinition = "int", nullable = false)
	private Integer g_id;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "group_ID", insertable = false, updatable = false)
	private Groupon groupon;

	public GroupFavorite() {
	}

	public GroupFavorite(Integer gF_id, Integer m_idFavorite, Integer g_id) {
		super();
		this.gF_id = gF_id;
		this.m_idFavorite = m_idFavorite;
		this.g_id = g_id;
	}

	@Override
	public String toString() {
		return "GroupFavorite [gF_id=" + gF_id + ", m_idFavorite=" + m_idFavorite + ", g_id=" + g_id + ", member="
				+ member + ", groupon=" + groupon + "]\r\n";
	}

	public Integer getgF_id() {
		return gF_id;
	}

	public void setgF_id(Integer gF_id) {
		this.gF_id = gF_id;
	}

	public Integer getM_idFavorite() {
		return m_idFavorite;
	}

	public void setM_idFavorite(Integer m_idFavorite) {
		this.m_idFavorite = m_idFavorite;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Groupon getGroupon() {
		return groupon;
	}

	public void setGroupon(Groupon groupon) {
		this.groupon = groupon;
	}

}
