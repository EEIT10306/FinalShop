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
	private Integer gA_id;

	@Column(name = "gO_ID", columnDefinition = "int", nullable = false)
	private Integer gO_id;

	@Column(name = "gA_point", columnDefinition = "int")
	private Integer gA_point;

	@Column(name = "gA_cont", columnDefinition = "nvarchar(max)")
	private String gA_context;

	@Column(name = "gA_pointee", columnDefinition = "int")
	private Integer gA_pointAssess;

	@Column(name = "gA_contee", columnDefinition = "nvarchar(max)")
	private String gA_contextAssess;

	@OneToOne
	@JoinColumn(name = "gO_ID", insertable = false, updatable = false)
	private GroupOrder groupOrder;

	public GroupAssess() {
	}

	public GroupAssess(Integer gA_id, Integer gO_id, Integer gA_point, String gA_context, Integer gA_pointAssess,
			String gA_contextAssess) {
		super();
		this.gA_id = gA_id;
		this.gO_id = gO_id;
		this.gA_point = gA_point;
		this.gA_context = gA_context;
		this.gA_pointAssess = gA_pointAssess;
		this.gA_contextAssess = gA_contextAssess;
	}

	@Override
	public String toString() {
		return "GroupAssess [gA_id=" + gA_id + ", gO_id=" + gO_id + ", gA_point=" + gA_point + ", gA_context="
				+ gA_context + ", gA_pointAssess=" + gA_pointAssess + ", gA_contextAssess=" + gA_contextAssess
				+ "]\r\n";
	}

	public Integer getgA_id() {
		return gA_id;
	}

	public void setgA_id(Integer gA_id) {
		this.gA_id = gA_id;
	}

	public Integer getgO_id() {
		return gO_id;
	}

	public void setgO_id(Integer gO_id) {
		this.gO_id = gO_id;
	}

	public Integer getgA_point() {
		return gA_point;
	}

	public void setgA_point(Integer gA_point) {
		this.gA_point = gA_point;
	}

	public String getgA_context() {
		return gA_context;
	}

	public void setgA_context(String gA_context) {
		this.gA_context = gA_context;
	}

	public Integer getgA_pointAssess() {
		return gA_pointAssess;
	}

	public void setgA_pointAssess(Integer gA_pointAssess) {
		this.gA_pointAssess = gA_pointAssess;
	}

	public String getgA_contextAssess() {
		return gA_contextAssess;
	}

	public void setgA_contextAssess(String gA_contextAssess) {
		this.gA_contextAssess = gA_contextAssess;
	}

	public GroupOrder getGroupOrder() {
		return groupOrder;
	}

	public void setGroupOrder(GroupOrder groupOrder) {
		this.groupOrder = groupOrder;
	}

}
