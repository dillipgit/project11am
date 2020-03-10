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
@ToString
@NoArgsConstructor
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
	private Double prtWidth;
	@Column(name = "LENGTH")
	private Double prtLength;
	@Column(name = "HEIGHT")
	private Double prtHeight;
	@Column(name = "COST")
	private Double prtCost;
	@Column(name = "CURRENCY")
	private String prtCurrency;
	@Column(name = "NOTE")
	private String prtDescription;
	
	@ManyToOne
	@JoinColumn(name = "uomIdFK")
	private UOM uomOb;
	
	@ManyToOne
	@JoinColumn(name = "omIdFK")
	private OrderMethod omSaleOb;

	@ManyToOne
	@JoinColumn(name = "omPIdFK")
	private OrderMethod omPurchaseOb;

}
