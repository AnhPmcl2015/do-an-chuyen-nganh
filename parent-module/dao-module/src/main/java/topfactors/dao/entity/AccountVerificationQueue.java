package topfactors.dao.entity;

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

import topfactors.common.base.UserDateAudit;
@Entity
@Table(name = "account_verification_queue", catalog = "topfactors")
public class AccountVerificationQueue extends UserDateAudit {

	private static final long serialVersionUID = 547926110843665043L;
	private long id;
	private AppUser appUser;
	private Identity identity;
	private String email;
	private String phoneNumber;
	private Set<Address> addresses = new HashSet<Address>(0);

	public AccountVerificationQueue() {
	}

	public AccountVerificationQueue(long id, AppUser appUser, Identity identity, String email, String phoneNumber) {
		this.id = id;
		this.appUser = appUser;
		this.identity = identity;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public AccountVerificationQueue(long id, AppUser appUser, Identity identity, String email, String phoneNumber,
			Set<Address> addresses) {
		this.id = id;
		this.appUser = appUser;
		this.identity = identity;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.addresses = addresses;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "identity_id", nullable = false)
	public Identity getIdentity() {
		return this.identity;
	}

	public void setIdentity(Identity identity) {
		this.identity = identity;
	}

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone_number", nullable = false, length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "accountVerificationQueue")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
