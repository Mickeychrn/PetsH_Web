package usyd.elec5619.petsh.service.imp;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import usyd.elec5619.petsh.domain.Forum;

public class ForumServiceImpTest extends TestCase{
	private ForumServiceImp fsi;
	private List<Forum> forums;
    private Forum forum;
	public static Long fo_Id = (long) 1;
	public static String time = "2020-10-29 22:24:05";
	public static Long forum_id = (long)2;
	public static Long user_id = (long)3;
	public static String name = "aname";
	public static int count = 1;
	
	
	protected void setUp() throws Exception{
	     fsi = new ForumServiceImp ();  
	     forums = new ArrayList<Forum>();
	       
	     Forum Forum = new Forum();
	     Forum.setForumId(fo_Id);
	     Forum.setCreateTime(time);
	     Forum.setForumId(forum_id);
	     Forum.setUserId(user_id);
	     Forum.setUserName(name);
	     forums.add(Forum);
	     //csi.addCommnet(Forum);
	     }
		
	public void testfindByUseId() {
		//List<Forum> Forums = this.ForumService.getForumById(forumId);
		//csi = new ForumServiceImp();
	    //assertEquals(1,csi.getForumById(Forum.getForumId()).size());
	     	 	 
	}
	
	
	public void testAddForum() {
		fsi = new ForumServiceImp();
		assertNull(forum);
		//csi.addCommnet(Forum);
		assertEquals(count,forums.size());
	}

}
