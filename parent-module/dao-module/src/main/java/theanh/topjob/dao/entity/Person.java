package theanh.topjob.dao.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person {


	private String id;
	private String fullname;
	private LocalDate dateOfBirth;

	public Person() {
		super();
	}

	public Person(String id, String fullname, LocalDate dateOfBirth) {
		this.id = id;
		this.fullname = fullname;
		this.dateOfBirth = dateOfBirth;
	}

	@Column(nullable = false, length = 50)
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(nullable = false)
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Id
	@Column(nullable=false, unique = true)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
