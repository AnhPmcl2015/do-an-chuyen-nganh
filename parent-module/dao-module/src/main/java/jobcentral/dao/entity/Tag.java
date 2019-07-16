package jobcentral.dao.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tag", catalog = "topfactors")
public class Tag implements java.io.Serializable {
	private static final long serialVersionUID = -948293987675802636L;
	private Long id;
	private String tagName;
	private String tagUrl;
	private Set<RecruitmentPost> recruitmentPosts = new HashSet<RecruitmentPost>(0);

	public Tag() {
	}

	public Tag(String tagName, String tagUrl, Set<RecruitmentPost> recruitmentPosts) {
		this.tagName = tagName;
		this.tagUrl = tagUrl;
		this.recruitmentPosts = recruitmentPosts;
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

	@Column(name = "tag_name", length = 50)
	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	@Column(name = "tag_url", length = 50)
	public String getTagUrl() {
		return this.tagUrl;
	}

	public void setTagUrl(String tagUrl) {
		this.tagUrl = tagUrl;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recruitment_post_tag", catalog = "topfactors", joinColumns = {
			@JoinColumn(name = "tag_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "recruitment_post_id", nullable = false, updatable = false) })
	public Set<RecruitmentPost> getRecruitmentPosts() {
		return this.recruitmentPosts;
	}

	public void setRecruitmentPosts(Set<RecruitmentPost> recruitmentPosts) {
		this.recruitmentPosts = recruitmentPosts;
	}

}
