package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "UOM")
public class UOM {
	@Id
	@GeneratedValue
	@Column(name = "IDNO")
	private Integer id;
	
	@Column(name = "UTYPE")
	private String umoType;
	
	@Column(name = "UMODEL")
	private String umoModel;
	
	@Column(name = "UDESC")
	private String desc;
	
	
}
