package model;

import java.sql.Timestamp;
import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Index;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import utilities.Validator;
import controller.CustomerController;

@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.INCREMENT)
public class Customer extends AbstractModel{
	
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	@PrimaryKey
	private long id;
	
	@Persistent
	@Column(name="name", jdbcType="VARCHAR", length=60)
	@Index(name="index_for_name_in_Customer")
	private String name;
	
	@Persistent
	@Column(name="email", jdbcType="VARCHAR", length=80)
	@Index(name="index_for_email_in_Customer", unique="false")
	private String email;
	
	@Persistent
	@Column(name="phone", jdbcType="VARCHAR", length=40)
	@Index(name="index_for_phone_in_Customer", unique="false")
	private String phone;
	
	@Persistent
	@Column(name="address", jdbcType="VARCHAR", length=254)
	private String address;
	
	@Persistent
	@Column(name="notes", jdbcType="VARCHAR", length=254)	
	private String notes;
	
	@Persistent
	private Date dateCreated;
	
	@Persistent
	private Timestamp dateModified;

	
	public Customer(){
		super();
	}
	
	public Customer(long id, String name, String phone, String address,
			String notes, String email,
			Date dateCreated, Timestamp dateModified) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.notes = notes;
		this.email = email;
		this.dateCreated = dateCreated;
		this.dateModified = dateModified;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
	    long oldId = this.id;
		this.id = id;
		firePropertyChange(CustomerController.ELEMENT_ID_PROPERTY, oldId, id);
	}

	public String getName() {
		return name;
	}

	public boolean setName(String name) {
	    if (Validator.isBlankOrNull(name)){
	        return false;
	    }
	    if (!Validator.isAlphaSpace(name)){
	        return false;
	    }
	    String oldName = this.name;
		this.name = name;
		firePropertyChange(CustomerController.ELEMENT_NAME_PROPERTY, oldName, name);
		return true;
	}

	public String getEmail(){
		return email;
	}
	
	public boolean setEmail(String email) {
		if (Validator.isBlankOrNull(email)){
            return false;
        }
	    String oldEmail = this.email;
		this.email = email;
		firePropertyChange(CustomerController.ELEMENT_EMAIL_PROPERTY, oldEmail, email);
		return true;
	}
	
	
	public String getPhone() {
		return phone;
	}

	public boolean setPhone(String phone) {
	    if (Validator.isBlankOrNull(phone)){
            return false;
        }
	    String oldPhone = this.phone;
		this.phone = phone;
		firePropertyChange(CustomerController.ELEMENT_PHONE_PROPERTY, oldPhone, phone);
		return true;
	}

	public String getAddress() {
		return address;
	}

	public boolean setAddress(String address) {
	    if (Validator.isBlankOrNull(address)){
            return false;
        }
	    String oldAddress = this.address;
		this.address = address;
		firePropertyChange(CustomerController.ELEMENT_ADDRESS_PROPERTY, oldAddress, address);
		return true;
	}
	
	public String getNotes() {
		return notes;
	}

	public boolean setNotes(String notes) {
	    if (Validator.isBlankOrNull(notes)){
            return false;
        }
	    String oldNotes = this.notes;
		this.notes = notes;
		firePropertyChange(CustomerController.ELEMENT_NOTES_PROPERTY, oldNotes, notes);
		return true;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Timestamp getDateModified() {
		return dateModified;
	}

	public void setDateModified(Timestamp dateModified) {
		this.dateModified = dateModified;
	}
	

}
