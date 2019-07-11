package annot;

import javax.persistence.*;  

@Entity  
@Table(name="stu400")  
public class Student {   
@Id  
@GeneratedValue(strategy=GenerationType.AUTO)    
private int id;    
private String sname;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}    

}