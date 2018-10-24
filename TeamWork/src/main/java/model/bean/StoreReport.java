package model.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "StoreReport")
public class StoreReport {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sR_ID", columnDefinition = "int")
	Integer srid;
	
	String context;
	
	Integer spid;
	
	Integer memid;
	
	Integer state;
	
}
