package model;

import java.sql.Timestamp;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Index;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.INCREMENT)
public class Supplier extends AbstractModel{
	
    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	@PrimaryKey
	@Column(allowsNull="false")
	private long id;
	
	@Persistent
	@Column(name="name", jdbcType="VARCHAR", length=60)
	@Index(name="index_for_name_in_Supplier", unique="true")
	private String name;
	
	@Persistent
	@Column(name="address", jdbcType="VARCHAR", length=254)
	private String address;
	
	@Persistent
	@Column(name="phone", jdbcType="VARCHAR", length=40)
	private String phone;
	
	@Persistent
	@Column(name="email", jdbcType="VARCHAR", length=80)
	@Index(name="index_for_email_in_Supplier", unique="false")
	private String email;
	
	@Persistent
	@Column(name="notes", jdbcType="VARCHAR", length=254)	
	private String notes;
	
	@Persistent
	private Timestamp dateCreated;
	
	@Persistent
	private Timestamp dateModified;
	
	public Supplier(){
		super();
	}
	
	public Supplier(long id, String name, String address, String phone,
			String email, String notes, Timestamp dateCreated, Timestamp dateModified) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.notes = notes;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getNotes() {
		return notes;
	}
	
	public void setNotes(String notes){
		this.notes = notes;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateModified() {
		return dateModified;
	}

	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}
	
}
