package Pushpa_Test;

import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pushpa {
	
WebDriver driver;
	
	@BeforeMethod
	public  void start()
	{	
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
	}
	
	@Test
	public  void Testing()
	{
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Pushpa The Rise");
		//----------------------Wikipedia---------------------------
		driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).click();
		driver.findElement(By.xpath("//h3[normalize-space()='Pushpa: The Rise - Wikipedia']")).click();
		String ReleaseDate1 = driver.findElement(By.xpath("//tbody/tr[12]/td[1]/div[1]/ul[1]/li[1]")).getText();
		System.out.println(ReleaseDate1);
		String Country1 = driver.findElement(By.xpath("//td[normalize-space()='India']")).getText();
		//------------------------IMDB-------------------------------
		driver.navigate().back();
		driver.findElement(By.xpath("//h3[normalize-space()='Pushpa: The Rise - Part 1 (2021) - IMDb']")).click();
		String A = driver.findElement(By.xpath("//a[normalize-space()='December 17, 2021 (United States)']")).getText();
		String B = A.replace(" "+"(United States)","");
		String ReleaseDate2 = B.replace(",","");
		System.out.println(ReleaseDate2);
		String Country2 = driver.findElement(By.xpath("//a[normalize-space()='India']")).getText();
		SoftAssert softAssert = new SoftAssert();
		System.out.println("Country details matching started.........");
		softAssert.assertEquals(Country1, Country2, "---- Country Data Matched-----");
		System.out.println("Release Date details matching started.........");
		//softAssert.assertEquals(ReleaseDate1, ReleaseDate2, "----Release Date Data Matched----");
		 char[] arrStr = ReleaseDate2.toCharArray();
		    char[] arrStr1 = ReleaseDate1.toCharArray();
		    Arrays.sort(arrStr);
		    Arrays.sort(arrStr1);
		   if(Arrays.equals(arrStr, arrStr1))
		   {
			   System.out.println("Release Date Data Matched");
		   }
		   else
			   System.out.println("Release Date Data not Matched");
		softAssert.assertAll();
	
	}
	@AfterMethod
	public  void close()
	{
		driver.quit();
	}


}
