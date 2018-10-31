package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sta_ID", columnDefinition = "int", nullable = false)
	private Integer state_id;

	@Column(name = "sta_cont", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String state_context;

	@Column(name = "sta_class", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String state_class;

	public State() {
	}

	public State(Integer state_id, String state_context, String state_class) {
		super();
		this.state_id = state_id;
		this.state_context = state_context;
		this.state_class = state_class;
	}

	@Override
	public String toString() {
		return "State [state_id=" + state_id + ", state_context=" + state_context + ", state_class=" + state_class
				+ "]\r\n";
	}

	public Integer getState_id() {
		return state_id;
	}

	public void setState_id(Integer state_id) {
		this.state_id = state_id;
	}

	public String getState_context() {
		return state_context;
	}

	public void setState_context(String state_context) {
		this.state_context = state_context;
	}

	public String getState_class() {
		return state_class;
	}

	public void setState_class(String state_class) {
		this.state_class = state_class;
	}

}
