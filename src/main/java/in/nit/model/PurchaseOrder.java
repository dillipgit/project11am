package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
//@Entity
@Table(name = "PURCHASEORDER_TAB")
public class PurchaseOrder {
	@Id
	@Column(name = "PID")
	@GeneratedValue(generator = "PURCHASEORDERID")
	@GenericGenerator(name = "PURCHASEORDERID",
	                                                          strategy = "increment")
	private Integer pId;
	@Column(name = "PID")
	private String pCode;
	@Column(name = "RNO")
	private String rNo;
	@Column(name = "QCHECK")
	private String qualityCheck;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "DESC")
	private String desc;
	
	public PurchaseOrder() {
	}
}
