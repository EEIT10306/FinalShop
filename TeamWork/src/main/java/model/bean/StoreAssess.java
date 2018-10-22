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
@Table(name = "StoreAssess")
public class StoreAssess {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sA_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "sO_ID", columnDefinition = "int")
	Integer storeOrderId;
	 
	@Column(name = "sA_point", columnDefinition = "int")
	Integer point;
	
	@Column(name = "sA_cont", columnDefinition = "nvarchar(max)")
	String content;
	
	@Column(name = "sA_pointee", columnDefinition = "int")
	Integer pointEE;
	
	@Column(name = "sA_contee", columnDefinition = "nvarchar(max)")
	String contextEE;

	@Column(name = "sA_state", columnDefinition = "int")
	Integer state;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sO_ID", insertable = false, updatable = false)
	StoreOrder storeOrderBean;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sA_state", insertable = false, updatable = false)
	State stateBean;
	
	public StoreAssess() {
	}

	public StoreAssess(Integer id, Integer storeOrderId, Integer point, String content, Integer pointEE,
			String contextEE, Integer state) {
		this.id = id;
		this.storeOrderId = storeOrderId;
		this.point = point;
		this.content = content;
		this.pointEE = pointEE;
		this.contextEE = contextEE;
		this.state = state;
	}

	@Override
	public String toString() {
		return "StoreAssess [id=" + id + ", storeOrderId=" + storeOrderId + ", point=" + point + ", content=" + content
				+ ", pointEE=" + pointEE + ", contextEE=" + contextEE + ", state=" + state + "]\r\n  [storeOrderBean="
				+ storeOrderBean + "]\r\n  [stateBean=" + stateBean + "]\r\n";
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public StoreOrder getStoreOrderBean() {
		return storeOrderBean;
	}

	public void setStoreOrderBean(StoreOrder storeOrderBean) {
		this.storeOrderBean = storeOrderBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}
		
}
