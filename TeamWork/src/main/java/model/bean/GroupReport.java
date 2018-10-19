package model.bean;

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
@Table(name = "GroupReport")
public class GroupReport {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "gR_ID", columnDefinition = "int")
	Integer id;
	 
	@Column(name = "gR_cont", columnDefinition = "nvarchar(max)")
	String content;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gProd_ID", insertable = false, updatable = false)
	GroupProduct groupProduct;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "mem_ID", insertable = false, updatable = false)
	Member member;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "gR_state", insertable = false, updatable = false)
	GroupReport groupReport;

	public GroupReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GroupReport(Integer id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	@Override
	public String toString() {
		return "GroupReport [id=" + id + ", content=" + content + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public GroupProduct getGroupProduct() {
		return groupProduct;
	}

	public void setGroupProduct(GroupProduct groupProduct) {
		this.groupProduct = groupProduct;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public GroupReport getGroupReport() {
		return groupReport;
	}

	public void setGroupReport(GroupReport groupReport) {
		this.groupReport = groupReport;
	}

	

				
}
