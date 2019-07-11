package annot;

import javax.persistence.*;  
import java.util.List;    
  
@Entity  
@Table(name="s400")  
public class Address {    
  
@Id   
@GeneratedValue(strategy=GenerationType.AUTO)  
private int id;    
private String city;    
  
@OneToMany(cascade = CascadeType.ALL)  
@JoinColumn(name="qid")  
@OrderColumn(name="type")  
private List<Student> slist;  
public int getId() {  
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  

public List<Student> getSlist() {  
    return slist;  
}  
public void setSlist(List<Student> slist) {  
    this.slist = slist;  
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}      
}  