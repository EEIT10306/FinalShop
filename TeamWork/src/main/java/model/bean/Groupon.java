package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Groupon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_ID", columnDefinition = "int", nullable = false)
	private Integer g_id;

	@Column(name = "seller_ID", columnDefinition = "int", nullable = false)
	private Integer seller_id;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer p_id;

	@Column(name = "group_title", columnDefinition = "nvarchar(max)", nullable = false)
	private String g_title;

	@Column(name = "group_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String g_context;

	@Column(name = "dist_ID", columnDefinition = "int", nullable = false)
	private Integer d_id;

	@Column(name = "group_sDate", columnDefinition = "datetime", nullable = false)
	private Date g_startDate;

	@Column(name = "group_eDate", columnDefinition = "datetime", nullable = false)
	private Date g_endDate;

	@Column(name = "group_goal", columnDefinition = "nvarchar(max)", nullable = false)
	private String g_goal;

	@Column(name = "group_sumPri", columnDefinition = "int", nullable = false)
	private Integer g_sumPrice;

	@Column(name = "group_hot", columnDefinition = "int", nullable = false)
	private Integer g_hot;

	@Column(name = "group_amtFav", columnDefinition = "int", nullable = false)
	private Integer g_amountFavorite;

	@Column(name = "group_compTime", columnDefinition = "datetime")
	private Date g_completeTime;

	@Column(name = "group_state", columnDefinition = "int", nullable = false)
	private Integer g_stateId;

	@ManyToOne
	@JoinColumn(name = "seller_ID", insertable = false, updatable = false)
	private Seller seller;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "dist_ID", insertable = false, updatable = false)
	private DistrictType districtType;

	@ManyToOne
	@JoinColumn(name = "group_state", insertable = false, updatable = false)
	private State state;

	public Groupon() {
	}

	public Groupon(Integer g_id, Integer seller_id, Integer p_id, String g_title, String g_context, Integer d_id,
			Date g_startDate, Date g_endDate, String g_goal, Integer g_sumPrice, Integer g_hot,
			Integer g_amountFavorite, Date g_completeTime, Integer g_stateId) {
		super();
		this.g_id = g_id;
		this.seller_id = seller_id;
		this.p_id = p_id;
		this.g_title = g_title;
		this.g_context = g_context;
		this.d_id = d_id;
		this.g_startDate = g_startDate;
		this.g_endDate = g_endDate;
		this.g_goal = g_goal;
		this.g_sumPrice = g_sumPrice;
		this.g_hot = g_hot;
		this.g_amountFavorite = g_amountFavorite;
		this.g_completeTime = g_completeTime;
		this.g_stateId = g_stateId;
	}

	@Override
	public String toString() {
		return "Groupon [g_id=" + g_id + ", seller_id=" + seller_id + ", p_id=" + p_id + ", g_title=" + g_title
				+ ", g_context=" + g_context + ", d_id=" + d_id + ", g_startDate=" + g_startDate + ", g_endDate="
				+ g_endDate + ", g_goal=" + g_goal + ", g_sumPrice=" + g_sumPrice + ", g_hot=" + g_hot
				+ ", g_amountFavorite=" + g_amountFavorite + ", g_completeTime=" + g_completeTime + ", g_stateId="
				+ g_stateId + ", seller=" + seller + ", product=" + product + ", districtType=" + districtType
				+ ", state=" + state + "]\r\n";
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getG_title() {
		return g_title;
	}

	public void setG_title(String g_title) {
		this.g_title = g_title;
	}

	public String getG_context() {
		return g_context;
	}

	public void setG_context(String g_context) {
		this.g_context = g_context;
	}

	public Integer getD_id() {
		return d_id;
	}

	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}

	public Date getG_startDate() {
		return g_startDate;
	}

	public void setG_startDate(Date g_startDate) {
		this.g_startDate = g_startDate;
	}

	public Date getG_endDate() {
		return g_endDate;
	}

	public void setG_endDate(Date g_endDate) {
		this.g_endDate = g_endDate;
	}

	public String getG_goal() {
		return g_goal;
	}

	public void setG_goal(String g_goal) {
		this.g_goal = g_goal;
	}

	public Integer getG_sumPrice() {
		return g_sumPrice;
	}

	public void setG_sumPrice(Integer g_sumPrice) {
		this.g_sumPrice = g_sumPrice;
	}

	public Integer getG_hot() {
		return g_hot;
	}

	public void setG_hot(Integer g_hot) {
		this.g_hot = g_hot;
	}

	public Integer getG_amountFavorite() {
		return g_amountFavorite;
	}

	public void setG_amountFavorite(Integer g_amountFavorite) {
		this.g_amountFavorite = g_amountFavorite;
	}

	public Date getG_completeTime() {
		return g_completeTime;
	}

	public void setG_completeTime(Date g_completeTime) {
		this.g_completeTime = g_completeTime;
	}

	public Integer getG_stateId() {
		return g_stateId;
	}

	public void setG_stateId(Integer g_stateId) {
		this.g_stateId = g_stateId;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public DistrictType getDistrictType() {
		return districtType;
	}

	public void setDistrictType(DistrictType districtType) {
		this.districtType = districtType;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
