package model.bean;

import java.util.Date;
import java.util.LinkedHashSet;
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
public class Wish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wish_ID", columnDefinition = "int", nullable = false)
	private Integer w_id;

	@Column(name = "memW_ID", columnDefinition = "int", nullable = false)
	private Integer m_id;

	@Column(name = "prod_ID", columnDefinition = "int", nullable = false)
	private Integer p_id;

	@Column(name = "wish_title", columnDefinition = "nvarchar(Max)", nullable = false)
	private String w_title;

	@Column(name = "wish_cont", columnDefinition = "nvarchar(Max)", nullable = false)
	private String w_context;

	@Column(name = "dist_ID", columnDefinition = "int", nullable = false)
	private Integer d_id;

	@Column(name = "wish_sDate", columnDefinition = "datetime", nullable = false)
	private Date w_startDate;

	@Column(name = "wish_eDate", columnDefinition = "datetime", nullable = false)
	private Date w_endDate;

	@Column(name = "wish_sumPriBot", columnDefinition = "int")
	private Integer w_sumPriceBottom;

	@Column(name = "wish_sumPriTop", columnDefinition = "int")
	private Integer w_sumPriceTop;

	@Column(name = "wish_chanTime", columnDefinition = "datetime", nullable = false)
	private Date w_changeTime;

	@Column(name = "wish_hot", columnDefinition = "int", nullable = false)
	private Integer w_hot;

	@Column(name = "wish_amtFav", columnDefinition = "int", nullable = false)
	private Integer w_amountFavorite;

	@Column(name = "wish_compTime", columnDefinition = "datetime")
	private Date w_completeTime;

	@Column(name = "wish_state", columnDefinition = "int", nullable = false)
	private Integer w_stateId;

	@ManyToOne
	@JoinColumn(name = "memW_ID", insertable = false, updatable = false)
	private Member member;

	@ManyToOne
	@JoinColumn(name = "prod_ID", insertable = false, updatable = false)
	private Product product;

	@ManyToOne
	@JoinColumn(name = "dist_ID", insertable = false, updatable = false)
	private DistrictType districtType;

	@ManyToOne
	@JoinColumn(name = "wish_state", insertable = false, updatable = false)
	private State state;
	
	@OneToMany(mappedBy = "w_id")
	private Set<WishProduct> wishProduct = new LinkedHashSet<>();

	public Wish() {
	}

	public Wish(Integer w_id, Integer m_id, Integer p_id, String w_title, String w_context, Integer d_id,
			Date w_startDate, Date w_endDate, Integer w_sumPriceBottom, Integer w_sumPriceTop, Date w_changeTime,
			Integer w_hot, Integer w_amountFavorite, Date w_completeTime, Integer w_stateId) {
		super();
		this.w_id = w_id;
		this.m_id = m_id;
		this.p_id = p_id;
		this.w_title = w_title;
		this.w_context = w_context;
		this.d_id = d_id;
		this.w_startDate = w_startDate;
		this.w_endDate = w_endDate;
		this.w_sumPriceBottom = w_sumPriceBottom;
		this.w_sumPriceTop = w_sumPriceTop;
		this.w_changeTime = w_changeTime;
		this.w_hot = w_hot;
		this.w_amountFavorite = w_amountFavorite;
		this.w_completeTime = w_completeTime;
		this.w_stateId = w_stateId;
	}

	@Override
	public String toString() {
		return "Wish [w_id=" + w_id + ", m_id=" + m_id + ", p_id=" + p_id + ", w_title=" + w_title + ", w_context="
				+ w_context + ", d_id=" + d_id + ", w_startDate=" + w_startDate + ", w_endDate=" + w_endDate
				+ ", w_sumPriceBottom=" + w_sumPriceBottom + ", w_sumPriceTop=" + w_sumPriceTop + ", w_changeTime="
				+ w_changeTime + ", w_hot=" + w_hot + ", w_amountFavorite=" + w_amountFavorite + ", w_completeTime="
				+ w_completeTime + ", w_stateId=" + w_stateId + ", wishProduct=" + wishProduct + "]\r\n";
	}

	public Integer getW_id() {
		return w_id;
	}

	public void setW_id(Integer w_id) {
		this.w_id = w_id;
	}

	public Integer getM_id() {
		return m_id;
	}

	public void setM_id(Integer m_id) {
		this.m_id = m_id;
	}

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getW_title() {
		return w_title;
	}

	public void setW_title(String w_title) {
		this.w_title = w_title;
	}

	public String getW_context() {
		return w_context;
	}

	public void setW_context(String w_context) {
		this.w_context = w_context;
	}

	public Integer getD_id() {
		return d_id;
	}

	public void setD_id(Integer d_id) {
		this.d_id = d_id;
	}

	public Date getW_startDate() {
		return w_startDate;
	}

	public void setW_startDate(Date w_startDate) {
		this.w_startDate = w_startDate;
	}

	public Date getW_endDate() {
		return w_endDate;
	}

	public void setW_endDate(Date w_endDate) {
		this.w_endDate = w_endDate;
	}

	public Integer getW_sumPriceBottom() {
		return w_sumPriceBottom;
	}

	public void setW_sumPriceBottom(Integer w_sumPriceBottom) {
		this.w_sumPriceBottom = w_sumPriceBottom;
	}

	public Integer getW_sumPriceTop() {
		return w_sumPriceTop;
	}

	public void setW_sumPriceTop(Integer w_sumPriceTop) {
		this.w_sumPriceTop = w_sumPriceTop;
	}

	public Date getW_changeTime() {
		return w_changeTime;
	}

	public void setW_changeTime(Date w_changeTime) {
		this.w_changeTime = w_changeTime;
	}

	public Integer getW_hot() {
		return w_hot;
	}

	public void setW_hot(Integer w_hot) {
		this.w_hot = w_hot;
	}

	public Integer getW_amountFavorite() {
		return w_amountFavorite;
	}

	public void setW_amountFavorite(Integer w_amountFavorite) {
		this.w_amountFavorite = w_amountFavorite;
	}

	public Date getW_completeTime() {
		return w_completeTime;
	}

	public void setW_completeTime(Date w_completeTime) {
		this.w_completeTime = w_completeTime;
	}

	public Integer getW_stateId() {
		return w_stateId;
	}

	public void setW_stateId(Integer w_stateId) {
		this.w_stateId = w_stateId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public DistrictType getDistrictType() {
		return districtType;
	}

	public void setDistrictType(DistrictType districtType) {
		this.districtType = districtType;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Set<WishProduct> getWishProduct() {
		return wishProduct;
	}

	public void setWishProduct(Set<WishProduct> wishProduct) {
		this.wishProduct = wishProduct;
	}

}
