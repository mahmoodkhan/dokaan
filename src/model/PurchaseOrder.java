package model;

import java.sql.Timestamp;
import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.DatastoreIdentity;
import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.ForeignKeyAction;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.Index;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable(identityType=IdentityType.DATASTORE)
@DatastoreIdentity(strategy=IdGeneratorStrategy.INCREMENT)
public class PurchaseOrder extends AbstractModel{

    @Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
    @PrimaryKey
	private long id;
	
	@Persistent
	@Column(name="billNumber", jdbcType="INTEGER", allowsNull="false")
	@Index(name="index_for_billNumber_in_PurchaseOrder", unique="true")
	private Integer billNumber;
	
	@Persistent
	private Date orderDate;
	
	@Persistent
	@Column(name="totalNumOfProducts", jdbcType="INTEGER")
	@Index(name="index_for_totalNumOfProducts_in_PurchaseOrder")
	private Integer totalNumOfProducts;
	
	@Persistent
	@Column(name="supplierId")
	@ForeignKey(name="fk_customer_in_PurchaseOrder", deleteAction=ForeignKeyAction.CASCADE, updateAction=ForeignKeyAction.CASCADE)
	private Supplier supplier;
	
	@Persistent
	@Index(name="index_for_isOrderCompleted_in_PurchaseOrder")
	private Boolean isOrderCompleted;
	
	@Persistent
	@Column(name="notes", jdbcType="VARCHAR", length=254)
	private String notes;
	
	@Persistent
	private Timestamp dateCreated;
	
	@Persistent
	private Timestamp dateModified;
	
	public PurchaseOrder(){
		super();
	}
	
	public PurchaseOrder(long id, Integer billNumber, Date orderDate,
			Integer totalNumOfProducts, Supplier supplier,
			Boolean isOrderCompleted, String notes,
			Timestamp dateCreated, Timestamp dateModified) {
		super();
		this.id = id;
		this.billNumber = billNumber;
		this.orderDate = orderDate;
		this.totalNumOfProducts = totalNumOfProducts;
		this.supplier = supplier;
		this.isOrderCompleted = isOrderCompleted;
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

	public Integer getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(Integer billNumber) {
		this.billNumber = billNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getTotalNumOfProducts() {
		return totalNumOfProducts;
	}

	public void setTotalNumOfProducts(Integer totalNumOfProducts) {
		this.totalNumOfProducts = totalNumOfProducts;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Boolean getIsOrderCompleted() {
		return isOrderCompleted;
	}

	public void setIsOrderCompleted(Boolean isOrderCompleted) {
		this.isOrderCompleted = isOrderCompleted;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
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
