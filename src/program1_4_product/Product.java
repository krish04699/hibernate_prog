package program1_4_product;






import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.OptimisticLocking;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.annotations.OptimisticLockType;


@Entity
//@OptimisticLocking(type=OptimisticLockType.DIRTY)
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pid")
	protected int pid;
	
	@Column(name="pname")
	protected String pname;
	
	
	@Column(name="price")
	protected int price;
	
	
	
	public Product() {
	}
	
	public Product(int pid, String pname, int price) {
		super();
		this.pid=pid;
		this.pname = pname;
		

		this.price=price;
		
	}

	

public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

public static void main(String arg[])
{
	Product prd1=new Product();
prd1.setPid(100);
	prd1.setPname("Audi");
	
	prd1.setPrice(400000);
	
	System.out.println(prd1.pid);
	System.out.println(prd1.pname);
	System.out.println(prd1.price);
	
	
	Transaction transaction = null;
	try (Session session = Producthibernate.getSessionFactory().openSession()) {
		// start a transaction
		transaction = session.beginTransaction();
		// save the student object
		session.save(prd1);
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
