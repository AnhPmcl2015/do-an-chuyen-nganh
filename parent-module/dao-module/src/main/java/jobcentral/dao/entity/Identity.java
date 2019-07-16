package jobcentral.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "identity", catalog = "topfactors")
public class Identity implements java.io.Serializable {

	private static final long serialVersionUID = -1178699746486400587L;
	private long id;
	private AppUser appUser;
	private String number;
	private String image1;
	private String image2;
	private Set<AccountVerificationQueue> accountVerificationQueues = new HashSet<AccountVerificationQueue>(0);

	public Identity() {
	}

	public Identity(long id, AppUser appUser, String number, String image1, String image2) {
		this.id = id;
		this.appUser = appUser;
		this.number = number;
		this.image1 = image1;
		this.image2 = image2;
	}

	public Identity(long id, AppUser appUser, String number, String image1, String image2,
			Set<AccountVerificationQueue> accountVerificationQueues) {
		this.id = id;
		this.appUser = appUser;
		this.number = number;
		this.image1 = image1;
		this.image2 = image2;
		this.accountVerificationQueues = accountVerificationQueues;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@Column(name = "number", nullable = false, length = 20)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "image_1", nullable = false, length = 100)
	public String getImage1() {
		return this.image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	@Column(name = "image_2", nullable = false, length = 100)
	public String getImage2() {
		return this.image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "identity")
	public Set<AccountVerificationQueue> getAccountVerificationQueues() {
		return this.accountVerificationQueues;
	}

	public void setAccountVerificationQueues(Set<AccountVerificationQueue> accountVerificationQueues) {
		this.accountVerificationQueues = accountVerificationQueues;
	}

}
