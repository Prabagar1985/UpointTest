package sample.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
	
	public WebDriver driver = null;
	
	@BeforeTest 
	public void openBrowserAndQCURL()
	{
		System.out.println("In Test...");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://leqlb030.upoint.qc.alight.com/web/gpc/login?forkPage=false#/routing");
	}
	
	@Test (priority=1)
	public void enterLoginCredAndSubmit()
	{
		driver.findElement(By.id("_ParticipantLogon20_WAR_ahcommonauthportlet_userId")).sendKeys("a60100053");
		driver.findElement(By.id("_ParticipantLogon20_WAR_ahcommonauthportlet_password")).sendKeys("A999999a");
		WebElement chk = driver.findElement(By.id("_ParticipantLogon20_WAR_ahcommonauthportlet_enableNPVCheckbox"));
		if(chk.isSelected())
			chk.click();
		driver.findElement(By.id("_ParticipantLogon20_WAR_ahcommonauthportlet_testCfgList[0].cfgValue")).sendKeys("ZH3B");
		
		WebElement rsaChkbox = driver.findElement(By.id("_ParticipantLogon20_WAR_ahcommonauthportlet_skipAACheckbox"));
		if(!rsaChkbox.isSelected())
			rsaChkbox.click();
		
		WebElement udpChkbox = driver.findElement(By.id("_ParticipantLogon20_WAR_ahcommonauthportlet_enableUDPCheckbox"));
		if(!udpChkbox.isSelected())
			udpChkbox.click();
		
		driver.findElement(By.id("_ParticipantLogon20_WAR_ahcommonauthportlet_udpSchema")).sendKeys("QB09301B");
		
		//driver.findElement(By.id("_ParticipantLogon20_WAR_ahcommonauthportlet_logOn")).click();
		System.out.println("Clicked login button...");
	}
	
	@Test(priority=0)
	public void loginPageLogo()
	{
		WebElement logo = driver.findElement(By.xpath("//*[@id=\"_ParticipantLogon20_WAR_ahcommonauthportlet_csPrtlLogn010InptFormBean\"]/div[1]/img"));
		System.out.println(logo.getAttribute("src"));
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
}
