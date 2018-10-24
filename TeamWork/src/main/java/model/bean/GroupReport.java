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
@Table(name = "GroupReport")
public class GroupReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gR_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "gProd_ID", columnDefinition = "int")
	Integer productId;

	@Column(name = "mem_ID", columnDefinition = "int")
	Integer memberId;

	@Column(name = "gR_cont", columnDefinition = "nvarchar(max)")
	String content;

	@Column(name = "gR_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gProd_ID", insertable = false, updatable = false)
	GroupProduct groupProductBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	Member memberBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gR_state", insertable = false, updatable = false)
	State stateBean;

	public GroupReport() {
	}

	public GroupReport(Integer id, Integer productId, Integer memberId, String content, Integer state) {
		this.id = id;
		this.productId = productId;
		this.memberId = memberId;
		this.content = content;
		this.state = state;
	}

	@Override
	public String toString() {
		return "GroupReport [id=" + id + ", productId=" + productId + ", memberId=" + memberId + ", content=" + content
				+ ", state=" + state + "]\r\n  [groupProductBean=" + groupProductBean + "]\r\n  [memberBean="
				+ memberBean + "[\r\n  [stateBean=" + stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
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

	public GroupProduct getGroupProductBean() {
		return groupProductBean;
	}

	public void setGroupProductBean(GroupProduct groupProductBean) {
		this.groupProductBean = groupProductBean;
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
