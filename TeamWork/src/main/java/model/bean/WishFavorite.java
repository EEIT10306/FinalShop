package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WishFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wF_ID", columnDefinition = "int", nullable = false)
	private Integer wF_id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer m_idFavorite;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer w_id;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	private Wish wish;

	public WishFavorite() {
	}

	public WishFavorite(Integer wF_id, Integer m_idFavorite, Integer w_id) {
		super();
		this.wF_id = wF_id;
		this.m_idFavorite = m_idFavorite;
		this.w_id = w_id;
	}

	@Override
	public String toString() {
		return "WishFavorite [wF_id=" + wF_id + ", m_idFavorite=" + m_idFavorite + ", w_id=" + w_id + ", member="
				+ member + ", wish=" + wish + "]\r\n";
	}

	public Integer getwF_id() {
		return wF_id;
	}

	public void setwF_id(Integer wF_id) {
		this.wF_id = wF_id;
	}

	public Integer getM_idFavorite() {
		return m_idFavorite;
	}

	public void setM_idFavorite(Integer m_idFavorite) {
		this.m_idFavorite = m_idFavorite;
	}

	public Integer getW_id() {
		return w_id;
	}

	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Wish getWish() {
		return wish;
	}

	public void setWish(Wish wish) {
		this.wish = wish;
	}

}
