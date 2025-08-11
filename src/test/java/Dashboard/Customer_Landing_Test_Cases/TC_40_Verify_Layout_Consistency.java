package Dashboard.Customer_Landing_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Dashboard.Actions_Class.Customer_Landing_Actions;
import initializer.BaseClass;

public class TC_40_Verify_Layout_Consistency extends BaseClass{

	Customer_Landing_Actions customer_landing_actions;
	
	@Test
	public void TC_40_Verify_layout_consistency() throws IOException, InterruptedException {
		customer_landing_actions = new Customer_Landing_Actions(getDriver());
		customer_landing_actions.verifyLayoutConsistencyDb();
	}
}
