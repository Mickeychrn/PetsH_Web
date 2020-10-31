package usyd.elec5619.petsh.service.imp;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import usyd.elec5619.petsh.domain.User;


public class UserServiceImpTest extends TestCase{
	
	private UserServiceImp usi;
	private List<User> users;
    private User user;
	public static Long user_Id = (long) 1;
    public static String fname = "afirstname";
    public static String lname = "alastname";
    public static String email = "aemail";
    public static String password = "apassword";
    public static int authority = 1;
    public static String photo = "aphoto";
    public static String bio ="abio";
	public static int count = 1;
	
	
	protected void setUp() throws Exception{
	     usi = new UserServiceImp ();  
	     users = new ArrayList<User>();
	       
	     User user = new User();
	     user.setFirstName(fname);
	     user.setLastName(lname);
	     user.setAuthority(authority);
	     user.seteMail(email);
	     user.setPassword(password);
	     user.setUserBio(bio);
	     user.setUserId(user_Id);
	     user.setUserPhoto(photo);

	     users.add(user);
	     //csi.addCommnet(User);
	     }
		
	public void testfindByUseId() {
		//List<User> Users = this.UserService.getUserById(userId);
		//csi = new UserServiceImp();
	    //assertEquals(1,csi.getUserById(User.getUserId()).size());
	     	 	 
	}
	
	
	public void testAddUser() {
		usi = new UserServiceImp();
		assertNull(user);
		//csi.addCommnet(User);
		assertEquals(count,users.size());
	}

}
