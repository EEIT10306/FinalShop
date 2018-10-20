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
	@Column(name = "wish_title", columnDefinition = "nvarchar(max)")
	String title;
	@Column(name = "wish_cont", columnDefinition = "nvarchar(max)")
	String cont;
	@Column(name = "dist_ID", columnDefinition = "int")
	Integer districtTypeId;
	@Column(name = "wish_sDate", columnDefinition = "datetime")
	Date startDate;
	@Column(name = "wish_eDate", columnDefinition = "datetime")
	Date endDate;
	@Column(name = "wish_compTime", columnDefinition = "datetime")
	Date compTime;
	@Column(name = "wish_state", columnDefinition = "int")
	Integer state;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "memW_ID", insertable = false, updatable = false)
	Member mem;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	Product prd;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "dist_ID", insertable = false, updatable = false)
	DistrictType dis;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wish_state", insertable = false, updatable = false)
	State sta;
	public Wish() {}
	public Wish(Integer id, Integer memberId, Integer productId, String title, String cont, Integer districtTypeId,
			Date startDate, Date endDate, Date compTime, Integer state) {
		this.id = id;
		this.memberId = memberId;
		this.productId = productId;
		this.title = title;
		this.cont = cont;
		this.districtTypeId = districtTypeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.compTime = compTime;
		this.state = state;
	}
	@Override
	public String toString() {
		return "Wish [id=" + id + ", memberId=" + memberId + ", productId=" + productId + ", title=" + title + ", cont="
				+ cont + ", districtTypeId=" + districtTypeId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", compTime=" + compTime + ", state=" + state + "]\r\t";
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
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
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
	public Member getMem() {
		return mem;
	}
	public void setMem(Member mem) {
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
	public State getSta() {
		return sta;
	}
	public void setSta(State sta) {
		this.sta = sta;
	}
	
	
	
	
}
