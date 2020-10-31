package usyd.elec5619.petsh.domain;

import junit.framework.TestCase;

public class UserTest extends TestCase{
	
	private User user;
	
	protected void setUp() throws Exception {
		user = new User();
    }
	
	public void testSetAndGetUserId() {		
        assertNull(user.getUserId());        
        Long testUserId = (long) 12321;
        user.setUserId(testUserId);
        assertEquals(testUserId, user.getUserId());
    }
	
	
	public void testSetAndGetFirstName() {		
        assertNull(user.getFirstName());        
        String testFirstName = "aaa";
        user.setFirstName(testFirstName);
        assertEquals(testFirstName, user.getFirstName());
    }
	
	
	public void testSetAndGetLastName() {		
        assertNull(user.getLastName());        
        String testLastName = "aaa";
        user.setLastName(testLastName);
        assertEquals(testLastName, user.getLastName());
    }
	
	
	public void testSetAndGeteMail() {		
        assertNull(user.geteMail());        
        String testeMail = "aaa";
        user.seteMail(testeMail);
        assertEquals(testeMail, user.geteMail());
    }
	
	
	public void testSetAndGetPassword() {		
        assertNull(user.getPassword());        
        String testPassword = "aaa";
        user.setPassword(testPassword);
        assertEquals(testPassword, user.getPassword());
    }
	
	
	public void testSetAndGetAuthority() {		
        assertNull(user.getAuthority());        
        Integer testAuthority = 123;
        user.setAuthority(testAuthority);
        assertEquals(testAuthority, user.getAuthority());
    }
	
	public void testSetAndGetUserPhoto() {		
        assertNull(user.getUserPhoto());        
        String testUserPhoto = "aaa";
        user.setUserPhoto(testUserPhoto);
        assertEquals(testUserPhoto, user.getUserPhoto());
    }
	
	
	public void testSetAndGetUserBio() {		
        assertNull(user.getUserBio());        
        String testUserBio = "aaa";
        user.setUserBio(testUserBio);
        assertEquals(testUserBio, user.getUserBio());
    }

}
