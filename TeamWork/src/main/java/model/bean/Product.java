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
	private Integer p_id;

	@Column(name = "prod_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String p_name;

	@Column(name = "prod_parID", columnDefinition = "nvarchar(max)")
	private Integer p_parentsId;

	@Column(name = "prod_stage", columnDefinition = "int", nullable = false)
	private Integer p_stage;

	@OneToOne
	@JoinColumn(name = "prod_parID", insertable = false, updatable = false)
	private Product product;

	public Product() {
	}

	public Product(Integer p_id, String p_name, Integer p_parentsId, Integer p_stage) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_parentsId = p_parentsId;
		this.p_stage = p_stage;
	}

	@Override
	public String toString() {
		return "Product [p_id=" + p_id + ", p_name=" + p_name + ", p_parentsId=" + p_parentsId + ", p_stage=" + p_stage
				+ "]\r\n";
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Integer getP_parentsId() {
		return p_parentsId;
	}

	public void setP_parentsId(Integer p_parentsId) {
		this.p_parentsId = p_parentsId;
	}

	public Integer getP_stage() {
		return p_stage;
	}

	public void setP_stage(Integer p_stage) {
		this.p_stage = p_stage;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
