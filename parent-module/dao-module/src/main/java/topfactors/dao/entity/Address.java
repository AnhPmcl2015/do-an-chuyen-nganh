package topfactors.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import topfactors.common.base.DateAudit;

@Entity
@Table(name = "address", catalog = "topfactors")
public class Address extends DateAudit {

	private static final long serialVersionUID = 2892915312951759724L;
	private Long id;
	private AccountVerificationQueue accountVerificationQueue;
	private AppUser appUser;
	private Company company;
	private Nation nation;
	private String address;

	public Address() {
	}

	public Address(Nation nation, String address) {
		this.nation = nation;
		this.address = address;
	}

	public Address(AccountVerificationQueue accountVerificationQueue, AppUser appUser, Company company, Nation nation,
			String address) {
		this.accountVerificationQueue = accountVerificationQueue;
		this.appUser = appUser;
		this.company = company;
		this.nation = nation;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_verification_queue_id")
	public AccountVerificationQueue getAccountVerificationQueue() {
		return this.accountVerificationQueue;
	}

	public void setAccountVerificationQueue(AccountVerificationQueue accountVerificationQueue) {
		this.accountVerificationQueue = accountVerificationQueue;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public AppUser getAppUser() {
		return this.appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nation_id", nullable = false)
	public Nation getNation() {
		return this.nation;
	}

	public void setNation(Nation nation) {
		this.nation = nation;
	}

	@Column(name = "address", nullable = false, length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
