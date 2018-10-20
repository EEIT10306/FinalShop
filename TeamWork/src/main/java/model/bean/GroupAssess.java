package model.bean;

import javax.persistence.CascadeType;
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
@Table(name="GroupAssess")
public class GroupAssess {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="gA_ID" , columnDefinition="int")
	Integer id;
	
	@Column(name="gM_ID" , columnDefinition="int")
	Integer gmID;
	
	@Column(name="gA_point" , columnDefinition = "int")
	Integer point;
	
	@Column(name="gA_cont" , columnDefinition="nvarchar(max)")
	String cont;
	
	@Column(name="gA_pointee" , columnDefinition="int")
	Integer pointee;
	
	@Column(name="gA_contee" , columnDefinition="nvarchar(max)")
	String contee;
	
	@Column(name="gA_state" , columnDefinition="int")
	Integer gaState;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="gM_ID" , insertable=false, updatable = false)
	GroupMessage message;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="gA_state" , insertable=false , updatable = false)
	State state;

	public GroupAssess() {
	}

	public GroupAssess(Integer id, Integer gmID, Integer point, String cont, Integer pointee, String contee, Integer gaState) {
		this.id = id;
		this.gmID = gmID;
		this.point = point;
		this.cont = cont;
		this.pointee = pointee;
		this.contee = contee;
		this.gaState = gaState;
	}

	@Override
	public String toString() {
		return "GroupAssess [id=" + id + ", gmID=" + gmID + ", point=" + point + ", cont=" + cont + ", pointee="
				+ pointee + ", contee=" + contee + ", gaState=" + gaState + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getGmID() {
		return gmID;
	}

	public void setGmID(Integer gmID) {
		this.gmID = gmID;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getCont() {
		return cont;
	}

	public void setCont(String cont) {
		this.cont = cont;
	}

	public Integer getPointee() {
		return pointee;
	}

	public void setPointee(Integer pointee) {
		this.pointee = pointee;
	}

	public String getContee() {
		return contee;
	}

	public void setContee(String contee) {
		this.contee = contee;
	}

	public Integer getGaState() {
		return gaState;
	}

	public void setGaState(Integer gaState) {
		this.gaState = gaState;
	}

	public GroupMessage getMessage() {
		return message;
	}

	public void setMessage(GroupMessage message) {
		this.message = message;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
