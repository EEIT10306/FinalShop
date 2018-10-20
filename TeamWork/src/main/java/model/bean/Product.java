package model.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_ID", columnDefinition = "int")
	Integer id;
	
	@Column(name = "prod_name", columnDefinition = "nvarchar(max)")
	String name;
	
	@Column(name = "prod_parID", columnDefinition = "nvarchar(max)")
	Integer parentsId;
	
	@Column(name = "prod_stage", columnDefinition = "int")
	Integer stage;	
	
	@OneToOne(cascade = CascadeType.MERGE) 
	@JoinColumn(name = "parID", insertable = false, updatable = false)
	Product product;
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", parentId=" + parentsId + ", stage=" + stage + "]\r\n";
	}

	public Product() {}
	
	public Product(Integer id, String name, Integer parentId, Integer stage) {
		this.id = id;
		this.name = name;
		this.parentsId = parentId;
		this.stage = stage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentsId() {
		return parentsId;
	}

	public void setParentsId(Integer parentsId) {
		this.parentsId = parentsId;
	}

	public Integer getStage() {
		return stage;
	}

	public void setStage(Integer stage) {
		this.stage = stage;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
