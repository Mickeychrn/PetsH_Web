package usyd.elec5619.petsh.web;

import junit.framework.TestCase;

public class SignInControllerTest extends TestCase{
	
	public void testHandleRequestView() throws Exception{
		SignInController signInController = new SignInController();
		assertNotNull(signInController.homepage());
	}

}
