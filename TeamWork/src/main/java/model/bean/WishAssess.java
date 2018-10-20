package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "WishAssess")
public class WishAssess {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "wA_ID", columnDefinition = "int")
	Integer id;
	 
	@Column(name = "wA_point", columnDefinition = "int")
	Integer point;
	
	@Column(name = "wA_cont", columnDefinition = "nvarchar(max)")
	String content;
	
	@Column(name = "wA_pointee", columnDefinition = "int")
	Integer pointee;
	
	@Column(name = "wA_contee", columnDefinition = "nvarchar(max)")
	String contee;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wM_ID", insertable = false, updatable = false)
	WishMessage wishMessage;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wA_state", insertable = false, updatable = false)
	WishAssess wishAssess;

	public WishAssess() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WishAssess(Integer id, Integer point, String content, Integer pointee, String contee) {
		super();
		this.id = id;
		this.point = point;
		this.content = content;
		this.pointee = pointee;
		this.contee = contee;
	}

	@Override
	public String toString() {
		return "WishAssess [id=" + id + ", point=" + point + ", content=" + content + ", pointee=" + pointee
				+ ", contee=" + contee + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getPointee() {
		return pointee;
	}

	public void setPointee(Integer pointee) {
		this.pointee = pointee;
	}

	public String getContee() {
		return contee;
	}

	public void setContee(String contee) {
		this.contee = contee;
	}

	public WishMessage getWishMessage() {
		return wishMessage;
	}

	public void setWishMessage(WishMessage wishMessage) {
		this.wishMessage = wishMessage;
	}

	public WishAssess getWishAssess() {
		return wishAssess;
	}

	public void setWishAssess(WishAssess wishAssess) {
		this.wishAssess = wishAssess;
	}

	

				
}
