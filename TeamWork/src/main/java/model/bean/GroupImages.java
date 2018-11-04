package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GroupImages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gI_ID", columnDefinition = "int", nullable = false)
	private Integer gI_id;

	@Column(name = "gP_ID", columnDefinition = "int", nullable = false)
	private Integer gP_id;

	@Column(name = "gI_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String gI_context;

	@ManyToOne
	@JoinColumn(name = "gP_ID", insertable = false, updatable = false)
	private GroupProduct groupProduct;

	public GroupImages() {
	}

	public GroupImages(Integer gI_id, Integer gP_id, String gI_context) {
		super();
		this.gI_id = gI_id;
		this.gP_id = gP_id;
		this.gI_context = gI_context;
	}

	@Override
	public String toString() {
		return "GroupImages [gI_id=" + gI_id + ", gP_id=" + gP_id + ", gI_context=" + gI_context + ", groupProduct="
				+ groupProduct + "]\r\n";
	}

	public Integer getgI_id() {
		return gI_id;
	}

	public void setgI_id(Integer gI_id) {
		this.gI_id = gI_id;
	}

	public Integer getgP_id() {
		return gP_id;
	}

	public void setgP_id(Integer gP_id) {
		this.gP_id = gP_id;
	}

	public String getgI_context() {
		return gI_context;
	}

	public void setgI_context(String gI_context) {
		this.gI_context = gI_context;
	}

	public GroupProduct getGroupProduct() {
		return groupProduct;
	}

	public void setGroupProduct(GroupProduct groupProduct) {
		this.groupProduct = groupProduct;
	}

}
