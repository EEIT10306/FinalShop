package model.bean;

import java.util.Arrays;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Images")
public class Images {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="im_ID" , columnDefinition = "int")
	Integer id;
	
	@Column(name="wgs_ID" , columnDefinition = "int")
	Integer wgsID;
	
	@Column(name="im_cont" , columnDefinition = "varbinary(max)")
	Byte[] cont;
	
	@Column(name="im_state" , columnDefinition = "int")
	Integer imState;
	
	@ManyToOne(cascade=CascadeType.MERGE)
	@Column(name="wgs_ID" , insertable = false , updatable = false)
	Wish wish;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column(name="wgs_ID" , insertable = false , updatable = false)
	Group group;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column(name="wgs_ID" , insertable = false , updatable = false)
	Store store;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@Column(name="im_state" , insertable = false , updatable = false)
	State state;

	public Images() {
	}

	public Images(Integer id, Integer wgsID, Byte[] cont, Integer imState) {
		this.id = id;
		this.wgsID = wgsID;
		this.cont = cont;
		this.imState = imState;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", wgsID=" + wgsID + ", cont=" + Arrays.toString(cont) + ", imState=" + imState
				+ "]";
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

	public Byte[] getCont() {
		return cont;
	}

	public void setCont(Byte[] cont) {
		this.cont = cont;
	}

	public Integer getImState() {
		return imState;
	}

	public void setImState(Integer imState) {
		this.imState = imState;
	}

	public Wish getWish() {
		return wish;
	}

	public void setWish(Wish wish) {
		this.wish = wish;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
