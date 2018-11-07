package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StoreImages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sI_ID", columnDefinition = "int", nullable = false)
	private Integer sI_id;

	@Column(name = "sP_ID", columnDefinition = "int", nullable = false)
	private Integer sP_id;

	@Column(name = "sI_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String sI_context;

	public StoreImages() {
	}

	public StoreImages(Integer sI_id, Integer sP_id, String sI_context) {
		super();
		this.sI_id = sI_id;
		this.sP_id = sP_id;
		this.sI_context = sI_context;
	}

	@Override
	public String toString() {
		return "StoreImages [sI_id=" + sI_id + ", sP_id=" + sP_id + ", sI_context=" + sI_context + "]\r\n";
	}

	public Integer getsI_id() {
		return sI_id;
	}

	public void setsI_id(Integer sI_id) {
		this.sI_id = sI_id;
	}

	public Integer getsP_id() {
		return sP_id;
	}

	public void setsP_id(Integer sP_id) {
		this.sP_id = sP_id;
	}

	public String getsI_context() {
		return sI_context;
	}

	public void setsI_context(String sI_context) {
		this.sI_context = sI_context;
	}

}
