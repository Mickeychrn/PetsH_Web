package usyd.elec5619.petsh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Forum")
public class Forum implements Serializable {
	
	
	@Id
	@GeneratedValue
	@Column(name="forumId")
	private Long forumId;

	
	@Column(name = "forumTitle")
	private String forumTitle;
	
	
	@Column(name = "forumContent")
	private String forumContent;
	
	@Column(name = "createTime")
	private String createTime;
	
	
	@Column(name="userId")
	private Long userId;
	
	@Column(name="userName")
	private String userName;

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
	}

	public String getForumTitle() {
		return forumTitle;
	}

	public void setForumTitle(String forumTitle) {
		this.forumTitle = forumTitle;
	}

	public String getForumContent() {
		return forumContent;
	}

	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}
	
	

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Forum [forumId=" + forumId + ", forumTitle=" + forumTitle + ", forumContent=" + forumContent
				+ ", userId=" + userId + "]";
	}


}