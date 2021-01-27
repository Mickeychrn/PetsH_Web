package usyd.elec5619.petsh.web;

import junit.framework.TestCase;


public class AdminControllerTest extends TestCase{

	
	public void testHandleRequestView() throws Exception{
		AdminController adminController = new AdminController();
		assertNotNull(adminController);
    }
}
