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
@Table(name = "Wish")
public class Wish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wish_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "memW_ID", columnDefinition = "int")
	Integer memberId;

	@Column(name = "prod_ID", columnDefinition = "int")
	Integer productId;

	@Column(name = "wish_title", columnDefinition = "nvarchar(Max)")
	String title;

	@Column(name = "wish_cont", columnDefinition = "nvarchar(Max)")
	String context;

	@Column(name = "dist_ID", columnDefinition = "int")
	Integer districtTypeId;

	@Column(name = "wish_sDate", columnDefinition = "datetime")
	Date startDate;

	@Column(name = "wish_eDate", columnDefinition = "datetime")
	Date endDate;

	@Column(name = "wish_compTime", columnDefinition = "datetime")
	Date completeTime;

	@Column(name = "wish_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "memW_ID", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	Product productBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "dist_ID", insertable = false, updatable = false)
	DistrictType districtTypeBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wish_state", insertable = false, updatable = false)
	State stateBean;

	public Wish() {
	}

	public Wish(Integer id, Integer memberId, Integer productId, String title, String context, Integer districtTypeId,
			Date startDate, Date endDate, Date completeTime, Integer state) {
		this.id = id;
		this.memberId = memberId;
		this.productId = productId;
		this.title = title;
		this.context = context;
		this.districtTypeId = districtTypeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.completeTime = completeTime;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Wish [id=" + id + ", memberId=" + memberId + ", productId=" + productId + ", title=" + title
				+ ", context=" + context + ", districtTypeId=" + districtTypeId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", completeTime=" + completeTime + ", state=" + state + "]\r\n  [memberBean="
				+ memberBean + "]\r\n  [productBean=" + productBean + "]\r\n  [districtTypeBean=" + districtTypeBean
				+ "]\r\n  [stateBean=" + stateBean + "]\r\n";
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

	public Member getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(Member memberBean) {
		this.memberBean = memberBean;
	}

	public Product getProductBean() {
		return productBean;
	}

	public void setProductBean(Product productBean) {
		this.productBean = productBean;
	}

	public DistrictType getDistrictTypeBean() {
		return districtTypeBean;
	}

	public void setDistrictTypeBean(DistrictType districtTypeBean) {
		this.districtTypeBean = districtTypeBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
