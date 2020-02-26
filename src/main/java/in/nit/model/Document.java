package in.nit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "DOCUMENT")
public class Document {
	@Id
	@Column(name = "fId")
	private Integer fileId;
	@Column(name = "fName")
	private String filename;

	@Lob
	@Column(name = "fData")
	private byte[] fileData;

	public Document() {
	}
}
