package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StoreReport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sR_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "sP_ID", columnDefinition = "int", nullable = false)
	private Integer storeProductId;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "sR_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String content;

	@Column(name = "sR_state", columnDefinition = "int", nullable = false)
	private Integer stateI;

	@ManyToOne
	@JoinColumn(name = "sP_ID", insertable = false, updatable = false)
	private StoreProduct StoreProduct;

	@ManyToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "sR_state", insertable = false, updatable = false)
	private State State;

	public StoreReport() {
	}

	public StoreReport(Integer id, Integer storeProductId, Integer memberId, String content, Integer stateI) {
		super();
		this.id = id;
		this.storeProductId = storeProductId;
		this.memberId = memberId;
		this.content = content;
		this.stateI = stateI;
	}

	@Override
	public String toString() {
		return "StoreReport [id=" + id + ", storeProductId=" + storeProductId + ", memberId=" + memberId + ", content="
				+ content + ", stateI=" + stateI + ", StoreProduct=" + StoreProduct + ", Member=" + Member + ", State="
				+ State + "]\r\n";
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

	public Integer getStateI() {
		return stateI;
	}

	public void setStateI(Integer stateI) {
		this.stateI = stateI;
	}

	public StoreProduct getStoreProduct() {
		return StoreProduct;
	}

	public Member getMember() {
		return Member;
	}

	public State getState() {
		return State;
	}

}
