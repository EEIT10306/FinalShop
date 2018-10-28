package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class WishAssess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wA_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "wO_ID", columnDefinition = "int", nullable = false)
	private Integer wishOrderId;

	@Column(name = "wA_point", columnDefinition = "int")
	private Integer point;

	@Column(name = "wA_cont", columnDefinition = "nvarchar(max)")
	private String context;

	@Column(name = "wA_pointee", columnDefinition = "int")
	private Integer pointEE;

	@Column(name = "wA_contee", columnDefinition = "nvarchar(max)")
	private String contextEE;

	@OneToOne
	@JoinColumn(name = "wo_ID", insertable = false, updatable = false)
	private WishOrder WishOrder;

	public WishAssess() {
	}

	public WishAssess(Integer id, Integer wishOrderId, Integer point, String context, Integer pointEE,
			String contextEE) {
		super();
		this.id = id;
		this.wishOrderId = wishOrderId;
		this.point = point;
		this.context = context;
		this.pointEE = pointEE;
		this.contextEE = contextEE;
	}

	@Override
	public String toString() {
		return "WishAssess [id=" + id + ", wishOrderId=" + wishOrderId + ", point=" + point + ", context=" + context
				+ ", pointEE=" + pointEE + ", contextEE=" + contextEE + ", WishOrder=" + WishOrder + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWishOrderId() {
		return wishOrderId;
	}

	public void setWishOrderId(Integer wishOrderId) {
		this.wishOrderId = wishOrderId;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getPointEE() {
		return pointEE;
	}

	public void setPointEE(Integer pointEE) {
		this.pointEE = pointEE;
	}

	public String getContextEE() {
		return contextEE;
	}

	public void setContextEE(String contextEE) {
		this.contextEE = contextEE;
	}

	public WishOrder getWishOrder() {
		return WishOrder;
	}

}
