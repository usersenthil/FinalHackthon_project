package pageObjects;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import Utilities.ExcelUtils;
import Utilities.readandwritedata;
public class Corporates extends BasePage {
	public Corporates(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	static String file=System.getProperty("user.dir")+"\\src\\test\\resources\\testdata.xlsx";
	JavascriptExecutor js=(JavascriptExecutor)driver;
    //click corporates
	@FindBy(xpath="//span[@class='nav-interact']")
	WebElement clickcorporates;
	//click health and wellness
	@FindBy(xpath="(//div[@class='u-d-item']/a)[1]")
	WebElement clickhealth;
	//scroll
	@FindBy(xpath="(//h2[@class='u-m-b--20 text-beta'])[1]")
	WebElement scrolltill;
	//click name
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement clickname;
	//click organization name
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement clickorgName;
	//click contact
	@FindBy(xpath="(//input[@type='tel'])[1]")
	WebElement clickcontact;
	//click email
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement clickemail;
    //click organization size
	@FindBy(xpath="(//select[@class='corporate-form__select text-grey-3'])[1]") //click
	WebElement clickorgSize;
	//choose organization size
	@FindBy(xpath="//*[@id=\"organizationSize\"]/option[3]")
	WebElement chooseOption;
	//click interested in 
	@FindBy(xpath="//select[@id='interestedIn'][1]") //click
	WebElement clickintrestedIn;
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement name;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	WebElement orgName;
	
	@FindBy(xpath="(//input[@type='tel'])[1]")
	WebElement contact;
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement email;
	
	
	@FindBy(xpath="(//select[@class='corporate-form__select text-grey-3'])[1]") //click
	WebElement orgSize;
	
	@FindBy(xpath="//*[@id=\"organizationSize\"]/option[3]")
	WebElement clickOption;
	
	@FindBy(xpath="//select[@id='interestedIn'][1]") //click
	WebElement intrestedIn;
	
	@FindBy(xpath="(//option[@value='Taking a demo'])[1]")
	WebElement clickIntrest;
	
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement verify;
	@FindBy(xpath="(//button[@type='submit'])[2]") //header[@id='header']//button[normalize-space()='Schedule a demo']
	WebElement verifySubmit;
	@FindBy(xpath="(//input[@type='text'])[3]")
	WebElement sendcrtmail;
	//choose interested in
	@FindBy(xpath="(//option[@value='Taking a demo'])[1]")
	WebElement chooseIntrest;
	//verify demo button
	@FindBy(xpath="(//button[@type='submit'])[1]")
	WebElement demobutton;
	//thank you text
	@FindBy(xpath="(//div[@class='u-text--bold text-alpha'])[1]")
	WebElement thankyoutext;
	//paragraph below thank you
	@FindBy(xpath="(//div[@class='u-m-t--10'])[1]")
	WebElement paragraphbelowtq;
	private static String[] inputData;
	//Action Methods
	public void selectCorporate() {
		clickcorporates.click();
	}
	public void selectHealth() {
		clickhealth.click();
		js.executeScript("arguments[0].scrollIntoView();", scrolltill);
	}
	public void validateCorporatePage() {
		String title = driver.getTitle();
		System.out.println("corporates page title is : " + title);
		String text = "Employee Health | Corporate Health & Wellness Plans | Practo";
		Assert.assertEquals( title,text,"Directed to correct page");
		System.out.println("Directed to correct page");
	}
//	|regression for form**************************************************************************
//	v
	public void nameEmpty(String excelFilePath,String sheetName) throws InterruptedException, IOException {
		inputData=readandwritedata.read(excelFilePath,sheetName);
		clickorgName.sendKeys(inputData[2]);
		clickcontact.sendKeys(inputData[3]);
		clickemail.sendKeys(inputData[4]);
		clickorgSize.click();
		chooseOption.click();
		clickintrestedIn.click();
		chooseIntrest.click();
		Thread.sleep(3000);
	}
	public void OrganizationEmpty(String excelFilePath,String sheetName) throws InterruptedException, IOException {
		inputData=readandwritedata.read(excelFilePath,sheetName);
		clickname.sendKeys(inputData[1]);
		clickcontact.sendKeys(inputData[3]);
		clickemail.sendKeys(inputData[4]);
		clickorgSize.click();
		chooseOption.click();
		clickintrestedIn.click();
		chooseIntrest.click();
		Thread.sleep(3000);
	}
	public void contactEmpty(String excelFilePath,String sheetName) throws InterruptedException, IOException {
		inputData=readandwritedata.read(excelFilePath,sheetName);
		clickname.sendKeys(inputData[1]);
		clickorgName.sendKeys(inputData[2]);
		clickemail.sendKeys(inputData[4]);
		clickorgSize.click();
		chooseOption.click();
		clickintrestedIn.click();
		chooseIntrest.click();
		Thread.sleep(3000);
	}
	public void incorrectNoOfDigitsContact(String excelFilePath,String sheetName) throws InterruptedException, IOException {
		inputData=readandwritedata.read(excelFilePath,sheetName);
		clickname.sendKeys(inputData[1]);
		clickorgName.sendKeys(inputData[2]);
		clickcontact.sendKeys(inputData[6]);
		clickemail.sendKeys(inputData[4]);
		clickorgSize.click();
		chooseOption.click();
		clickintrestedIn.click();
		chooseIntrest.click();
		Thread.sleep(3000);
	}
	public void incorrectContactNo(String excelFilePath,String sheetName) throws InterruptedException, IOException {
		inputData=readandwritedata.read(excelFilePath,sheetName);
		clickname.sendKeys(inputData[1]);
		clickorgName.sendKeys(inputData[2]);
		clickcontact.sendKeys(inputData[7]);
		clickemail.sendKeys(inputData[4]);
		clickorgSize.click();
		chooseOption.click();
		clickintrestedIn.click();
		chooseIntrest.click();
		Thread.sleep(3000);
	}
	public void emailEmpty() throws InterruptedException {
		clickname.sendKeys(inputData[1]);
		clickorgName.sendKeys(inputData[2]);
		clickcontact.sendKeys(inputData[3]);
		clickorgSize.click();
		chooseOption.click();
		clickintrestedIn.click();
		chooseIntrest.click();
		Thread.sleep(3000);
	}
	public void enterDetails1() throws InterruptedException {
		name.sendKeys(inputData[1]);
	
		orgName.sendKeys(inputData[2]);
	
		contact.sendKeys(inputData[3]);
	
		email.sendKeys(inputData[4]);
		
		orgSize.click();
	
		clickOption.click();
	
		intrestedIn.click();
	
		clickIntrest.click();
		Thread.sleep(3000);
		Boolean bool=verify.isEnabled();
		if(bool==false) {
			System.out.println("Demo is disabled");
		}
		else {
			System.out.println("Test failes,Demo is enabled");
		}
		
		Thread.sleep(2000);
		email.clear();
		email.sendKeys(inputData[6]);
		Thread.sleep(3000);
		Boolean bool1=verifySubmit.isEnabled();
		if(bool1==true) {
			System.out.println("submit clicked");
		}
		else {
			System.out.println("Error");
		}
		verify.click();
		Thread.sleep(30000);
	}
	
	public void enterDetails(String excelFilePath,String sheetName) throws InterruptedException, IOException {
		inputData=readandwritedata.read(excelFilePath,sheetName);
		clickname.sendKeys(inputData[1]);
		clickorgName.sendKeys(inputData[2]);
		clickcontact.sendKeys(inputData[3]);
		clickemail.sendKeys(inputData[4]);
		clickorgSize.click();
		chooseOption.click();
		clickintrestedIn.click();
		chooseIntrest.click();
		Thread.sleep(3000);
	}
	public void enterDetaildvalid(String excelFilePath,String sheetName) throws InterruptedException, IOException{
		inputData=readandwritedata.read(excelFilePath,sheetName);
		clickname.sendKeys(inputData[1]);
		clickorgName.sendKeys(inputData[2]);
		clickcontact.sendKeys(inputData[3]);
		clickemail.sendKeys(inputData[5]);
		clickorgSize.click();
		chooseOption.click();
		clickintrestedIn.click();
		chooseIntrest.click();
		Thread.sleep(3000);
	}
//	^
//	|regression for form ends***********************************************************************

	public void enterDetailsinvalid(String excelFilePath,String sheetName) throws InterruptedException, IOException {
		inputData=readandwritedata.read(excelFilePath,sheetName);
		clickname.sendKeys(inputData[1]);
		clickorgName.sendKeys(inputData[2]);
		clickcontact.sendKeys(inputData[3]);
		clickemail.sendKeys(inputData[4]);
		clickorgSize.click();
		chooseOption.click();
		clickintrestedIn.click();
		chooseIntrest.click();
		Thread.sleep(3000);
	}
	public void enterDetailsvalid(String excelFilePath,String sheetName) throws InterruptedException, IOException{
		inputData=readandwritedata.read(excelFilePath,sheetName);
		sendcrtmail.clear();
		sendcrtmail.sendKeys(inputData[5]);
		Thread.sleep(3000);
	}
	public void demobutton() throws InterruptedException {
		Boolean bool=demobutton.isEnabled();
		if(bool==false) {
			System.out.println("Schedule a Demo is disabled");
		}
		else {
			System.out.println("Schedule a Demo is enabled");
			demobutton.click();
			Thread.sleep(9000);
		}
		Thread.sleep(2000);
	}
		public void textPrint() throws InterruptedException {
			String msg=thankyoutext.getText();
			System.out.println(msg);
			String msg1=paragraphbelowtq.getText();
			System.out.println(msg1);		
			Boolean thankyou = thankyoutext.isDisplayed();
			Assert.assertTrue(thankyou,"THANK YOU message is displayed" );
			System.out.println("THANK YOU message is displayed");
			Thread.sleep(2000);
		}
		//regression
		public void validateThankYou() throws InterruptedException {
			Boolean thankyou = thankyoutext.isDisplayed();
			Assert.assertTrue(thankyou,"THANK YOU message is displayed" );
			System.out.println("THANK YOU message is displayed");
			Thread.sleep(2000);
		}
		public void screenshot() throws IOException, HeadlessException, AWTException {
			BufferedImage img1=new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(img1, "png", new File("C:\\Users\\2304016\\Downloads\\Final_Hackathon_Proj (2) 1\\Final_Hackathon_Proj\\src\\test\\java\\Screenshots"));
		}
}