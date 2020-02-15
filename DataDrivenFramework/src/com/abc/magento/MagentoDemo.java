package com.abc.magento;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MagentoDemo {

	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("D:\\java\\selenium\\DataDrivenFramework\\src\\com\\abc\\utilities\\datadrivenframework.properties");
	    Properties p = new Properties();
	    p.load(fis);
	    String urldata = p.getProperty("url");
	    String usernameData=p.getProperty("username");
	    String passwordData = p.getProperty("password");
	    System.out.println(urldata);
	    System.out.println(usernameData);
	    System.out.println(passwordData);
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get(urldata);
	    driver.findElement(By.linkText("My Account")).click();
	    driver.findElement(By.id("email")).sendKeys(usernameData);
	    driver.findElement(By.id("pass")).sendKeys(passwordData);
	    driver.findElement(By.id("send2")).click();
	    driver.findElement(By.linkText("Log Out")).click();
	    driver.quit();
	}

}
