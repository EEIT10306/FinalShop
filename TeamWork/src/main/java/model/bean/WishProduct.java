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
	Integer wishId;
	@Column(name = "wP_name", columnDefinition = "nvarchar(max)")
	String name;
	@Column(name = "prod_ID", columnDefinition = "int")
	Integer productId;
	@Column(name = "wP_amt", columnDefinition = "int")
	Integer amount;
	@Column(name = "wP_pBot", columnDefinition = "int")
	Integer priceBot;
	@Column(name = "wP_pTop", columnDefinition = "int")
	Integer priceTop;
	@Column(name = "wP_compTime", columnDefinition = "datetime")
	Date compTime;
	@Column(name = "wP_state", columnDefinition = "int")
	Integer state;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	Wish mem;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	Product prd;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wP_state", insertable = false, updatable = false)
	DistrictType dis;

	public WishProduct() {}

	public WishProduct(Integer id, Integer wishId, String name, Integer productId, Integer amount, Integer priceBot,
			Integer priceTop, Date compTime, Integer state) {
		this.id = id;
		this.wishId = wishId;
		this.name = name;
		this.productId = productId;
		this.amount = amount;
		this.priceBot = priceBot;
		this.priceTop = priceTop;
		this.compTime = compTime;
		this.state = state;
	}

	@Override
	public String toString() {
		return "WishProduct [id=" + id + ", wishId=" + wishId + ", name=" + name + ", productId=" + productId
				+ ", amount=" + amount + ", priceBot=" + priceBot + ", priceTop=" + priceTop + ", compTime=" + compTime
				+ ", state=" + state + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWishId() {
		return wishId;
	}

	public void setWishId(Integer wishId) {
		this.wishId = wishId;
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

	public Integer getPriceBot() {
		return priceBot;
	}

	public void setPriceBot(Integer priceBot) {
		this.priceBot = priceBot;
	}

	public Integer getPriceTop() {
		return priceTop;
	}

	public void setPriceTop(Integer priceTop) {
		this.priceTop = priceTop;
	}

	public Date getCompTime() {
		return compTime;
	}

	public void setCompTime(Date compTime) {
		this.compTime = compTime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Wish getMem() {
		return mem;
	}

	public void setMem(Wish mem) {
		this.mem = mem;
	}

	public Product getPrd() {
		return prd;
	}

	public void setPrd(Product prd) {
		this.prd = prd;
	}

	public DistrictType getDis() {
		return dis;
	}

	public void setDis(DistrictType dis) {
		this.dis = dis;
	}
	
	
	
}
