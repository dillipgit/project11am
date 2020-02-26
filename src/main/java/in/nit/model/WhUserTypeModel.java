package in.nit.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "WhUserTypeTable")
public class WhUserTypeModel {
	@Id
	@GeneratedValue
	@Column(name = "USERID")
	private Integer userId;
	
	@Column(name = "USERTYPE1")
	private String   userType;
	
	@Column(name = "USERCODE")
	private String   userCode;
	
	@Column(name = "USERFOR")
	private String   userFor;
	
	@Column(name = "USEEMAIL")
	private String   email;
	
	@Column(name = "USERCONTACT")
	private String   contact;
	
	@Column(name = "USERTYPE")
	private String   userIdType;
	
	@Column(name = "OTHER")
	private String   other;
	
	@Column(name = "IDNUMBER")
	private String   id;

}
