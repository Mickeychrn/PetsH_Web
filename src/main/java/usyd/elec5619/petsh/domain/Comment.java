package usyd.elec5619.petsh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Comment")
public class Comment implements Serializable{
	
	
	@Id
	@GeneratedValue
	@Column(name="commentId")
	private Long commentId;
	
	@Column(name="forumId")
	private Long forumId;
	
	@Column(name="userId")
	private Long userId;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="commentDate")
	private String commentDate;
	
	@Column(name="content")
	private String content;
	
	@Column(name="userURL")
	private String userURL;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getForumId() {
		return forumId;
	}

	public void setForumId(Long forumId) {
		this.forumId = forumId;
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

	public String getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
	

	public String getUserURL() {
		return userURL;
	}

	public void setUserURL(String userURL) {
		this.userURL = userURL;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", forumId=" + forumId + ", userId=" + userId + ", userName="
				+ userName + ", commentDate=" + commentDate + ", content=" + content + "]";
	}

	

}