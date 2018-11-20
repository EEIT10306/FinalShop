package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "xya_x", "xya_y" }) })
public class XYAnalytics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "xya_ID", columnDefinition = "int", nullable = false)
	private Integer xy_id;

	@Column(name = "xya_date", columnDefinition = "datatime", nullable = false)
	private Date xy_date;

	@Column(name = "xya_x", columnDefinition = "int", nullable = false)
	private Integer xy_x;

	@Column(name = "xya_y", columnDefinition = "int", nullable = false)
	private Integer xy_y;

	@Column(name = "xya_r", columnDefinition = "float", nullable = false)
	private Double xy_r;

	public XYAnalytics() {
	}

	public XYAnalytics(Integer xy_id, Date xy_date, Integer xy_x, Integer xy_y, Double xy_r) {
		super();
		this.xy_id = xy_id;
		this.xy_date = xy_date;
		this.xy_x = xy_x;
		this.xy_y = xy_y;
		this.xy_r = xy_r;
	}

	@Override
	public String toString() {
		return "XYAnalytics [xy_id=" + xy_id + ", xy_date=" + xy_date + ", xy_x=" + xy_x + ", xy_y=" + xy_y + ", xy_r="
				+ xy_r + "]\r\n";
	}

	public Integer getXy_id() {
		return xy_id;
	}

	public void setXy_id(Integer xy_id) {
		this.xy_id = xy_id;
	}

	public Date getXy_date() {
		return xy_date;
	}

	public void setXy_date(Date xy_date) {
		this.xy_date = xy_date;
	}

	public Integer getXy_x() {
		return xy_x;
	}

	public void setXy_x(Integer xy_x) {
		this.xy_x = xy_x;
	}

	public Integer getXy_y() {
		return xy_y;
	}

	public void setXy_y(Integer xy_y) {
		this.xy_y = xy_y;
	}

	public Double getXy_r() {
		return xy_r;
	}

	public void setXy_r(Double xy_r) {
		this.xy_r = xy_r;
	}

}
