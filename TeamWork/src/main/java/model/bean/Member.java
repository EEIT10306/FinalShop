//package model.bean;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Member")
//public class Member {
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "mem_ID", columnDefinition = "int")
//	Integer id;
//	@Column(name = "mem_acc", columnDefinition = "nvarchar(MAX)")
//	String account;
//	@Column(name = "mem_pass", columnDefinition = "varbinary(MAX)")
//	Byte[] password;
//	@Column(name = "mem_name", columnDefinition = "nvarchar(MAX)")
//	String name;
//	@Column(name = "mem_add", columnDefinition = "nvarchar(MAX)")
//	String add;
//	@Column(name = "mem_tel", columnDefinition = "nvarchar(MAX)")
//	String name;
//	@Column(name = "mem_mail", columnDefinition = "nvarchar(MAX)")
//	String name;
//	@Column(name = "mem_pos", columnDefinition = "nvarchar(MAX)")
//	String name;
//	@Column(name = "mem_coin", columnDefinition = "nvarchar(MAX)")
//	String name;
//	@Column(name = "mem_pho", columnDefinition = "nvarchar(MAX)")
//	String name;
//
//	@Override
//	public String toString() {
//		return "AchievementBean [id=" + id + ", context=" + context + ", bouns=" + bouns + ", parentsId=" + parentsId
//				+ "]";
//	}
//
//	public Member() {
//	};
//
//	public Member(Integer id, String context, Integer bouns, Integer parentsId) {
//		this.id = id;
//		this.context = context;
//		this.bouns = bouns;
//		this.parentsId = parentsId;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public String getContext() {
//		return context;
//	}
//
//	public void setContext(String context) {
//		this.context = context;
//	}
//
//	public Integer getBouns() {
//		return bouns;
//	}
//
//	public void setBouns(Integer bouns) {
//		this.bouns = bouns;
//	}
//
//	public Integer getParentsId() {
//		return parentsId;
//	}
//
//	public void setParentsId(Integer parentsId) {
//		this.parentsId = parentsId;
//	}
//}
