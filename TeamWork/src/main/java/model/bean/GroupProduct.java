package model.bean;

import java.util.Date;

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
@Table(name = "GroupProduct")
public class GroupProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gP_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "group_ID", columnDefinition = "int")
	Integer groupID;

	@Column(name = "gP_name", columnDefinition = "nvarchar(max)")
	String name;

	@Column(name = "prod_ID", columnDefinition = "int")
	Integer productId;

	@Column(name = "gP_amt", columnDefinition = "int")
	Integer amount;

	@Column(name = "gP_price", columnDefinition = "int")
	Integer price;

	@Column(name = "gP_cont", columnDefinition = "nvarchar(max)")
	String context;

	@Column(name = "gP_var", columnDefinition = "int")
	Integer version;

	@Column(name = "gP_compTime", columnDefinition = "datetime")
	Date completeTime;

	@Column(name = "gP_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "group_ID", insertable = false, updatable = false)
	Groupon groupBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	Product productBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sta_ID", insertable = false, updatable = false)
	State stateBean;

	public GroupProduct() {
	}

	public GroupProduct(Integer id, Integer groupID, String name, Integer productId, Integer amount, Integer price,
			String context, Integer version, Date completeTime, Integer state) {
		this.id = id;
		this.groupID = groupID;
		this.name = name;
		this.productId = productId;
		this.amount = amount;
		this.price = price;
		this.context = context;
		this.version = version;
		this.completeTime = completeTime;
		this.state = state;
	}

	@Override
	public String toString() {
		return "GroupProduct [id=" + id + ", groupID=" + groupID + ", name=" + name + ", productId=" + productId
				+ ", amount=" + amount + ", price=" + price + ", context=" + context + ", version=" + version
				+ ", completeTime=" + completeTime + ", state=" + state + "]\r\n  [groupBean=" + groupBean
				+ "]\r\n  [productBean=" + productBean + "]\r\n  [stateBean=" + stateBean + "]\r\n";
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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Groupon getGroupBean() {
		return groupBean;
	}

	public Product getProductBean() {
		return productBean;
	}

	public State getStateBean() {
		return stateBean;
	}
}
