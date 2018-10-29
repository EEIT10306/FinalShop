package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Achievement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ach_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "ach_cont", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String context;

	@Column(name = "ach_bon", columnDefinition = "int", nullable = false)
	private Integer bonus;

	@Column(name = "ach_parID", columnDefinition = "int")
	private Integer parentsId;

	public Achievement() {
	}

	public Achievement(Integer id, String context, Integer bonus, Integer parentsId) {
		this.id = id;
		this.context = context;
		this.bonus = bonus;
		this.parentsId = parentsId;
	}

	@Override
	public String toString() {
		return "Achievement [id=" + id + ", context=" + context + ", bonus=" + bonus + ", parentsId=" + parentsId + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getBonus() {
		return bonus;
	}

	public void setBonus(Integer bonus) {
		this.bonus = bonus;
	}

	public Integer getParentsId() {
		return parentsId;
	}

	public void setParentsId(Integer parentsId) {
		this.parentsId = parentsId;
	}

}
