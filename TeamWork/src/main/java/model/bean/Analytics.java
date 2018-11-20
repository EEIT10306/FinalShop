package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Analytics {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ana_ID", columnDefinition = "int", nullable = false)
	private Integer a_id;

	@Column(name = "ana_date", columnDefinition = "datetime")
	private Date a_date;

	@Column(name = "ana_tap", columnDefinition = "int")
	private Integer a_tap;

	public Analytics() {
	}

	public Analytics(Integer a_id, Date a_date, Integer a_tap) {
		super();
		this.a_id = a_id;
		this.a_date = a_date;
		this.a_tap = a_tap;
	}

	@Override
	public String toString() {
		return "Analytics [a_id=" + a_id + ", a_date=" + a_date + ", a_tap=" + a_tap + "]\r\n";
	}

	public Integer getA_id() {
		return a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	public Date getA_date() {
		return a_date;
	}

	public void setA_date(Date a_date) {
		this.a_date = a_date;
	}

	public Integer getA_tap() {
		return a_tap;
	}

	public void setA_tap(Integer a_tap) {
		this.a_tap = a_tap;
	}

}
