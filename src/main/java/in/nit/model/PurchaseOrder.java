package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
@Entity
@Table
public class PurchaseOrder {
	@Id
	@Column(name = "iddVal")
	@GeneratedValue(generator = "PURCHASEORDERID")
	@GenericGenerator(name = "PURCHASEORDERID", strategy = "increment")
	private Integer iddVal;
	
	@Column(name = "pCode")
	private String pCode;
	
	@Column(name = "rNo")
	private String rNo;
	
	@Column(name = "qualityCheck")
	private String qualityCheck;
	
	@Column(name = "dStatus")
	private String dStatus;
	
	@Column(name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "shipTypeFK")
	private ShipmentType shipObj;
	
	@ManyToOne
	@JoinColumn(name = "whUserFK")
	private WhUserTypeModel whUserObj;

	public PurchaseOrder(Integer iddVal) {
		this.iddVal = iddVal;
	}

}
