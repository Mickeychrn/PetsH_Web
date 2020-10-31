package usyd.elec5619.petsh.domain;

import junit.framework.TestCase;

public class ForumTest extends TestCase{
	
	private Forum forum;
	
	protected void setUp() throws Exception {
        forum = new Forum();
    }
	
	public void testSetAndGetForumId() {		
        assertNull(forum.getForumId());        
        Long testForumId = (long) 12321;
        forum.setForumId(testForumId);
        assertEquals(testForumId, forum.getForumId());
    }
	
	
	public void testSetAndGetForumTitle() {		
        assertNull(forum.getForumTitle());        
        String testForumTitle = "BBB";
        forum.setForumTitle(testForumTitle);
        assertEquals(testForumTitle, forum.getForumTitle());
    }
	
	
	public void testSetAndGetForumContent() {		
        assertNull(forum.getForumContent());        
        String testForumContent = "BBB";
        forum.setForumContent(testForumContent);
        assertEquals(testForumContent, forum.getForumContent());
    }
	
	
	public void testSetAndGetCreateTime() {		
        assertNull(forum.getCreateTime());        
        String testCreateTime = "BBB";
        forum.setCreateTime(testCreateTime);
        assertEquals(testCreateTime, forum.getCreateTime());
    }
	
	
	public void testSetAndGetUserId() {		
        assertNull(forum.getUserId());        
        Long testUserId = (long) 12321;
        forum.setUserId(testUserId);
        assertEquals(testUserId, forum.getUserId());
    }
	
	
	public void testSetAndGetUserName() {		
        assertNull(forum.getUserName());        
        String testUserName = "aaa";
        forum.setUserName(testUserName);
        assertEquals(testUserName, forum.getUserName());
    }

}
