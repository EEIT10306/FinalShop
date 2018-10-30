package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class GroupAssess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gA_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "gO_ID", columnDefinition = "int", nullable = false)
	private Integer groupOrderId;

	@Column(name = "gA_point", columnDefinition = "int")
	private Integer point;

	@Column(name = "gA_cont", columnDefinition = "nvarchar(max)")
	private String context;

	@Column(name = "gA_pointee", columnDefinition = "int")
	private Integer pointEE;

	@Column(name = "gA_contee", columnDefinition = "nvarchar(max)")
	private String contextEE;

	@OneToOne
	@JoinColumn(name = "gO_ID", insertable = false, updatable = false)
	private GroupOrder GroupOrder;

	public GroupAssess() {
	}

	public GroupAssess(Integer id, Integer groupOrderId, Integer point, String context, Integer pointEE,
			String contextEE) {
		super();
		this.id = id;
		this.groupOrderId = groupOrderId;
		this.point = point;
		this.context = context;
		this.pointEE = pointEE;
		this.contextEE = contextEE;
	}

	@Override
	public String toString() {
		return "GroupAssess [id=" + id + ", groupOrderId=" + groupOrderId + ", point=" + point + ", context=" + context
				+ ", pointEE=" + pointEE + ", contextEE=" + contextEE + ", GroupOrder=" + GroupOrder + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupOrderId() {
		return groupOrderId;
	}

	public void setGroupOrderId(Integer groupOrderId) {
		this.groupOrderId = groupOrderId;
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

	public GroupOrder getGroupOrder() {
		return GroupOrder;
	}

	public void setGroupOrder(GroupOrder groupOrder) {
		GroupOrder = groupOrder;
	}

}
