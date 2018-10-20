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
@Table(name = "WishMessage")
public class WishMessage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wM_ID", columnDefinition = "int")
	Integer id;
	@Column(name = "wP_ID", columnDefinition = "int")
	Integer wishProductId;
	@Column(name = "mem_IDee", columnDefinition = "int")
	Integer memberId;
	@Column(name = "wM_bid", columnDefinition = "int")
	Integer productId;
	@Column(name = "wM_cont", columnDefinition = "nvarchar(max)")
	String bid;
	@Column(name = "wM_time", columnDefinition = "datetime")
	Date time;
	@Column(name = "wP_state", columnDefinition = "int")
	Integer state;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wP_ID", insertable = false, updatable = false)
	WishProduct wis;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_IDee", insertable = false, updatable = false)
	Member mem;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wM_state", insertable = false, updatable = false)
	DistrictType dis;

	public WishMessage() {}

	public WishMessage(Integer id, Integer wishProductId, Integer memberId, Integer productId, String bid, Date time,
			Integer state) {
		this.id = id;
		this.wishProductId = wishProductId;
		this.memberId = memberId;
		this.productId = productId;
		this.bid = bid;
		this.time = time;
		this.state = state;
	}

	@Override
	public String toString() {
		return "WishMessage [id=" + id + ", wishProductId=" + wishProductId + ", memberId=" + memberId + ", productId="
				+ productId + ", bid=" + bid + ", time=" + time + ", state=" + state + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWishProductId() {
		return wishProductId;
	}

	public void setWishProductId(Integer wishProductId) {
		this.wishProductId = wishProductId;
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

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public WishProduct getWis() {
		return wis;
	}

	public void setWis(WishProduct wis) {
		this.wis = wis;
	}

	public Member getMem() {
		return mem;
	}

	public void setMem(Member mem) {
		this.mem = mem;
	}

	public DistrictType getDis() {
		return dis;
	}

	public void setDis(DistrictType dis) {
		this.dis = dis;
	}
	
	
	
}
