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
@Table(name = "WishReport")
public class WishReport {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "wR_ID", columnDefinition = "int")
	Integer id;
	 
	@Column(name = "wR_cont", columnDefinition = "nvarchar(max)")
	String content;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wP_ID", insertable = false, updatable = false)
	WishProduct wishProduct;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	Member member;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wR_state", insertable = false, updatable = false)
	WishReport wishReport;

	public WishReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WishReport(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public WishProduct getWishProduct() {
		return wishProduct;
	}

	public void setWishProduct(WishProduct wishProduct) {
		this.wishProduct = wishProduct;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public WishReport getWishReport() {
		return wishReport;
	}

	public void setWishReport(WishReport wishReport) {
		this.wishReport = wishReport;
	}

				
}
