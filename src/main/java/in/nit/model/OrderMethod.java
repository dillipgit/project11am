package in.nit.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ORDERMETHOD")
public class OrderMethod {
	
	@Id
	//@GeneratedValue
	@GeneratedValue(generator = "omidgen")
	@GenericGenerator(name = "omidgen",strategy = "increment")
	@Column(name = "MID")
	private Integer id;
	@Column(name = "MMODE")
	private String mode;
	@Column(name = "MCODE")
	private String code;
	@Column(name = "METHOD")
	private String orderType;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "omcbtab",
	                        joinColumns = @JoinColumn())
	@OrderColumn(name = "pos")
	@Column(name = "MACCEPT")
	private List<String> accept;
	
	@Column(name = "MDESC")
	private String desc;

	public OrderMethod() {
		System.out.println("OrderMethod.OrderMethod()");
	}

}
