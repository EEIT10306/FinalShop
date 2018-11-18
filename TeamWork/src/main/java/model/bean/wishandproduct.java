package model.bean;

import java.util.Date;

import javax.persistence.Entity;

//@Entity
public class wishandproduct {
	
	private Integer m_id;
	
	private Integer p_id;
	
	private String w_title;
	
	private String w_context;
	
	private Integer d_id;
	
	private Date w_startDate;
	
	private Date w_endDate;

	private String wP_name;

	private Integer wP_amount;

	private Integer wP_priceBottom;

	private Integer wP_priceTop;

	public wishandproduct() {
		super();
	}

	public wishandproduct(Integer m_id, Integer p_id, String w_title, String w_context, Integer d_id, Date w_startDate,
			Date w_endDate, String wP_name, Integer wP_amount, Integer wP_priceBottom, Integer wP_priceTop) {
		super();
		this.m_id = m_id;
		this.p_id = p_id;
		this.w_title = w_title;
		this.w_context = w_context;
		this.d_id = d_id;
		this.w_startDate = w_startDate;
		this.w_endDate = w_endDate;
		this.wP_name = wP_name;
		this.wP_amount = wP_amount;
		this.wP_priceBottom = wP_priceBottom;
		this.wP_priceTop = wP_priceTop;
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

	public String getwP_name() {
		return wP_name;
	}

	public void setwP_name(String wP_name) {
		this.wP_name = wP_name;
	}

	public Integer getwP_amount() {
		return wP_amount;
	}

	public void setwP_amount(Integer wP_amount) {
		this.wP_amount = wP_amount;
	}

	public Integer getwP_priceBottom() {
		return wP_priceBottom;
	}

	public void setwP_priceBottom(Integer wP_priceBottom) {
		this.wP_priceBottom = wP_priceBottom;
	}

	public Integer getwP_priceTop() {
		return wP_priceTop;
	}

	public void setwP_priceTop(Integer wP_priceTop) {
		this.wP_priceTop = wP_priceTop;
	}


	
}
