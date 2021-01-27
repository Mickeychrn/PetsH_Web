package usyd.elec5619.petsh.web;

import junit.framework.TestCase;

public class LogOutHomeControllerTest extends TestCase{
	
	public void testHandleRequestView() throws Exception{
		LogOutHomeController logOutHomeController = new LogOutHomeController();
		assertNotNull(logOutHomeController.homepage());
    }

}
