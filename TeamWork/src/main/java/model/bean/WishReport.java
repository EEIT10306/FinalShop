package model.bean;

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
@Table(name = "WishReport")
public class WishReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wR_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "wP_ID", columnDefinition = "int")
	Integer wishProductID;

	@Column(name = "mem_ID", columnDefinition = "int")
	Integer memberID;

	@Column(name = "wR_cont", columnDefinition = "nvarchar(max)")
	String content;

	@Column(name = "wR_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wP_ID", insertable = false, updatable = false)
	WishProduct wishProductBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "wR_state", insertable = false, updatable = false)
	State stateBean;

	public WishReport() {
	}

	public WishReport(Integer id, Integer wishProductID, Integer memberID, String content, Integer state) {
		this.id = id;
		this.wishProductID = wishProductID;
		this.memberID = memberID;
		this.content = content;
		this.state = state;
	}

	@Override
	public String toString() {
		return "WishReport [id=" + id + ", wishProductID=" + wishProductID + ", memberID=" + memberID + ", content="
				+ content + ", state=" + state + "]\r\n  [wishProductBean=" + wishProductBean + "]\r\n  [memberBean=" + memberBean
				+ "]\r\n  [stateBean=" + stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWishProductID() {
		return wishProductID;
	}

	public void setWishProductID(Integer wishProductID) {
		this.wishProductID = wishProductID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public WishProduct getWishProductBean() {
		return wishProductBean;
	}

	public void setWishProductBean(WishProduct wishProductBean) {
		this.wishProductBean = wishProductBean;
	}

	public Member getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(Member memberBean) {
		this.memberBean = memberBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
