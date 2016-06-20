package guice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="company")
public class MyEntity {

	@Id
	@Column(name = "Id")
	private int id;
	
	@Column(name="Name")
	private String name;

	@Column(name="age")
	private int age;
	
	@Column(name="address")
	private String address;
	
	@Column(name = "salary")
	private int salary;
	
	public MyEntity(int id, String name,int age,String address,int salary) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.salary = salary;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
}
