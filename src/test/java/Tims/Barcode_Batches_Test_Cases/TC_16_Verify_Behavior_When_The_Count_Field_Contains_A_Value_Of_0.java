package Tims.Barcode_Batches_Test_Cases;

import java.io.IOException;

import org.testng.annotations.Test;

import Test.Tims.Actions_Class.Barcode_Batches_Actions;
import initializer.BaseClass;

public class TC_16_Verify_Behavior_When_The_Count_Field_Contains_A_Value_Of_0 extends BaseClass{

	Barcode_Batches_Actions barcode_batches_actions;
	
	@Test
	public void TC_16_Verify_behavior_when_the_count_field_contains_a_value_of_0() throws IOException, InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.countValueZero();
	}
	
	@Test(dependsOnMethods = "TC_16_Verify_behavior_when_the_count_field_contains_a_value_of_0" )
	public void TC_19_Verify_that_clicking_the_incremental_arrow_increases_the_count_value() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyIncArrowFunction();
	}
	
	@Test(dependsOnMethods = "TC_19_Verify_that_clicking_the_incremental_arrow_increases_the_count_value" )
	public void TC_20_Verify_that_clicking_the_decremental_arrow_decreases_the_count_value() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyDecArrowFunction();
	}
	
	@Test(dependsOnMethods = "TC_20_Verify_that_clicking_the_decremental_arrow_decreases_the_count_value" )
	public void TC_21_Verify_that_the_Count_field_cannot_be_decremented_below_2() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyCountIsNotDecBelow2();
	}
	
	@Test(dependsOnMethods = "TC_21_Verify_that_the_Count_field_cannot_be_decremented_below_2" )
	public void TC_18_Verify_that_the_count_field_contains_incremental_and_decremental_arrows() throws InterruptedException {
		barcode_batches_actions = new Barcode_Batches_Actions(getDriver());
		barcode_batches_actions.verifyPresenceOfIncDecArrows();
	}
}
