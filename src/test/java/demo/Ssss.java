package demo;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ssss {

	public static void main(String[] args) {
		

		
		String url="https://testpages.herokuapp.com/styled/tag/dynamic-table.html";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		WebElement ele = driver.findElement(By.xpath("//summary[text()='Table Data']"));
		ele.click();
		
		// 3 read the data
				JSONParser parser=new JSONParser();
				FileReader reader=new  FileReader("./src/test/resources/data.json");
		        Object obj = parser.parse(reader);
				
		     // Cast the parsed object to a JSONArray
		        JSONArray jsonArray = (JSONArray) obj;
		     // Iterate through the array and access each JSONObject
		        for (Object o : jsonArray) {
		            JSONObject person = (JSONObject) o;
		            HashMap<Object, Object>n=new HashMap<Object, Object>();
		            n.put(jsonArray, jsonArray);
		            
		
		
		
		
		
		
		
		

		
		//copythe data from the jsonfile and paste it in sendkeys
	driver.findElement(By.id("jsondata")).sendKeys(n.toString());
		
		//click on refresh button
	driver.findElement(By.xpath("//button[@id='refreshtable']")).click();
	System.out.println("clicked");
	
	//5. Now assert the data you have stored with the data that is populated in the UI table. Both data should	match.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
