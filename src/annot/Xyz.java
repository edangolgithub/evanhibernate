package annot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Xyz {
	
	@Id
	@GeneratedValue
	@Column(name="xyzid")
	int xyzid;
	@Column(name="name")
	String name;
	public int getXyzid() {
		return xyzid;
	}
	public void setXyzid(int xyzid) {
		this.xyzid = xyzid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
