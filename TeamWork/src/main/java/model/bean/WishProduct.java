package model.bean;

import java.util.Date;
import java.util.LinkedHashSet;
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
	private Integer wP_id;

	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer w_id;

	@Column(name = "wP_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String wP_name;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer p_id;

	@Column(name = "wP_amt", columnDefinition = "int", nullable = false)
	private Integer wP_amount;

	@Column(name = "wP_pBot", columnDefinition = "int")
	private Integer wP_priceBottom;

	@Column(name = "wP_pTop", columnDefinition = "int")
	private Integer wP_priceTop;

	@Column(name = "wP_compTime", columnDefinition = "datetime")
	private Date wP_completeTime;

	@Column(name = "wP_state", columnDefinition = "int", nullable = false)
	private Integer wP_stateId;

	@ManyToOne
	@JoinColumn(name = "wish_ID", insertable = false, updatable = false)
	private Wish wish;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "wP_state", insertable = false, updatable = false)
	private State state;

	@OneToMany(mappedBy = "wP_id")
	private Set<WishImages> wishImages = new LinkedHashSet<>();

	public WishProduct() {
	}

	public WishProduct(Integer wP_id, Integer w_id, String wP_name, Integer p_id, Integer wP_amount,
			Integer wP_priceBottom, Integer wP_priceTop, Date wP_completeTime, Integer wP_stateId) {
		super();
		this.wP_id = wP_id;
		this.w_id = w_id;
		this.wP_name = wP_name;
		this.p_id = p_id;
		this.wP_amount = wP_amount;
		this.wP_priceBottom = wP_priceBottom;
		this.wP_priceTop = wP_priceTop;
		this.wP_completeTime = wP_completeTime;
		this.wP_stateId = wP_stateId;
	}

	@Override
	public String toString() {
		return "WishProduct [wP_id=" + wP_id + ", w_id=" + w_id + ", wP_name=" + wP_name + ", p_id=" + p_id
				+ ", wP_amount=" + wP_amount + ", wP_priceBottom=" + wP_priceBottom + ", wP_priceTop=" + wP_priceTop
				+ ", wP_completeTime=" + wP_completeTime + ", wP_stateId=" + wP_stateId + ", wishImages=" + wishImages
				+ "]\r\n";
	}

	public Integer getwP_id() {
		return wP_id;
	}

	public void setwP_id(Integer wP_id) {
		this.wP_id = wP_id;
	}

	public Integer getW_id() {
		return w_id;
	}

	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}

	public String getwP_name() {
		return wP_name;
	}

	public void setwP_name(String wP_name) {
		this.wP_name = wP_name;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public Integer getwP_amount() {
		return wP_amount;
	}

	public void setwP_amount(Integer wP_amount) {
		this.wP_amount = wP_amount;
	}

	public Integer getwP_priceBottom() {
		return wP_priceBottom;
	}

	public void setwP_priceBottom(Integer wP_priceBottom) {
		this.wP_priceBottom = wP_priceBottom;
	}

	public Integer getwP_priceTop() {
		return wP_priceTop;
	}

	public void setwP_priceTop(Integer wP_priceTop) {
		this.wP_priceTop = wP_priceTop;
	}

	public Date getwP_completeTime() {
		return wP_completeTime;
	}

	public void setwP_completeTime(Date wP_completeTime) {
		this.wP_completeTime = wP_completeTime;
	}

	public Integer getwP_stateId() {
		return wP_stateId;
	}

	public void setwP_stateId(Integer wP_stateId) {
		this.wP_stateId = wP_stateId;
	}

	public Wish getWish() {
		return wish;
	}

	public void setWish(Wish wish) {
		this.wish = wish;
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

	public Set<WishImages> getWishImages() {
		return wishImages;
	}

	public void setWishImages(Set<WishImages> wishImages) {
		this.wishImages = wishImages;
	}

}
