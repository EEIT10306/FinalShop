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
@Table(name="GroupProduct")
public class GroupProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gP_ID", columnDefinition = "int")
	Integer id;
	
	@Column(name="group_ID" , columnDefinition="int")
	Integer groupID;
	
	@Column(name="gP_name" , columnDefinition="nvarchar(max)")
	String name;
	
	@Column(name="prod_ID" , columnDefinition="int")
	Integer prodID;
	
	@Column(name="gP_amt" , columnDefinition="int")
	Integer amt;
	
	@Column(name="gP_price" , columnDefinition="int")
	Integer price;
	
	@Column(name="gP_cont" ,columnDefinition="nvarchar(max)")
	String cont;
	
	@Column(name="gP_var", columnDefinition="int")
	Integer ver;
	
	@Column(name="gP_compTime", columnDefinition="datetime")
	Date compTime;
	
	@Column(name="gP_state", columnDefinition="int")
	Integer gpState;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "group_ID", insertable = false, updatable = false)
	Group group;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	Product product;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sta_ID", insertable = false, updatable = false)
	State state;

	public GroupProduct() {
		
	}

	public GroupProduct(Integer id, Integer groupID, String name, Integer prodID, Integer amt, Integer price,
			String cont, Integer ver, Date compTime, Integer gpState) {
		this.id = id;
		this.groupID = groupID;
		this.name = name;
		this.prodID = prodID;
		this.amt = amt;
		this.price = price;
		this.cont = cont;
		this.ver = ver;
		this.compTime = compTime;
		this.gpState = gpState;
	}

	@Override
	public String toString() {
		return "GroupProduct [id=" + id + ", groupID=" + groupID + ", name=" + name + ", prodID=" + prodID + ", amt="
				+ amt + ", price=" + price + ", cont=" + cont + ", ver=" + ver + ", compTime=" + compTime + ", gpState="
				+ gpState + "]";
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

	public Integer getProdID() {
		return prodID;
	}

	public void setProdID(Integer prodID) {
		this.prodID = prodID;
	}

	public Integer getAmt() {
		return amt;
	}

	public void setAmt(Integer amt) {
		this.amt = amt;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public Integer getVer() {
		return ver;
	}

	public void setVer(Integer ver) {
		this.ver = ver;
	}

	public Date getCompTime() {
		return compTime;
	}

	public void setCompTime(Date compTime) {
		this.compTime = compTime;
	}

	public Integer getGpState() {
		return gpState;
	}

	public void setGpState(Integer gpState) {
		this.gpState = gpState;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	
}
