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
	private Integer id;

	@Column(name = "seller_ID", columnDefinition = "int", nullable = false)
	private Integer sellerId;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer productId;

	@Column(name = "group_title", columnDefinition = "nvarchar(max)", nullable = false)
	private String title;

	@Column(name = "group_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String context;

	@Column(name = "dist_ID", columnDefinition = "int", nullable = false)
	private Integer districtTypeId;

	@Column(name = "group_sDate", columnDefinition = "datetime", nullable = false)
	private Date startDate;

	@Column(name = "group_eDate", columnDefinition = "datetime", nullable = false)
	private Date endDate;

	@Column(name = "group_goal", columnDefinition = "nvarchar(max)")
	private String goal;

	@Column(name = "group_compTime", columnDefinition = "datetime")
	private Date completeTime;

	@Column(name = "group_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "seller_ID", insertable = false, updatable = false)
	private Seller Seller;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product Product;

	@ManyToOne
	@JoinColumn(name = "dist_ID", insertable = false, updatable = false)
	private DistrictType DistrictType;

	@ManyToOne
	@JoinColumn(name = "group_state", insertable = false, updatable = false)
	private State State;

	public Groupon() {
	}

	public Groupon(Integer id, Integer sellerId, Integer productId, String title, String context,
			Integer districtTypeId, Date startDate, Date endDate, String goal, Date completeTime, Integer stateId) {
		super();
		this.id = id;
		this.sellerId = sellerId;
		this.productId = productId;
		this.title = title;
		this.context = context;
		this.districtTypeId = districtTypeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goal = goal;
		this.completeTime = completeTime;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "Groupon [id=" + id + ", sellerId=" + sellerId + ", productId=" + productId + ", title=" + title
				+ ", context=" + context + ", districtTypeId=" + districtTypeId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", goal=" + goal + ", completeTime=" + completeTime + ", stateId=" + stateId
				+ ", Seller=" + Seller + ", Product=" + Product + ", DistrictType=" + DistrictType + ", State=" + State
				+ "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Integer getDistrictTypeId() {
		return districtTypeId;
	}

	public void setDistrictTypeId(Integer districtTypeId) {
		this.districtTypeId = districtTypeId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
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

	public Seller getSeller() {
		return Seller;
	}

	public Product getProduct() {
		return Product;
	}

	public DistrictType getDistrictType() {
		return DistrictType;
	}

	public State getState() {
		return State;
	}

	public void setSeller(Seller seller) {
		Seller = seller;
	}

	public void setProduct(Product product) {
		Product = product;
	}

	public void setDistrictType(DistrictType districtType) {
		DistrictType = districtType;
	}

	public void setState(State state) {
		State = state;
	}

}
