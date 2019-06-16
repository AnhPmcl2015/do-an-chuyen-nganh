package theanh.topjob.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	private String id;
	private String categoryName;
	private String categoryUnit;

	public Category(String id, String categoryName, String categoryUnit) {
		this.categoryName = categoryName;
		this.categoryUnit = categoryUnit;
		this.id = id;
	}

	public Category() {
		super();
	}

	@Column(nullable = false, length = 50)
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(nullable = false)
	public String getCategoryUnit() {
		return categoryUnit;
	}

	public void setCategoryUnit(String categoryUnit) {
		this.categoryUnit = categoryUnit;
	}

	@Id
	@Column(unique = true, nullable = false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
