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
@Table(name = "WishProduct")
public class WishProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wP_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "wish_ID", columnDefinition = "int")
	Integer wishID;

	@Column(name = "wP_name", columnDefinition = "nvarchar(max)")
	String name;

	@Column(name = "prod_ID", columnDefinition = "int")
	Integer productID;

	@Column(name = "wP_amt", columnDefinition = "int")
	Integer amount;

	@Column(name = "wP_pBot", columnDefinition = "int")
	Integer priceBottom;

	@Column(name = "wP_pTop", columnDefinition = "int")
	Integer priceTop;

	@Column(name = "wP_compTime", columnDefinition = "datetime")
	Date completeTime;

	@Column(name = "wP_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	Wish wishBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	Product productBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wP_state", insertable = false, updatable = false)
	State stateBean;

	public WishProduct() {
	}

	public WishProduct(Integer id, Integer wishID, String name, Integer productID, Integer amount, Integer priceBottom,
			Integer priceTop, Date completeTime, Integer state) {
		this.id = id;
		this.wishID = wishID;
		this.name = name;
		this.productID = productID;
		this.amount = amount;
		this.priceBottom = priceBottom;
		this.priceTop = priceTop;
		this.completeTime = completeTime;
		this.state = state;
	}

	@Override
	public String toString() {
		return "WishProduct [id=" + id + ", wishID=" + wishID + ", name=" + name + ", productID=" + productID
				+ ", amount=" + amount + ", priceBottom=" + priceBottom + ", priceTop=" + priceTop + ", completeTime="
				+ completeTime + ", state=" + state + "]\r\n  [wishBean=" + wishBean + "]\r\n [productBean=" + productBean
				+ "]\r\n  [stateBean=" + stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWishID() {
		return wishID;
	}

	public void setWishID(Integer wishID) {
		this.wishID = wishID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPriceBottom() {
		return priceBottom;
	}

	public void setPriceBottom(Integer priceBottom) {
		this.priceBottom = priceBottom;
	}

	public Integer getPriceTop() {
		return priceTop;
	}

	public void setPriceTop(Integer priceTop) {
		this.priceTop = priceTop;
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

	public Wish getWishBean() {
		return wishBean;
	}

	public void setWishBean(Wish wishBean) {
		this.wishBean = wishBean;
	}

	public Product getProductBean() {
		return productBean;
	}

	public void setProductBean(Product productBean) {
		this.productBean = productBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
