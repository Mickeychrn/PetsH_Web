package usyd.elec5619.petsh.domain;

import junit.framework.TestCase;

public class CommentTest extends TestCase {
	
	private Comment comment;
	
	protected void setUp() throws Exception {
        comment = new Comment();
    }
	
	public void testSetAndGetCommentId() {		
        assertNull(comment.getCommentId());     
        Long testCommentId = (long) 123;
        comment.setCommentId(testCommentId);
        assertEquals(testCommentId, comment.getCommentId());
    }
	
	
	public void testSetAndGetForumId() {		
        assertNull(comment.getForumId());        
        Long testForumId = (long) 12321;
        comment.setForumId(testForumId);
        assertEquals(testForumId, comment.getForumId());
    }
	
	
	public void testSetAndGetUserId() {		
        assertNull(comment.getUserId());        
        Long testUserId = (long) 12321;
        comment.setUserId(testUserId);
        assertEquals(testUserId, comment.getUserId());
    }
	
	
	public void testSetAndGetUserName() {		
        assertNull(comment.getUserName());        
        String testUserName = "aaa";
        comment.setUserName(testUserName);
        assertEquals(testUserName, comment.getUserName());
    }

	public void testSetAndGetCommentDate() {		
        assertNull(comment.getCommentDate());        
        String testCommentDate = "BBB";
        comment.setCommentDate(testCommentDate);
        assertEquals(testCommentDate, comment.getCommentDate());
    }

	
	public void testSetAndGetContent() {		
        assertNull(comment.getContent());        
        String testContent = "BBB";
        comment.setContent(testContent);
        assertEquals(testContent, comment.getContent());
    }
	
	public void testSetAndGetUserURL() {		
        assertNull(comment.getUserURL());        
        String testUserURL = "BBB";
        comment.setUserURL(testUserURL);
        assertEquals(testUserURL, comment.getUserURL());
    }


}
