package ProjectOne;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters{

	 
	@BeforeTest
	
	public void mySetup() throws InterruptedException {

		driver.manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void addTwoItems() throws InterruptedException {

		login();

		add("Backpack", "Light", " Bolt T-Shirt");
		Thread.sleep(3000);

		logout();

	}

	@Test(priority = 2)
	public void addthreeItems() throws InterruptedException {

		login();
		add("Backpack", "Onesie");

		Thread.sleep(3000);
		logout();

	}

	@Test(priority = 3)

	public void addFourItems() throws InterruptedException {

		login();
		Thread.sleep(3000);

		add(" Backpack", "Bolt T-Shirt", " Labs Onesie");
		Thread.sleep(5000);

	}
	@AfterTest
	
	public void PostTesting() {}
}
