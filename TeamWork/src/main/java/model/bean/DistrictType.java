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
@Table(name = "DistrictType")
public class DistrictType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dist_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "dist_name", columnDefinition = "nvarchar(max)")
	String name;

	@Column(name = "dist_parID", columnDefinition = "int")
	Integer parentID;

	@Column(name = "dist_stage", columnDefinition = "int")
	Integer stage;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "dist_parID", insertable = false, updatable = false)
	DistrictType parentsDistrictTypeBean;

	public DistrictType() {
	}

	public DistrictType(Integer id, String name, Integer parentID, Integer stage) {
		this.id = id;
		this.name = name;
		this.parentID = parentID;
		this.stage = stage;
	}

	@Override
	public String toString() {
		return "DistrictType [id=" + id + ", name=" + name + ", parentID=" + parentID + ", stage=" + stage
				+ "]\r\n  [parentsDistrictTypeBean=" + parentsDistrictTypeBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}

	

}
