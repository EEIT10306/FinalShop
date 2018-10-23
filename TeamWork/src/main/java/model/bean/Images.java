package model.bean;

import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Images")
public class Images {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "im_ID", columnDefinition = "int")
	Integer id;

	@Column(name = "wgs_ID", columnDefinition = "int")
	Integer wgsID;

	@Column(name = "im_cont", columnDefinition = "varbinary(max)")
	Blob cont;

	@Column(name = "im_from", columnDefinition = "nvarchar(max)")
	String from;
	
	@Column(name = "im_state", columnDefinition = "int")
	Integer state;

	@ManyToOne(cascade = CascadeType.MERGE)
	@Column(name = "wgs_ID", insertable = false, updatable = false)
	Wish wishBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@Column(name = "wgs_ID", insertable = false, updatable = false)
	Group groupBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@Column(name = "wgs_ID", insertable = false, updatable = false)
	Store storeBean;

	@ManyToOne(cascade = CascadeType.MERGE)
	@Column(name = "im_state", insertable = false, updatable = false)
	State stateBean;

	public Images() {
	}

	public Images(Integer id, Integer wgsID, Blob cont, String from, Integer state) {
		this.id = id;
		this.wgsID = wgsID;
		this.cont = cont;
		this.from = from;
		this.state = state;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", wgsID=" + wgsID + ", cont=" + cont + ", from=" + from + ", state=" + state
				+ "]\r\n  [wishBean=" + wishBean + "]\r\n  [groupBean=" + groupBean + "]\r\n  [storeBean=" + storeBean + "]\r\n  [stateBean="
				+ stateBean + "]\r\n";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getWgsID() {
		return wgsID;
	}

	public void setWgsID(Integer wgsID) {
		this.wgsID = wgsID;
	}

	public Blob getCont() {
		return cont;
	}

	public void setCont(Blob cont) {
		this.cont = cont;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Wish getWishBean() {
		return wishBean;
	}

	public void setWishBean(Wish wishBean) {
		this.wishBean = wishBean;
	}

	public Group getGroupBean() {
		return groupBean;
	}

	public void setGroupBean(Group groupBean) {
		this.groupBean = groupBean;
	}

	public Store getStoreBean() {
		return storeBean;
	}

	public void setStoreBean(Store storeBean) {
		this.storeBean = storeBean;
	}

	public State getStateBean() {
		return stateBean;
	}

	public void setStateBean(State stateBean) {
		this.stateBean = stateBean;
	}

}
