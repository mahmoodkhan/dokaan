package model;

import java.io.Serializable;
import java.util.StringTokenizer;

import javax.jdo.identity.IntIdentity;

/**
* This class is used to serve as a composite key for the ProductOrder
* model class using JDO annotation for persistence.
*
* @author Mahmood Khan
* @version 2012-02-29 1.0
*
*/
public class ComposedIdKey implements Serializable {
	
	/**
	 * This has to do with serialization. It is not important, but is placed
	 * here to prevent a compiler warning.
	 */
	private static final long serialVersionUID = 1L;

	public IntIdentity product;
	public IntIdentity purchaseOrder;

	public ComposedIdKey() {
	}

	public ComposedIdKey(String s) {
		StringTokenizer st = new StringTokenizer(s, "::");
		this.product = new IntIdentity(Product.class, st.nextToken());
		this.purchaseOrder = new IntIdentity(PurchaseOrder.class, st.nextToken());
	}

	public String toString() {
		return (product.toString() + "::" + purchaseOrder.toString());
	}

	public int hashCode() {
		return product.hashCode() ^ purchaseOrder.hashCode();
	}

	public boolean equals(Object other) {
		if (other != null && (other instanceof ComposedIdKey)) {
			ComposedIdKey otherPK = (ComposedIdKey) other;
			return this.product.equals(otherPK.product)
					&& this.purchaseOrder.equals(otherPK.purchaseOrder);
		}
		return false;
	}
}