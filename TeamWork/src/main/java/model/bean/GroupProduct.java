package model.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class GroupProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gP_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "group_ID", columnDefinition = "int", nullable = false)
	private Integer groupID;

	@Column(name = "gP_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String name;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer productId;

	@Column(name = "gP_amt", columnDefinition = "int", nullable = false)
	private Integer amount;

	@Column(name = "gP_price", columnDefinition = "int", nullable = false)
	private Integer price;

	@Column(name = "gP_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String context;

	@Column(name = "gP_var", columnDefinition = "int", nullable = false)
	private Integer version;

	@Column(name = "gP_compTime", columnDefinition = "datetime")
	private Date completeTime;

	@Column(name = "gP_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "group_ID", insertable = false, updatable = false)
	private Groupon Groupon;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product Product;

	@ManyToOne
	@JoinColumn(name = "gP_state", insertable = false, updatable = false)
	private State State;

	@OneToMany(mappedBy = "wgs_ID")
	private Set<Images> Images;

	public GroupProduct() {
	}

	public GroupProduct(Integer id, Integer groupID, String name, Integer productId, Integer amount, Integer price,
			String context, Integer version, Date completeTime, Integer stateId) {
		super();
		this.id = id;
		this.groupID = groupID;
		this.name = name;
		this.productId = productId;
		this.amount = amount;
		this.price = price;
		this.context = context;
		this.version = version;
		this.completeTime = completeTime;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "GroupProduct [id=" + id + ", groupID=" + groupID + ", name=" + name + ", productId=" + productId
				+ ", amount=" + amount + ", price=" + price + ", context=" + context + ", version=" + version
				+ ", completeTime=" + completeTime + ", stateId=" + stateId + ", Groupon=" + Groupon + ", Product="
				+ Product + ", State=" + State + ", Images=" + Images + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGroupID() {
		return groupID;
	}

	public void setGroupID(Integer groupID) {
		this.groupID = groupID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Date getCompleteTime() {
		return completeTime;
	}

	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Groupon getGroupon() {
		return Groupon;
	}

	public Product getProduct() {
		return Product;
	}

	public State getState() {
		return State;
	}

	public Set<Images> getImages() {
		return Images;
	}

}
