package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class StoreAssess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sA_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "sO_ID", columnDefinition = "int", nullable = false)
	private Integer storeOrderId;

	@Column(name = "sA_point", columnDefinition = "int")
	private Integer point;

	@Column(name = "sA_cont", columnDefinition = "nvarchar(max)")
	private String content;

	@Column(name = "sA_pointee", columnDefinition = "int")
	private Integer pointEE;

	@Column(name = "sA_contee", columnDefinition = "nvarchar(max)")
	private String contextEE;

	@OneToOne
	@JoinColumn(name = "sO_ID", insertable = false, updatable = false)
	private StoreOrder StoreOrder;

	public StoreAssess() {
	}

	public StoreAssess(Integer id, Integer storeOrderId, Integer point, String content, Integer pointEE,
			String contextEE) {
		super();
		this.id = id;
		this.storeOrderId = storeOrderId;
		this.point = point;
		this.content = content;
		this.pointEE = pointEE;
		this.contextEE = contextEE;
	}

	@Override
	public String toString() {
		return "StoreAssess [id=" + id + ", storeOrderId=" + storeOrderId + ", point=" + point + ", content=" + content
				+ ", pointEE=" + pointEE + ", contextEE=" + contextEE + ", StoreOrder=" + StoreOrder + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreOrderId() {
		return storeOrderId;
	}

	public void setStoreOrderId(Integer storeOrderId) {
		this.storeOrderId = storeOrderId;
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

	public StoreOrder getStoreOrder() {
		return StoreOrder;
	}

	public void setStoreOrder(StoreOrder storeOrder) {
		StoreOrder = storeOrder;
	}

}
