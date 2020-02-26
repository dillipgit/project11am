package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "SHIPMENTTYPE")
public class ShipmentType {
	@Id
	@Column(name = "SHIP_ID")
	@GeneratedValue
	private Integer shipId;
	@Column(name = "SHIP_MODE")
	private String shipMode;
	@Column(name = "SHIP_CODE")
	private String shipCode;
	@Column(name = "SHIP_ENB")
	private String enbShip;
	@Column(name = "SHIP_GRADE")
	private String shipGrade;
	@Column(name = "SHIP_DESC")
	private String shipDesc;
	
	public ShipmentType(Integer shipId) {
		this.shipId = shipId;
	}
	public ShipmentType() {
		
	}
	
	

}
