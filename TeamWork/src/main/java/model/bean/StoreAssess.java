package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StoreAssess")
public class StoreAssess {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sA_ID", columnDefinition = "int")
	Integer id;
	 
	@Column(name = "sA_point", columnDefinition = "int")
	Integer storeassessPoint;
	
	@Column(name = "sA_cont", columnDefinition = "nvarchar(max)")
	String storeassessContent;
	
	@Column(name = "sA_pointee", columnDefinition = "int")
	Integer storeassessPointee;
	
	@Column(name = "sA_contee", columnDefinition = "nvarchar(max)")
	String storeassessContee;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sO_ID", insertable = false, updatable = false)
	StoreOrder storeOrder;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sA_state", insertable = false, updatable = false)
	StoreAssess storeAssess;

	
	
	public StoreAssess() {
		super();
	}

	public StoreAssess(Integer id, Integer storeassessPoint, String storeassessContent, Integer storeassessPointee,
			String storeassessContee) {
		super();
		this.id = id;
		this.storeassessPoint = storeassessPoint;
		this.storeassessContent = storeassessContent;
		this.storeassessPointee = storeassessPointee;
		this.storeassessContee = storeassessContee;
	}

	@Override
	public String toString() {
		return "StoreAssess [id=" + id + ", storeassessPoint=" + storeassessPoint + ", storeassessContent="
				+ storeassessContent + ", storeassessPointee=" + storeassessPointee + ", storeassessContee="
				+ storeassessContee + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreassessPoint() {
		return storeassessPoint;
	}

	public void setStoreassessPoint(Integer storeassessPoint) {
		this.storeassessPoint = storeassessPoint;
	}

	public String getStoreassessContent() {
		return storeassessContent;
	}

	public void setStoreassessContent(String storeassessContent) {
		this.storeassessContent = storeassessContent;
	}

	public Integer getStoreassessPointee() {
		return storeassessPointee;
	}

	public void setStoreassessPointee(Integer storeassessPointee) {
		this.storeassessPointee = storeassessPointee;
	}

	public String getStoreassessContee() {
		return storeassessContee;
	}

	public void setStoreassessContee(String storeassessContee) {
		this.storeassessContee = storeassessContee;
	}
	
	
		
}
