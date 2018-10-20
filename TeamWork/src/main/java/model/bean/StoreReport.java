package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StoreReport")
public class StoreReport {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sR_ID", columnDefinition = "int")
	Integer id;
	 
	@Column(name = "sR_cont", columnDefinition = "nvarchar(max)")
	String content;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sP_ID", insertable = false, updatable = false)
	Integer storeProductId;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	StoreProduct storeProduct;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sR_state", insertable = false, updatable = false)
	StoreReport storeReport;

	
	
	public StoreReport() {
		super();
	}

	public StoreReport(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	@Override
	public String toString() {
		return "StoreReport [id=" + id + ", content=" + content + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStoreProductId() {
		return storeProductId;
	}

	public void setStoreProductId(Integer storeProductId) {
		this.storeProductId = storeProductId;
	}

	public StoreProduct getStoreProduct() {
		return storeProduct;
	}

	public void setStoreProduct(StoreProduct storeProduct) {
		this.storeProduct = storeProduct;
	}

	public StoreReport getStoreReport() {
		return storeReport;
	}

	public void setStoreReport(StoreReport storeReport) {
		this.storeReport = storeReport;
	}
	
			
}
