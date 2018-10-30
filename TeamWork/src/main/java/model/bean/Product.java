package model.bean;

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
	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "prod_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String name;

	@Column(name = "prod_parID", columnDefinition = "nvarchar(max)")
	private Integer parentsId;

	@Column(name = "prod_stage", columnDefinition = "int", nullable = false)
	private Integer stage;

	@OneToOne
	@JoinColumn(name = "prod_parID", insertable = false, updatable = false)
	private Product Product;

	public Product() {
	}

	public Product(Integer id, String name, Integer parentsId, Integer stage) {
		super();
		this.id = id;
		this.name = name;
		this.parentsId = parentsId;
		this.stage = stage;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", parentsId=" + parentsId + ", stage=" + stage + ", Product="
				+ Product + "]\r\n";
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
		return Product;
	}

	public void setProduct(Product product) {
		Product = product;
	}

}
