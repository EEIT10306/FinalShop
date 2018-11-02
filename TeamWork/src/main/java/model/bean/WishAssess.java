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
	private Integer wA_id;

	@Column(name = "wO_ID", columnDefinition = "int", nullable = false)
	private Integer wO_id;

	@Column(name = "wA_point", columnDefinition = "int")
	private Integer wA_point;

	@Column(name = "wA_cont", columnDefinition = "nvarchar(max)")
	private String wA_context;

	@Column(name = "wA_pointee", columnDefinition = "int")
	private Integer wA_pointAssess;

	@Column(name = "wA_contee", columnDefinition = "nvarchar(max)")
	private String wA_contextAssess;

	@OneToOne
	@JoinColumn(name = "wO_ID", insertable = false, updatable = false)
	private WishOrder wishOrder;

	public WishAssess() {
	}

	public WishAssess(Integer wA_id, Integer wO_id, Integer wA_point, String wA_context, Integer wA_pointAssess,
			String wA_contextAssess) {
		super();
		this.wA_id = wA_id;
		this.wO_id = wO_id;
		this.wA_point = wA_point;
		this.wA_context = wA_context;
		this.wA_pointAssess = wA_pointAssess;
		this.wA_contextAssess = wA_contextAssess;
	}

	@Override
	public String toString() {
		return "WishAssess [wA_id=" + wA_id + ", wO_id=" + wO_id + ", wA_point=" + wA_point + ", wA_context="
				+ wA_context + ", wA_pointAssess=" + wA_pointAssess + ", wA_contextAssess=" + wA_contextAssess
				+ ", wishOrder=" + wishOrder + "]\r\n";
	}

	public Integer getwA_id() {
		return wA_id;
	}

	public void setwA_id(Integer wA_id) {
		this.wA_id = wA_id;
	}

	public Integer getwO_id() {
		return wO_id;
	}

	public void setwO_id(Integer wO_id) {
		this.wO_id = wO_id;
	}

	public Integer getwA_point() {
		return wA_point;
	}

	public void setwA_point(Integer wA_point) {
		this.wA_point = wA_point;
	}

	public String getwA_context() {
		return wA_context;
	}

	public void setwA_context(String wA_context) {
		this.wA_context = wA_context;
	}

	public Integer getwA_pointAssess() {
		return wA_pointAssess;
	}

	public void setwA_pointAssess(Integer wA_pointAssess) {
		this.wA_pointAssess = wA_pointAssess;
	}

	public String getwA_contextAssess() {
		return wA_contextAssess;
	}

	public void setwA_contextAssess(String wA_contextAssess) {
		this.wA_contextAssess = wA_contextAssess;
	}

	public WishOrder getWishOrder() {
		return wishOrder;
	}

	public void setWishOrder(WishOrder wishOrder) {
		this.wishOrder = wishOrder;
	}

}
