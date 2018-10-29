package model.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mem_ID", columnDefinition = "int", nullable = false)
	private Integer id;

	@Column(name = "mem_acc", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String account;

	@Column(name = "mem_pass", columnDefinition = "nvarchar(MAX)")
	private String password;

	@Column(name = "mem_name", columnDefinition = "nvarchar(MAX)")
	private String name;

	@Column(name = "mem_add", columnDefinition = "nvarchar(MAX)")
	private String address;

	@Column(name = "mem_tel", columnDefinition = "nvarchar(MAX)")
	private String telephone;

	@Column(name = "mem_mail", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String mail;

	@Column(name = "mem_pos", columnDefinition = "nvarchar(MAX)", nullable = false)
	private String position = "member";

	@Column(name = "mem_coin", columnDefinition = "int", nullable = false)
	private Integer coin = 0;

	@Column(name = "mem_pho", columnDefinition = "nvarchar(MAX)")
	private String photo;

	@Column(name = "mem_state", columnDefinition = "int", nullable = false)
	private Integer stateId = 1;

	@Column(name = "mem_loginCount", columnDefinition = "int", nullable = false)
	private Integer loginCount = 0;

	@Column(name = "mem_loginTime", columnDefinition = "datetime")
	private Date loginTime;

	@Column(name = "wA_sumee", columnDefinition = "float", nullable = false)
	private Double wiseAssessSumEE = 0d;

	@Column(name = "gA_sumee", columnDefinition = "float", nullable = false)
	private Double groupAssessSumEE = 0d;

	@Column(name = "sA_sumee", columnDefinition = "float", nullable = false)
	private Double storeAssessSumEE = 0d;

	@Column(name = "wA_sum", columnDefinition = "float", nullable = false)
	private Double wiseAssessSum = 0d;

	@Column(name = "gA_sum", columnDefinition = "float", nullable = false)
	private Double groupAssessSum = 0d;

	@Column(name = "sA_sum", columnDefinition = "float", nullable = false)
	private Double storeAssessSum = 0d;

	@ManyToOne
	@JoinColumn(name = "mem_state", insertable = false, updatable = false)
	private State State;

	public Member() {
	}

	public Member(Integer id, String account, String password, String name, String address, String telephone,
			String mail, String position, Integer coin, String photo, Integer stateId, Integer loginCount,
			Date loginTime, Double wiseAssessSumEE, Double groupAssessSumEE, Double storeAssessSumEE,
			Double wiseAssessSum, Double groupAssessSum, Double storeAssessSum) {
		super();
		this.id = id;
		this.account = account;
		this.password = password;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
		this.mail = mail;
		this.position = position;
		this.coin = coin;
		this.photo = photo;
		this.stateId = stateId;
		this.loginCount = loginCount;
		this.loginTime = loginTime;
		this.wiseAssessSumEE = wiseAssessSumEE;
		this.groupAssessSumEE = groupAssessSumEE;
		this.storeAssessSumEE = storeAssessSumEE;
		this.wiseAssessSum = wiseAssessSum;
		this.groupAssessSum = groupAssessSum;
		this.storeAssessSum = storeAssessSum;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", account=" + account + ", password=" + password + ", name=" + name + ", address="
				+ address + ", telephone=" + telephone + ", mail=" + mail + ", position=" + position + ", coin=" + coin
				+ ", photo=" + photo + ", stateId=" + stateId + ", loginCount=" + loginCount + ", loginTime="
				+ loginTime + ", wiseAssessSumEE=" + wiseAssessSumEE + ", groupAssessSumEE=" + groupAssessSumEE
				+ ", storeAssessSumEE=" + storeAssessSumEE + ", wiseAssessSum=" + wiseAssessSum + ", groupAssessSum="
				+ groupAssessSum + ", storeAssessSum=" + storeAssessSum + ", State=" + State + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getCoin() {
		return coin;
	}

	public void setCoin(Integer coin) {
		this.coin = coin;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public Double getWiseAssessSumEE() {
		return wiseAssessSumEE;
	}

	public void setWiseAssessSumEE(Double wiseAssessSumEE) {
		this.wiseAssessSumEE = wiseAssessSumEE;
	}

	public Double getGroupAssessSumEE() {
		return groupAssessSumEE;
	}

	public void setGroupAssessSumEE(Double groupAssessSumEE) {
		this.groupAssessSumEE = groupAssessSumEE;
	}

	public Double getStoreAssessSumEE() {
		return storeAssessSumEE;
	}

	public void setStoreAssessSumEE(Double storeAssessSumEE) {
		this.storeAssessSumEE = storeAssessSumEE;
	}

	public Double getWiseAssessSum() {
		return wiseAssessSum;
	}

	public void setWiseAssessSum(Double wiseAssessSum) {
		this.wiseAssessSum = wiseAssessSum;
	}

	public Double getGroupAssessSum() {
		return groupAssessSum;
	}

	public void setGroupAssessSum(Double groupAssessSum) {
		this.groupAssessSum = groupAssessSum;
	}

	public Double getStoreAssessSum() {
		return storeAssessSum;
	}

	public void setStoreAssessSum(Double storeAssessSum) {
		this.storeAssessSum = storeAssessSum;
	}

	public State getState() {
		return State;
	}

}
