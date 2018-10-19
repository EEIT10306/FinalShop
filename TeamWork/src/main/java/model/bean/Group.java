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
@Table(name = "Group")
public class Group {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "group_ID", columnDefinition = "int")
	Integer id;
	@Column(name = "memG_ID", columnDefinition = "int")
	Integer memberId;
	@Column(name = "prod_ID", columnDefinition = "int")
	Integer groupClass;
	@Column(name = "group_title", columnDefinition = "nvarchar(max)")
	String title;
	@Column(name = "group_cont", columnDefinition = "nvarchar(max)")
	String cont;
	@Column(name = "dist_ID", columnDefinition = "int")
	Integer DistrictTypeId;
	@Column(name = "group_sDate", columnDefinition = "datetime")
	Date startDate;
	@Column(name = "group_sDate", columnDefinition = "datetime")
	Date endDate;
	@Column(name = "group_goal", columnDefinition = "nvarchar(max)")
	String goal;
	@Column(name = "group_compTime", columnDefinition = "datetime")
	Date compTime;
	@Column(name = "group_state", columnDefinition = "int")
	Integer state;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "memG_ID", insertable = false, updatable = false)
	Member mem;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	Product pro;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "dist_ID", insertable = false, updatable = false)
	DistrictType dis;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "group_state", insertable = false, updatable = false)
	State sta;
	
	public Group() {
	}

	public Group(Integer id, Integer memberId, Integer groupClass, String title, String cont, Integer districtTypeId,
			Date startDate, Date endDate, String goal, Date compTime, Integer state) {
		this.id = id;
		this.memberId = memberId;
		this.groupClass = groupClass;
		this.title = title;
		this.cont = cont;
		DistrictTypeId = districtTypeId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.goal = goal;
		this.compTime = compTime;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", memberId=" + memberId + ", groupClass=" + groupClass + ", title=" + title
				+ ", cont=" + cont + ", DistrictTypeId=" + DistrictTypeId + ", startDate=" + startDate + ", endDate="
				+ endDate + ", goal=" + goal + ", compTime=" + compTime + ", state=" + state + "]";
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

	public Integer getGroupClass() {
		return groupClass;
	}

	public void setGroupClass(Integer groupClass) {
		this.groupClass = groupClass;
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
		return DistrictTypeId;
	}

	public void setDistrictTypeId(Integer districtTypeId) {
		DistrictTypeId = districtTypeId;
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

	public Product getPro() {
		return pro;
	}

	public void setPro(Product pro) {
		this.pro = pro;
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
