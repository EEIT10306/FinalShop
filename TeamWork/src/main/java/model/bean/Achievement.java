package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Achievement")
public class Achievement {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ach_ID", columnDefinition = "int")
	Integer id;
	@Column(name = "ach_cont", columnDefinition = "nvarchar(MAX)")
	String context;
	@Column(name = "ach_bon", columnDefinition = "int")
	Integer bouns;
	@Column(name = "ach_parID", columnDefinition = "int")
	Integer parentsId;

	@Override
	public String toString() {
		return "AchievementBean [id=" + id + ", context=" + context + ", bouns=" + bouns + ", parentsId=" + parentsId
				+ "]";
	}

	public Achievement() {
	};

	public Achievement(Integer id, String context, Integer bouns, Integer parentsId) {
		this.id = id;
		this.context = context;
		this.bouns = bouns;
		this.parentsId = parentsId;
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

	public Integer getBouns() {
		return bouns;
	}

	public void setBouns(Integer bouns) {
		this.bouns = bouns;
	}

	public Integer getParentsId() {
		return parentsId;
	}

	public void setParentsId(Integer parentsId) {
		this.parentsId = parentsId;
	}
}
