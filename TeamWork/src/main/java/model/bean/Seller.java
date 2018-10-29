package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer memberId;

	@Column(name = "seller_bank", columnDefinition = "nvarchar(MAX)")
	private String bank;

	@Column(name = "seller_card", columnDefinition = "nvarchar(MAX)")
	private String card;

	@Column(name = "seller_state", columnDefinition = "int", nullable = false)
	private Integer stateId;

	@OneToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member Member;

	@ManyToOne
	@JoinColumn(name = "seller_state", insertable = false, updatable = false)
	private State State;

	public Seller() {
	}

	public Seller(Integer id, Integer memberId, String bank, String card, Integer stateId) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.bank = bank;
		this.card = card;
		this.stateId = stateId;
	}

	@Override
	public String toString() {
		return "Seller [id=" + id + ", memberId=" + memberId + ", bank=" + bank + ", card=" + card + ", stateId="
				+ stateId + ", Member=" + Member + ", State=" + State + "]\r\n";
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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
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

	public State getState() {
		return State;
	}

}
