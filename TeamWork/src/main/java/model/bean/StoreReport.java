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
@Table(name = "StoreReport")
public class StoreReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sR_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "sP_ID", columnDefinition = "int")
	Integer storeProductId;

	@Column(name = "mem_ID", columnDefinition = "int")
	Integer memberId;

	@Column(name = "sR_cont", columnDefinition = "nvarchar(max)")
	String content;

	@Column(name = "sR_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sP_ID", insertable = false, updatable = false)
	StoreProduct storeProductBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "sR_state", insertable = false, updatable = false)
	State stateBean;

	public StoreReport() {
	}

	public StoreReport(Integer id, Integer storeProductId, Integer memberId, String content, Integer state) {
		this.id = id;
		this.storeProductId = storeProductId;
		this.memberId = memberId;
		this.content = content;
		this.state = state;
	}

	@Override
	public String toString() {
		return "StoreReport [id=" + id + ", storeProductId=" + storeProductId + ", memberId=" + memberId + ", content="
				+ content + ", state=" + state + "]\r\n  [storeProductBean=" + storeProductBean + "]\r\n  [memberBean=" + memberBean
				+ "]\r\n  [stateBean=" + stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStoreProductId() {
		return storeProductId;
	}

	public void setStoreProductId(Integer storeProductId) {
		this.storeProductId = storeProductId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public StoreProduct getStoreProductBean() {
		return storeProductBean;
	}

	public void setStoreProductBean(StoreProduct storeProductBean) {
		this.storeProductBean = storeProductBean;
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
