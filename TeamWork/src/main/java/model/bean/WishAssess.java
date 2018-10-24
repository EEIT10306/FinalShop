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

	@Column(name = "wM_ID", columnDefinition = "int")
	Integer wishMessageId;
	 
	@Column(name = "wA_point", columnDefinition = "int")
	Integer point;
	
	@Column(name = "wA_cont", columnDefinition = "nvarchar(max)")
	String context;
	
	@Column(name = "wA_pointee", columnDefinition = "int")
	Integer pointEE;
	
	@Column(name = "wA_contee", columnDefinition = "nvarchar(max)")
	String contextEE;
	
	@Column(name = "wA_state", columnDefinition = "int")
	Integer state;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wM_ID", insertable = false, updatable = false)
	WishMessage wishMessageBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wA_state", insertable = false, updatable = false)
	State stateBean;

	public WishAssess() {
	}

	public WishAssess(Integer id, Integer wishMessageId, Integer point, String context, Integer pointEE,
			String contextEE, Integer state) {
		this.id = id;
		this.wishMessageId = wishMessageId;
		this.point = point;
		this.context = context;
		this.pointEE = pointEE;
		this.contextEE = contextEE;
		this.state = state;
	}

	@Override
	public String toString() {
		return "WishAssess [id=" + id + ", wishMessageId=" + wishMessageId + ", point=" + point + ", context=" + context
				+ ", pointEE=" + pointEE + ", contextEE=" + contextEE + ", state=" + state + "]\r\n  [wishMessageBean="
				+ wishMessageBean + "]\r\n  [stateBean=" + stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWishMessageId() {
		return wishMessageId;
	}

	public void setWishMessageId(Integer wishMessageId) {
		this.wishMessageId = wishMessageId;
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public WishMessage getWishMessageBean() {
		return wishMessageBean;
	}

	public void setWishMessageBean(WishMessage wishMessageBean) {
		this.wishMessageBean = wishMessageBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}
			
}
