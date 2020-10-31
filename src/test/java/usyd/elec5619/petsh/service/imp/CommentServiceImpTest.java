package usyd.elec5619.petsh.service.imp;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import usyd.elec5619.petsh.domain.Comment;

public class CommentServiceImpTest extends TestCase{
	//private CommentServiceImp csi;
	private List<Comment> comments;
    private Comment comment;
	public static Long co_Id = (long) 1;
	public static String time = "2020-10-29 22:24:05";
	public static Long forum_id = (long)2;
	public static Long user_id = (long)3;
	public static String content = "acontent";
	public static String name = "aname";
	public static int count = 1;
	
	
	protected void setUp() throws Exception{
	//     csi = new CommentServiceImp ();  
	     comments = new ArrayList<Comment>();
	       
	     Comment comment = new Comment();
	     comment.setCommentId(co_Id);
	     comment.setCommentDate(time);
	     comment.setContent(content);
	     comment.setForumId(forum_id);
	     comment.setUserId(user_id);
	     comment.setUserName(name);
	     comments.add(comment);
	     //csi.addCommnet(comment);
	     }
		
	public void testfindByUseId() {
		//List<Comment> comments = this.commentService.getCommentById(forumId);
		//csi = new CommentServiceImp();
	    //assertEquals(1,csi.getCommentById(comment.getForumId()).size());
	     	 	 
	}
	
	
	public void testAddComment() {
	//	csi = new CommentServiceImp();
		assertNull(comment);
		//csi.addCommnet(comment);
		assertEquals(count,comments.size());
	}

}



