package usyd.elec5619.petsh.web;

import junit.framework.TestCase;

public class LoginProfileControllerTest extends TestCase{

	public void testHandleRequestView() throws Exception{
		LoginProfileController loginProfileController = new LoginProfileController();
		assertNotNull(loginProfileController);
    }
}
