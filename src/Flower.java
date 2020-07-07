

	
	

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.OptimisticLocking;

import Program1_3_employee.Employee;
import Program1_3_employee.Employeehibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.OptimisticLockType;


@Entity
//@OptimisticLocking(type=OptimisticLockType.DIRTY)
@Table(name="flower")
public class Flower {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fid")
	protected int fid;
	
	@Column(name="fname")
	protected String fname;
	
	@Column(name="color")
	protected String color;
	
	@Column(name="price")
	protected String price;
	
	
	
	public Flower() {
	}
	
	public Flower(int fid, String fname, String color , String price) {
		super();
		this.fid=fid;
		this.fname = fname;
		
		this.color=color;
		this.price=price;
		
	}

	

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
public static void main(String arg[])
{
	Flower flow1=new Flower();
	flow1.setFid(1);
	flow1.setFname("Jasmine");
	flow1.setColor("white");
	flow1.setPrice("40");
	
	System.out.println(flow1.fid);
	System.out.println(flow1.fname);
	System.out.println(flow1.color);
	System.out.println(flow1.price);
	
	
	Transaction transaction = null;
	try (Session session = Employeehibernate.getSessionFactory().openSession()) {
		// start a transaction
		transaction = session.beginTransaction();
		// save the student object
		session.save(flow1);
		// commit transaction
		transaction.commit();
		
	} catch (Exception e) {
		if (transaction != null) {
			transaction.rollback();
		}
		e.printStackTrace();
	}
}

}
