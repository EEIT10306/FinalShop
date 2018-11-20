package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Achievement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ach_ID", columnDefinition = "int", nullable = false)
	private Integer a_id;

	@Column(name = "ach_cont", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String a_context;

	@Column(name = "ach_amt", columnDefinition = "int", nullable = false)
	private Integer a_amount;

	@Column(name = "ach_bon", columnDefinition = "int", nullable = false)
	private Integer a_bonus;

	@Column(name = "ach_parID", columnDefinition = "int")
	private Integer a_parentsId;

	public Achievement() {
	}

	public Achievement(Integer a_id, String a_context, Integer a_amount, Integer a_bonus, Integer a_parentsId) {
		super();
		this.a_id = a_id;
		this.a_context = a_context;
		this.a_amount = a_amount;
		this.a_bonus = a_bonus;
		this.a_parentsId = a_parentsId;
	}

	@Override
	public String toString() {
		return "Achievement [a_id=" + a_id + ", a_context=" + a_context + ", a_amount=" + a_amount + ", a_bonus="
				+ a_bonus + ", a_parentsId=" + a_parentsId + "]\r\n";
	}

	public Integer getA_id() {
		return a_id;
	}

	public void setA_id(Integer a_id) {
		this.a_id = a_id;
	}

	public String getA_context() {
		return a_context;
	}

	public void setA_context(String a_context) {
		this.a_context = a_context;
	}

	public Integer getA_amount() {
		return a_amount;
	}

	public void setA_amount(Integer a_amount) {
		this.a_amount = a_amount;
	}

	public Integer getA_bonus() {
		return a_bonus;
	}

	public void setA_bonus(Integer a_bonus) {
		this.a_bonus = a_bonus;
	}

	public Integer getA_parentsId() {
		return a_parentsId;
	}

	public void setA_parentsId(Integer a_parentsId) {
		this.a_parentsId = a_parentsId;
	}

}
