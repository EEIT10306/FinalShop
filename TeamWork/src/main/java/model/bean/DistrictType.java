package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class DistrictType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dist_ID", columnDefinition = "int", nullable = false)
	private Integer d_id;

	@Column(name = "dist_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String d_name;

	@Column(name = "dist_parID", columnDefinition = "int")
	private Integer d_parentsId;

	@Column(name = "dist_stage", columnDefinition = "int", nullable = false)
	private Integer d_stageId;

	@OneToOne
	@JoinColumn(name = "dist_parID", insertable = false, updatable = false)
	private DistrictType districtType;

	public DistrictType() {
	}

	public DistrictType(Integer d_id, String d_name, Integer d_parentsId, Integer d_stageId) {
		super();
		this.d_id = d_id;
		this.d_name = d_name;
		this.d_parentsId = d_parentsId;
		this.d_stageId = d_stageId;
	}

	@Override
	public String toString() {
		return "DistrictType [d_id=" + d_id + ", d_name=" + d_name + ", d_parentsId=" + d_parentsId + ", d_stageId="
				+ d_stageId + ", districtType=" + districtType + "]\r\n";
	}

	public Integer getD_id() {
		return d_id;
	}

	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}

	public String getD_name() {
		return d_name;
	}

	public void setD_name(String d_name) {
		this.d_name = d_name;
	}

	public Integer getD_parentsId() {
		return d_parentsId;
	}

	public void setD_parentsId(Integer d_parentsId) {
		this.d_parentsId = d_parentsId;
	}

	public Integer getD_stageId() {
		return d_stageId;
	}

	public void setD_stageId(Integer d_stageId) {
		this.d_stageId = d_stageId;
	}

	public DistrictType getDistrictType() {
		return districtType;
	}

	public void setDistrictType(DistrictType districtType) {
		this.districtType = districtType;
	}

}
