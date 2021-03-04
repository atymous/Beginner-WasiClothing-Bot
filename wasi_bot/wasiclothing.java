package wasi_bot;

import java.sql.SQLException;
//import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Ashia
 * @version 0.1.0
 * This class is about automation of purchasing an item from Wasi Clothing.
 *
 */

public class wasiclothing 
{
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static WebElement element;
	private static JavascriptExecutor jsExecutor;
	private static StringBuffer strXpath;
	

	public static void main(String[] args) throws ClassNotFoundException, Exception 
	{
		run();
	}
	
	public static void run() throws InterruptedException
	{
		wasiRun();
		// try 
		// {
		// 	wasiRun();
		// }
		
		// catch (Exception e) 
		// {
		// 	System.out.println("Error while running WasiClothing"); 
		// }
		
		// finally 
		// {
		// 	//driver.quit();
		// }
	}
	

	// run called functions below
	private static void wasiRun() throws InterruptedException //, SQLException
	{
		System.setProperty("webdriver.chrome.driver", "/Users/mac/Desktop/Selenium/Installers/chromedriver"); 
		//System.setProperty("webdriver.gecko.driver", "/Users/mac/Desktop/Selenium/Installers/geckodriver"); 
		
		init(); 

		// create outfit
		buildOutfit();

		// take a look at cart
		checkCart();

		// check out $$$
		checkOut();
		
		// fill-in contacr + shipping information
		fillInCheckOut();
		
	  //login(); 
	 
	}

	public static void init() 
	{
		driver = new ChromeDriver(); 
		//driver = new FirefoxDriver();
		
		//Initialize JavascriptExecutor
		jsExecutor = (JavascriptExecutor) driver;
		
		//Initialize WebDriverWait at most 20-second timeout
		wait = new WebDriverWait(driver, 20);

		//Initilize the page load time at most 20-second timeout
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}
	
	public static void buildOutfit() throws InterruptedException
	{

		// direct to website
		driver.get("https://wasiclothing.com/");

		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='shopify-section-header']/div[1]/div[2]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[1]/a[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// select shirt --> Ally For ALl Tee - Mauve
		selectTops();

		// select bottoms
		selectBottoms();
	
		// select bag
		selectBags();

		// extra stickers
		selectStickers();

	}

