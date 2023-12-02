package ProjectOne;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {

	static WebDriver driver = new ChromeDriver();
	static String myWebsite = "https://www.saucedemo.com/";
	static String userName = "standard_user";
	static String password = "secret_sauce";

	static void login() {
		driver.get(myWebsite);

		WebElement userNameInput = driver.findElement(By.id("user-name"));
		WebElement passwordInput = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		userNameInput.sendKeys(userName);
		passwordInput.sendKeys(password);

		LoginButton.click();
	}

	static void add(String... items) {
		List<WebElement> addtoCartButtons = driver.findElements(By.className("btn"));
		List<WebElement> ProductsNames = driver.findElements(By.className("inventory_item_name"));

		for (int i = 0; i < ProductsNames.size(); i++) {
			String productName = ProductsNames.get(i).getText();

			if (containitemName(productName, items)) {
				addtoCartButtons.get(i).click();
			}
		}
	}

	private static boolean containitemName(String neededItemToBeAdded, String... itemNames) {
		for (String itemName : itemNames) {
			if (neededItemToBeAdded.contains(itemName)) {
				return true;

			}

		}
		return false;

	}

	static void logout() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"reset_sidebar_link\"]")).click();

		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"react-burger-menu-btn\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("logout_sidebar_link")).click();
	}

}