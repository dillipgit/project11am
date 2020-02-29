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
@Entity
@Table(name = "PART")
public class Part  {

	@Id
	@GeneratedValue(generator = "partge1")
	@GenericGenerator(name = "partgen1", strategy = "increment")
	@Column(name = "PARID")
	private Integer parId;
	@Column(name = "CODE")
	private String prtCode;
	@Column(name = "WEIDTH")
	private String prtWidth;
	@Column(name = "LENGTH")
	private String prtLength;
	@Column(name = "HEIGHT")
	private String prtHeight;
	@Column(name = "COST")
	private String prtCost;
	@Column(name = "CURRENCY")
	private String prtCurrency;
	@Column(name = "NOTE")
	private String prtDescription;

	public Part() {
	}

}
