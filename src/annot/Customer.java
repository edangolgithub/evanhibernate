/**
 * 
 */
package annot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author edangol
 *
 */
@Entity
public class Customer
	{
		@Id
		@GeneratedValue
		@Column(name = "CustomerId")

		int CustomerId;
		@Column(name="CustomerName")
		String CustomerName;
	}
