package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Seller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seller_ID", columnDefinition = "int", nullable = false)
	private Integer seller_id;

	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer m_id;

	@Column(name = "seller_bank", columnDefinition = "nvarchar(MAX)")
	private String seller_bank;

	@Column(name = "seller_card", columnDefinition = "nvarchar(MAX)")
	private String seller_card;

	@Column(name = "seller_state", columnDefinition = "int", nullable = false)
	private Integer seller_stateId;

	@OneToOne
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "seller_state", insertable = false, updatable = false)
	private State state;

	public Seller() {
	}

	public Seller(Integer seller_id, Integer m_id, String seller_bank, String seller_card, Integer seller_stateId) {
		super();
		this.seller_id = seller_id;
		this.m_id = m_id;
		this.seller_bank = seller_bank;
		this.seller_card = seller_card;
		this.seller_stateId = seller_stateId;
	}

	@Override
	public String toString() {
		return "Seller [seller_id=" + seller_id + ", m_id=" + m_id + ", seller_bank=" + seller_bank + ", seller_card="
				+ seller_card + ", seller_stateId=" + seller_stateId + ", member=" + member + ", state=" + state
				+ "]\r\n";
	}

	public Integer getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(Integer seller_id) {
		this.seller_id = seller_id;
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public String getSeller_bank() {
		return seller_bank;
	}

	public void setSeller_bank(String seller_bank) {
		this.seller_bank = seller_bank;
	}

	public String getSeller_card() {
		return seller_card;
	}

	public void setSeller_card(String seller_card) {
		this.seller_card = seller_card;
	}

	public Integer getSeller_stateId() {
		return seller_stateId;
	}

	public void setSeller_stateId(Integer seller_stateId) {
		this.seller_stateId = seller_stateId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
