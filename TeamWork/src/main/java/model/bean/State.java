package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sta_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "sta_cont", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String context;

	@Column(name = "sta_class", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String className;

	public State() {
	}

	public State(Integer id, String context, String className) {
		this.id = id;
		this.context = context;
		this.className = className;
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", context=" + context + ", className=" + className + "]\r\n";
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

}
