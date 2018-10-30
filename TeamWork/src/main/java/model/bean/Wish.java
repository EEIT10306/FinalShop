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
public class Wish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "memW_ID", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer productId;

	@Column(name = "wish_title", columnDefinition = "nvarchar(Max)", nullable = false)
	private String title;

	@Column(name = "wish_cont", columnDefinition = "nvarchar(Max)", nullable = false)
	private String context;

	@Column(name = "dist_ID", columnDefinition = "int", nullable = false)
	private Integer districtTypeId;

	@Column(name = "wish_sDate", columnDefinition = "datetime", nullable = false)
	private Date startDate;

	@Column(name = "wish_eDate", columnDefinition = "datetime", nullable = false)
	private Date endDate;

	@Column(name = "wish_sumPriBot", columnDefinition = "int")
	private Integer sumPriceBottom;

	@Column(name = "wish_sumPriTop", columnDefinition = "int")
	private Integer sumPriceTop;

	@Column(name = "wish_chanTime", columnDefinition = "datetime", nullable = false)
	private Date changeTime;

	@Column(name = "wish_hot", columnDefinition = "int", nullable = false)
	private Integer hot;

	@Column(name = "wish_compTime", columnDefinition = "datetime")
	private Date completeTime;

	@Column(name = "wish_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@ManyToOne
	@JoinColumn(name = "memW_ID", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product Product;

	@ManyToOne
	@JoinColumn(name = "dist_ID", insertable = false, updatable = false)
	private DistrictType DistrictType;

	@ManyToOne
	@JoinColumn(name = "wish_state", insertable = false, updatable = false)
	private State State;

	public Wish() {
	}

	public Wish(Integer id, Integer memberId, Integer productId, String title, String context, Integer districtTypeId,
			Date startDate, Date endDate, Integer sumPriceBottom, Integer sumPriceTop, Date changeTime, Integer hot,
			Date completeTime, Integer stateId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.productId = productId;
		this.title = title;
		this.context = context;
		this.districtTypeId = districtTypeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.sumPriceBottom = sumPriceBottom;
		this.sumPriceTop = sumPriceTop;
		this.changeTime = changeTime;
		this.hot = hot;
		this.completeTime = completeTime;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "Wish [id=" + id + ", memberId=" + memberId + ", productId=" + productId + ", title=" + title
				+ ", context=" + context + ", districtTypeId=" + districtTypeId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", sumPriceBottom=" + sumPriceBottom + ", sumPriceTop=" + sumPriceTop
				+ ", changeTime=" + changeTime + ", hot=" + hot + ", completeTime=" + completeTime + ", stateId="
				+ stateId + ", Member=" + Member + ", Product=" + Product + ", DistrictType=" + DistrictType
				+ ", State=" + State + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public Integer getSumPriceBottom() {
		return sumPriceBottom;
	}

	public void setSumPriceBottom(Integer sumPriceBottom) {
		this.sumPriceBottom = sumPriceBottom;
	}

	public Integer getSumPriceTop() {
		return sumPriceTop;
	}

	public void setSumPriceTop(Integer sumPriceTop) {
		this.sumPriceTop = sumPriceTop;
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}

	public Integer getHot() {
		return hot;
	}

	public void setHot(Integer hot) {
		this.hot = hot;
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

	public Member getMember() {
		return Member;
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

	public void setMember(Member member) {
		Member = member;
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
