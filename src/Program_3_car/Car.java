package Program_3_car;






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
@Table(name="car")
public class Car {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="regno")
	protected String regno;
	
	@Column(name="model")
	protected String model;
	
	@Column(name="color")
	protected String color;
	
	@Column(name="manu")
	protected String manu;
	
	
	
	public Car() {
	}
	
	public Car(String regno, String model, String color , String manu) {
		super();
		this.regno=regno;
		this.model = model;
		
		this.color=color;
		this.manu=manu;
		
	}

	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getManu() {
		return manu;
	}

	public void setManu(String manu) {
		this.manu = manu;
	}

	public static void main(String arg[])
{
	Car c1=new Car();
c1.setRegno("TN59 Q 5555");
c1.setModel("Swift ");
c1.setColor("Grey");
c1.setManu("maruthi");
	System.out.println(c1.regno);
	System.out.println(c1.model);
	System.out.println(c1.color);
	System.out.println(c1.manu);
	
	
	Transaction transaction = null;
	try (Session session = Carhibernate.getSessionFactory().openSession()) {
		// start a transaction
		transaction = session.beginTransaction();
		// save the student object
		session.save(c1);
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
