package model.bean;

import java.sql.Blob;
import java.util.Arrays;

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
@Table(name = "Member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mem_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "mem_acc", columnDefinition = "nvarchar(MAX)")
	String account;

	@Column(name = "mem_pass", columnDefinition = "nvarchar(MAX)")
	String password;

	@Column(name = "mem_name", columnDefinition = "nvarchar(MAX)")
	String name;

	@Column(name = "mem_add", columnDefinition = "nvarchar(MAX)")
	String address;

	@Column(name = "mem_tel", columnDefinition = "nvarchar(MAX)")
	String telephone;

	@Column(name = "mem_mail", columnDefinition = "nvarchar(MAX)")
	String mail;

	@Column(name = "mem_pos", columnDefinition = "nvarchar(MAX)")
	String position;

	@Column(name = "mem_coin", columnDefinition = "int")
	Integer coin;

	@Column(name = "mem_pho", columnDefinition = "varbinary(MAX)")
	Blob photo;

	@Column(name = "mem_state", columnDefinition = "int")
	Integer state;

	@Column(name = "wA_sumee", columnDefinition = "float")
	Double wiseAssessSumEE;

	@Column(name = "gA_sumee", columnDefinition = "float")
	Double groupAssessSumEE;

	@Column(name = "sA_sumee", columnDefinition = "float")
	Double storeAssessSumEE;

	@Column(name = "wA_sum", columnDefinition = "float")
	Double wiseAssessSum;

	@Column(name = "gA_sum", columnDefinition = "float")
	Double groupAssessSum;

	@Column(name = "sA_sum", columnDefinition = "float")
	Double storeAssessSum;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_state", insertable = false, updatable = false)
	State stateBean;

	public Member() {
	}

	public Member(Integer id, String account, String password, String name, String address, String telephone,
			String mail, String position, Integer coin, Blob photo, Integer state, Double wiseAssessSumEE,
			Double groupAssessSumEE, Double storeAssessSumEE, Double wiseAssessSum, Double groupAssessSum,
			Double storeAssessSum) {
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
		this.state = state;
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
				+ ", photo=" + photo + ", state=" + state + ", wiseAssessSumEE=" + wiseAssessSumEE
				+ ", groupAssessSumEE=" + groupAssessSumEE + ", storeAssessSumEE=" + storeAssessSumEE
				+ ", wiseAssessSum=" + wiseAssessSum + ", groupAssessSum=" + groupAssessSum + ", storeAssessSum="
				+ storeAssessSum + "]\r\n  [stateBean=" + stateBean + "]\r\n";
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

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
