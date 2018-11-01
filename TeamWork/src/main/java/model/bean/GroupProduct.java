package model.bean;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class GroupProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gP_ID", columnDefinition = "int", nullable = false)
	private Integer gP_id;

	@Column(name = "group_ID", columnDefinition = "int", nullable = false)
	private Integer g_iD;

	@Column(name = "gP_name", columnDefinition = "nvarchar(max)", nullable = false)
	private String gP_name;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer p_id;

	@Column(name = "gP_amt", columnDefinition = "int", nullable = false)
	private Integer gP_amount;

	@Column(name = "gP_price", columnDefinition = "int", nullable = false)
	private Integer gP_price;

	@Column(name = "gP_cont", columnDefinition = "nvarchar(max)", nullable = false)
	private String gP_context;

	@Column(name = "gP_var", columnDefinition = "int", nullable = false)
	private Integer gP_version;

	@Column(name = "gP_compTime", columnDefinition = "datetime")
	private Date gP_completeTime;

	@Column(name = "gP_state", columnDefinition = "int", nullable = false)
	private Integer gP_stateId;

	@ManyToOne
	@JoinColumn(name = "group_ID", insertable = false, updatable = false)
	private Groupon groupon;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "gP_state", insertable = false, updatable = false)
	private State state;

	@OneToMany(mappedBy = "groupProduct")
	private Set<Images> images;

	public GroupProduct() {
	}

	public GroupProduct(Integer gP_id, Integer g_iD, String gP_name, Integer p_id, Integer gP_amount, Integer gP_price,
			String gP_context, Integer gP_version, Date gP_completeTime, Integer gP_stateId) {
		super();
		this.gP_id = gP_id;
		this.g_iD = g_iD;
		this.gP_name = gP_name;
		this.p_id = p_id;
		this.gP_amount = gP_amount;
		this.gP_price = gP_price;
		this.gP_context = gP_context;
		this.gP_version = gP_version;
		this.gP_completeTime = gP_completeTime;
		this.gP_stateId = gP_stateId;
	}

	@Override
	public String toString() {
		return "GroupProduct [gP_id=" + gP_id + ", g_iD=" + g_iD + ", gP_name=" + gP_name + ", p_id=" + p_id
				+ ", gP_amount=" + gP_amount + ", gP_price=" + gP_price + ", gP_context=" + gP_context + ", gP_version="
				+ gP_version + ", gP_completeTime=" + gP_completeTime + ", gP_stateId=" + gP_stateId + ", groupon="
				+ groupon + ", product=" + product + ", state=" + state + ", images=" + images + "]\r\n";
	}

	public Integer getgP_id() {
		return gP_id;
	}

	public void setgP_id(Integer gP_id) {
		this.gP_id = gP_id;
	}

	public Integer getG_iD() {
		return g_iD;
	}

	public void setG_iD(Integer g_iD) {
		this.g_iD = g_iD;
	}

	public String getgP_name() {
		return gP_name;
	}

	public void setgP_name(String gP_name) {
		this.gP_name = gP_name;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public Integer getgP_amount() {
		return gP_amount;
	}

	public void setgP_amount(Integer gP_amount) {
		this.gP_amount = gP_amount;
	}

	public Integer getgP_price() {
		return gP_price;
	}

	public void setgP_price(Integer gP_price) {
		this.gP_price = gP_price;
	}

	public String getgP_context() {
		return gP_context;
	}

	public void setgP_context(String gP_context) {
		this.gP_context = gP_context;
	}

	public Integer getgP_version() {
		return gP_version;
	}

	public void setgP_version(Integer gP_version) {
		this.gP_version = gP_version;
	}

	public Date getgP_completeTime() {
		return gP_completeTime;
	}

	public void setgP_completeTime(Date gP_completeTime) {
		this.gP_completeTime = gP_completeTime;
	}

	public Integer getgP_stateId() {
		return gP_stateId;
	}

	public void setgP_stateId(Integer gP_stateId) {
		this.gP_stateId = gP_stateId;
	}

	public Groupon getGroupon() {
		return groupon;
	}

	public void setGroupon(Groupon groupon) {
		this.groupon = groupon;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Set<Images> getImages() {
		return images;
	}

	public void setImages(Set<Images> images) {
		this.images = images;
	}

}
