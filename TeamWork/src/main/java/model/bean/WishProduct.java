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

@Entity
public class WishProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wP_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer wishId;

	@Column(name = "wP_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String name;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer productId;

	@Column(name = "wP_amt", columnDefinition = "int", nullable = false)
	private Integer amount;

	@Column(name = "wP_pBot", columnDefinition = "int")
	private Integer priceBottom;

	@Column(name = "wP_pTop", columnDefinition = "int")
	private Integer priceTop;

	@Column(name = "wP_compTime", columnDefinition = "datetime")
	private Date completeTime;

	@Column(name = "wP_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	private Wish Wish;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product Product;

	@ManyToOne
	@JoinColumn(name = "wP_state", insertable = false, updatable = false)
	private State State;

	@OneToMany(mappedBy = "WishProduct")
	private Set<Images> Images;

	public WishProduct() {
	}

	public WishProduct(Integer id, Integer wishId, String name, Integer productId, Integer amount, Integer priceBottom,
			Integer priceTop, Date completeTime, Integer stateId) {
		super();
		this.id = id;
		this.wishId = wishId;
		this.name = name;
		this.productId = productId;
		this.amount = amount;
		this.priceBottom = priceBottom;
		this.priceTop = priceTop;
		this.completeTime = completeTime;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "WishProduct [id=" + id + ", wishId=" + wishId + ", name=" + name + ", productId=" + productId
				+ ", amount=" + amount + ", priceBottom=" + priceBottom + ", priceTop=" + priceTop + ", completeTime="
				+ completeTime + ", stateId=" + stateId + ", Wish=" + Wish + ", Product=" + Product + ", State=" + State
				+ ", Images=" + Images + "]\r\n";
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

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Wish getWish() {
		return Wish;
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
