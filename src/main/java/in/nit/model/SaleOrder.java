package in.nit.model;

import java.io.Serializable;

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
@Table
public class SaleOrder implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "SALEGEN")
	@GenericGenerator(name = "SALEGEN", strategy = "increment")
	private Integer orderld;
	private String orderCode;
	private Integer refNo;
	private String stockMode;
	private String stockSource;
	private String status;
	private String note;
	
	@ManyToOne
	@JoinColumn(name = "shipCodeFK")
	private ShipmentType shipCode;

	public SaleOrder(Integer orderld) {
		this.orderld = orderld;

	}

}
