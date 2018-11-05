package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class StoreAssess {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sA_ID", columnDefinition = "int", nullable = false)
	private Integer sA_id;

	@Column(name = "sO_ID", columnDefinition = "int", nullable = false)
	private Integer sO_id;

	@Column(name = "sA_point", columnDefinition = "int")
	private Integer sA_point;

	@Column(name = "sA_cont", columnDefinition = "nvarchar(max)")
	private String sA_content;

	@Column(name = "sA_pointee", columnDefinition = "int")
	private Integer sA_pointAssess;

	@Column(name = "sA_contee", columnDefinition = "nvarchar(max)")
	private String sA_contextAssess;

	@OneToOne
	@JoinColumn(name = "sO_ID", insertable = false, updatable = false)
	private StoreOrder storeOrder;

	public StoreAssess() {
	}

	public StoreAssess(Integer sA_id, Integer sO_id, Integer sA_point, String sA_content, Integer sA_pointAssess,
			String sA_contextAssess) {
		super();
		this.sA_id = sA_id;
		this.sO_id = sO_id;
		this.sA_point = sA_point;
		this.sA_content = sA_content;
		this.sA_pointAssess = sA_pointAssess;
		this.sA_contextAssess = sA_contextAssess;
	}

	@Override
	public String toString() {
		return "StoreAssess [sA_id=" + sA_id + ", sO_id=" + sO_id + ", sA_point=" + sA_point + ", sA_content="
				+ sA_content + ", sA_pointAssess=" + sA_pointAssess + ", sA_contextAssess=" + sA_contextAssess
				+ "]\r\n";
	}

	public Integer getsA_id() {
		return sA_id;
	}

	public void setsA_id(Integer sA_id) {
		this.sA_id = sA_id;
	}

	public Integer getsO_id() {
		return sO_id;
	}

	public void setsO_id(Integer sO_id) {
		this.sO_id = sO_id;
	}

	public Integer getsA_point() {
		return sA_point;
	}

	public void setsA_point(Integer sA_point) {
		this.sA_point = sA_point;
	}

	public String getsA_content() {
		return sA_content;
	}

	public void setsA_content(String sA_content) {
		this.sA_content = sA_content;
	}

	public Integer getsA_pointAssess() {
		return sA_pointAssess;
	}

	public void setsA_pointAssess(Integer sA_pointAssess) {
		this.sA_pointAssess = sA_pointAssess;
	}

	public String getsA_contextAssess() {
		return sA_contextAssess;
	}

	public void setsA_contextAssess(String sA_contextAssess) {
		this.sA_contextAssess = sA_contextAssess;
	}

	public StoreOrder getStoreOrder() {
		return storeOrder;
	}

	public void setStoreOrder(StoreOrder storeOrder) {
		this.storeOrder = storeOrder;
	}

}
