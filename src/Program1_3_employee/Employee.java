package Program1_3_employee;




import org.hibernate.Session;
import org.hibernate.Transaction;


	

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import org.hibernate.annotations.OptimisticLocking;
//import org.hibernate.annotations.OptimisticLockType;

import org.hibernate.Session;
import org.hibernate.Transaction;




@Entity
//@OptimisticLocking(type=OptimisticLockType.DIRTY)
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	protected int id;
	
	@Column(name="name")
	protected String name;
	
	@Column(name="desi")
	protected String desi;
	
	@Column(name="salary")
	protected String salary;
	
	
	
	public Employee() {
	}
	
	public Employee( String name, String desi , String salary) {
		super();
		
		this.name = name;
		
		this.desi=desi;
		this.salary=salary;
		
	}

	public Employee(int id, String name, String desi, String salary) {
		super();
		this.id=id;
		this.name = name;
		
		this.desi=desi;
		this.salary=salary;
		
	
	}

	
public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesi() {
		return desi;
	}

	public void setDesi(String desi) {
		this.desi = desi;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

public static void main(String arg[])
{
	Employee emp1=new Employee();
	emp1.setName("krishna");
	emp1.setDesi("tranie");
	emp1.setSalary("25000");
	
	System.out.println(emp1.id);
	System.out.println(emp1.name);
	System.out.println(emp1.desi);
	System.out.println(emp1.salary);
	
	
	Transaction transaction = null;
	try (Session session = Employeehibernate.getSessionFactory().openSession()) {
		// start a transaction
		transaction = session.beginTransaction();
		// save the student object
		session.save(emp1);
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


