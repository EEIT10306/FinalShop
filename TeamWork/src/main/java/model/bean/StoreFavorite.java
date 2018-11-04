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
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "mem_ID", "sP_ID" }) })
public class StoreFavorite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sF_ID", columnDefinition = "int", nullable = false)
	private Integer sF_id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer m_idFavorite;

	@Column(name = "sP_ID", columnDefinition = "int", nullable = false)
	private Integer sP_id;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "sP_ID", insertable = false, updatable = false)
	private StoreProduct storeProduct;

	public StoreFavorite() {
	}

	public StoreFavorite(Integer sF_id, Integer m_idFavorite, Integer sP_id) {
		super();
		this.sF_id = sF_id;
		this.m_idFavorite = m_idFavorite;
		this.sP_id = sP_id;
	}

	@Override
	public String toString() {
		return "StoreFavorite [sF_id=" + sF_id + ", m_idFavorite=" + m_idFavorite + ", sP_id=" + sP_id + ", member="
				+ member + ", storeProduct=" + storeProduct + "]\r\n";
	}

	public Integer getsF_id() {
		return sF_id;
	}

	public void setsF_id(Integer sF_id) {
		this.sF_id = sF_id;
	}

	public Integer getM_idFavorite() {
		return m_idFavorite;
	}

	public void setM_idFavorite(Integer m_idFavorite) {
		this.m_idFavorite = m_idFavorite;
	}

	public Integer getsP_id() {
		return sP_id;
	}

	public void setsP_id(Integer sP_id) {
		this.sP_id = sP_id;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public StoreProduct getStoreProduct() {
		return storeProduct;
	}

	public void setStoreProduct(StoreProduct storeProduct) {
		this.storeProduct = storeProduct;
	}

}
