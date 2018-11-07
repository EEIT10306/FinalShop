package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer m_id;

	@Column(name = "mem_acc", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String m_account;

	@Column(name = "mem_pass", columnDefinition = "nvarchar(MAX)")
	private String m_password;

	@Column(name = "mem_name", columnDefinition = "nvarchar(MAX)")
	private String m_name;

	@Column(name = "mem_add", columnDefinition = "nvarchar(MAX)")
	private String m_address;

	@Column(name = "mem_tel", columnDefinition = "nvarchar(MAX)")
	private String m_telephone;

	@Column(name = "mem_mail", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String m_mail;

	@Column(name = "mem_pos", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String m_position;

	@Column(name = "mem_coin", columnDefinition = "int", nullable = false)
	private Integer m_coin;

	@Column(name = "mem_pho", columnDefinition = "nvarchar(MAX)")
	private String m_photo;

	@Column(name = "mem_loginCount", columnDefinition = "int", nullable = false)
	private Integer m_loginCount;

	@Column(name = "mem_loginTime", columnDefinition = "datetime")
	private Date m_loginTime;

	@Column(name = "mem_state", columnDefinition = "int", nullable = false)
	private Integer m_stateId;

	@Column(name = "wA_sumee", columnDefinition = "float", nullable = false)
	private Double m_wishAssessSumEE;

	@Column(name = "gA_sumee", columnDefinition = "float", nullable = false)
	private Double m_groupAssessSumEE;

	@Column(name = "sA_sumee", columnDefinition = "float", nullable = false)
	private Double m_storeAssessSumEE;

	@Column(name = "wA_sum", columnDefinition = "float", nullable = false)
	private Double m_wishAssessSum;

	@Column(name = "gA_sum", columnDefinition = "float", nullable = false)
	private Double m_groupAssessSum;

	@Column(name = "sA_sum", columnDefinition = "float", nullable = false)
	private Double m_storeAssessSum;

	@ManyToOne
	@JoinColumn(name = "mem_state", insertable = false, updatable = false)
	private State state;

	public Member() {
	}

	public Member(Integer m_id, String m_account, String m_password, String m_name, String m_address,
			String m_telephone, String m_mail, String m_position, Integer m_coin, String m_photo, Integer m_loginCount,
			Date m_loginTime, Integer m_stateId, Double m_wishAssessSumEE, Double m_groupAssessSumEE,
			Double m_storeAssessSumEE, Double m_wishAssessSum, Double m_groupAssessSum, Double m_storeAssessSum) {
		super();
		this.m_id = m_id;
		this.m_account = m_account;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_address = m_address;
		this.m_telephone = m_telephone;
		this.m_mail = m_mail;
		this.m_position = m_position;
		this.m_coin = m_coin;
		this.m_photo = m_photo;
		this.m_loginCount = m_loginCount;
		this.m_loginTime = m_loginTime;
		this.m_stateId = m_stateId;
		this.m_wishAssessSumEE = m_wishAssessSumEE;
		this.m_groupAssessSumEE = m_groupAssessSumEE;
		this.m_storeAssessSumEE = m_storeAssessSumEE;
		this.m_wishAssessSum = m_wishAssessSum;
		this.m_groupAssessSum = m_groupAssessSum;
		this.m_storeAssessSum = m_storeAssessSum;
	}

	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_account=" + m_account + ", m_password=" + m_password + ", m_name=" + m_name
				+ ", m_address=" + m_address + ", m_telephone=" + m_telephone + ", m_mail=" + m_mail + ", m_position="
				+ m_position + ", m_coin=" + m_coin + ", m_photo=" + m_photo + ", m_loginCount=" + m_loginCount
				+ ", m_loginTime=" + m_loginTime + ", m_stateId=" + m_stateId + ", m_wishAssessSumEE="
				+ m_wishAssessSumEE + ", m_groupAssessSumEE=" + m_groupAssessSumEE + ", m_storeAssessSumEE="
				+ m_storeAssessSumEE + ", m_wishAssessSum=" + m_wishAssessSum + ", m_groupAssessSum=" + m_groupAssessSum
				+ ", m_storeAssessSum=" + m_storeAssessSum + "]\r\n";
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public String getM_account() {
		return m_account;
	}

	public void setM_account(String m_account) {
		this.m_account = m_account;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public String getM_telephone() {
		return m_telephone;
	}

	public void setM_telephone(String m_telephone) {
		this.m_telephone = m_telephone;
	}

	public String getM_mail() {
		return m_mail;
	}

	public void setM_mail(String m_mail) {
		this.m_mail = m_mail;
	}

	public String getM_position() {
		return m_position;
	}

	public void setM_position(String m_position) {
		this.m_position = m_position;
	}

	public Integer getM_coin() {
		return m_coin;
	}

	public void setM_coin(Integer m_coin) {
		this.m_coin = m_coin;
	}

	public String getM_photo() {
		return m_photo;
	}

	public void setM_photo(String m_photo) {
		this.m_photo = m_photo;
	}

	public Integer getM_loginCount() {
		return m_loginCount;
	}

	public void setM_loginCount(Integer m_loginCount) {
		this.m_loginCount = m_loginCount;
	}

	public Date getM_loginTime() {
		return m_loginTime;
	}

	public void setM_loginTime(Date m_loginTime) {
		this.m_loginTime = m_loginTime;
	}

	public Integer getM_stateId() {
		return m_stateId;
	}

	public void setM_stateId(Integer m_stateId) {
		this.m_stateId = m_stateId;
	}

	public Double getM_wishAssessSumEE() {
		return m_wishAssessSumEE;
	}

	public void setM_wishAssessSumEE(Double m_wishAssessSumEE) {
		this.m_wishAssessSumEE = m_wishAssessSumEE;
	}

	public Double getM_groupAssessSumEE() {
		return m_groupAssessSumEE;
	}

	public void setM_groupAssessSumEE(Double m_groupAssessSumEE) {
		this.m_groupAssessSumEE = m_groupAssessSumEE;
	}

	public Double getM_storeAssessSumEE() {
		return m_storeAssessSumEE;
	}

	public void setM_storeAssessSumEE(Double m_storeAssessSumEE) {
		this.m_storeAssessSumEE = m_storeAssessSumEE;
	}

	public Double getM_wishAssessSum() {
		return m_wishAssessSum;
	}

	public void setM_wishAssessSum(Double m_wishAssessSum) {
		this.m_wishAssessSum = m_wishAssessSum;
	}

	public Double getM_groupAssessSum() {
		return m_groupAssessSum;
	}

	public void setM_groupAssessSum(Double m_groupAssessSum) {
		this.m_groupAssessSum = m_groupAssessSum;
	}

	public Double getM_storeAssessSum() {
		return m_storeAssessSum;
	}

	public void setM_storeAssessSum(Double m_storeAssessSum) {
		this.m_storeAssessSum = m_storeAssessSum;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