	private static void continueShopping() {

		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='CartDrawer']/div[@id='CartContainer']/form[1]/div[2]/a[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	private static void selectTops() throws NoSuchElementException, InterruptedException
	{
		// apparel tab
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='shopify-section-header']/div[1]/div[2]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// explore
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body.gridlock.shifter.shifter-left.collection.shifter-enabled:nth-child(2) div.shifter-page.is-moved-by-drawer:nth-child(3) div.row:nth-child(2) div.shopify-section div:nth-child(1) div.desktop-12.tablet-6:nth-child(4) div.filter:nth-child(2) > button.filter-menu")));
		element.click();

		// TOPS
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-collection-template']/div[@id='collection-page-template']/div[@id='full-width-filter']/div[2]/ul[1]/ul[1]/li[4]/a[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// Ally For All Tee - Mauve
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-collection-template']/div[@id='collection-page-template']/div[6]/div[1]/div[18]/div[1]/a[2]/div[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// select size
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/section[1]/div[2]/div[1]/form[1]/div[2]/div[2]/label[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// add to cart
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/section[1]/div[2]/div[1]/form[1]/div[3]/input[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		continueShopping();

	}

	private static void selectBottoms() {

		// SELECT 'APPAREL'
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-collections-list-template']/div[1]/div[1]/div[1]/div[1]/section[1]/article[1]/div[2]/div[2]/div[2]/a[1]/div[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// explore
		element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("body.gridlock.shifter.shifter-left.collection.shifter-enabled:nth-child(2) div.shifter-page.is-moved-by-drawer:nth-child(3) div.row:nth-child(2) div.shopify-section div:nth-child(1) div.desktop-12.tablet-6:nth-child(4) div.filter:nth-child(2) > button.filter-menu")));
		element.click();

		// BOTTOMS
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-collection-template']/div[@id='collection-page-template']/div[@id='full-width-filter']/div[2]/ul[1]/ul[1]/li[7]/a[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// select 'Plant Pants'
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-collection-template']/div[@id='collection-page-template']/div[6]/div[1]/div[5]/a[1]/div[1]/div[2]/img[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// select size 
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/section[1]/div[2]/div[1]/form[1]/div[2]/div[1]/label[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// add to cart
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/section[1]/div[2]/div[1]/form[1]/div[3]/input[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		continueShopping();
	}

	private static void selectBags() {

		// click 'TOTE BAGS'
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-collections-list-template']/div[1]/div[1]/div[1]/div[1]/section[1]/article[1]/div[2]/div[39]/div[2]/a[1]/div[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// select 'Shape Your Best Life Tote'
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-collection-template']/div[@id='collection-page-template']/div[6]/div[1]/div[7]/a[1]/div[1]/div[2]/img[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// select quantity
		// will come back to this later for a for loop

		// add to cart
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/section[1]/div[2]/div[1]/form[1]/div[3]/input[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		continueShopping();

	}

	private static void selectStickers() {

		// click 'STICKERS'
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-collections-list-template']/div[1]/div[1]/div[1]/div[1]/section[1]/article[1]/div[2]/div[35]/div[2]/a[1]/div[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// I'm an aquarius sssoooooooo...... select 'Aquarius Against Racism Sticker'
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-collection-template']/div[@id='collection-page-template']/div[6]/div[1]/div[2]/div[1]/a[2]/div[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// select quantity

		// add to cart
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/section[1]/div[2]/div[1]/form[1]/div[3]/input[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// back to STICKERS
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-product-template']/div[@id='product-6098839830702']/section[1]/div[2]/div[1]/div[4]/span[1]/a[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);
		
		// select 'Cute & Full Of Anxiety Sticker'
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[@id='shopify-section-collection-template']/div[@id='collection-page-template']/div[6]/div[1]/div[13]/a[1]/div[1]/div[1]/img[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

		// select quantity

		// add to cart
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body[1]/div[3]/div[2]/div[1]/div[1]/section[1]/div[2]/div[1]/form[1]/div[3]/input[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);
		
	}

	private static void checkCart() {

		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]/i[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

	}

	private static void checkOut() {

		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='CartDrawer']/div[@id='CartContainer']/form[1]/div[2]/button[1]")));
		jsExecutor.executeScript("arguments[0].click();", element);

	}

	private static void fillInCheckOut() {

		// input email
		//driver.findElement(By.xpath("//input[@id='checkout_email_or_phone']")).sendKeys("atymous6@gmail.com"); 
		//driver.findElement(By.xpath("#checkout_email_or_phone")).sendKeys("atymous6@gmail.com"); 


	}

	// SAVE THIS LATER FOR CHECK OUT

	// Connect to Browser and Initialize WebElements
	// public static void login() throws InterruptedException
	// {
	// 	// Wasi Clothing Website
	// 	driver.get("https://wasiclothing.com/");	

	// 	// click SignIn/Join
	// 	element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//header/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")));
	// 	jsExecutor.executeScript("arguments[0].click();", element);

	// 	// enter email
	// 	driver.findElement(By.xpath("//input[@id='customer-email']")).sendKeys("<YOUR_EMAIL>");
		
	// 	// enter password
	// 	driver.findElement(By.xpath("//input[@id='customer-password']")).sendKeys("<YOUR_PASSWORD>");
		
	// 	// click "Sign In"
	// 	element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/section[1]/div[1]/div[2]/div[1]/div[1]/form[1]/div[1]/div[4]/input[1]")));
	// 	jsExecutor.executeScript("arguments[0].click();", element);

	// 	// bypassed captcha by downloading Auto CAPTCHA solver
	// 	// click "Submit" again
	// 	Thread.sleep(1000);
	// 	element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='PageContainer']/div[@id='content']/div[1]/form[1]/input[2]")));
	// 	jsExecutor.executeScript("arguments[0].click();", element);

	// }
	
}
