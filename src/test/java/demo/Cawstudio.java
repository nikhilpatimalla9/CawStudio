package demo;

import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cawstudio {

	
	public static void main(String[] args) throws Throwable {
		
		
		String url="https://testpages.herokuapp.com/styled/tag/dynamic-table.html";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get(url);
		
		driver.findElement(By.xpath("//summary[text()='Table Data']")).click();
		
		//==========================create jsonfile
//		
//		JSONObject o=new JSONObject();
//		o.put("name", "Sara");
//		o.put("age", 42);
//		FileWriter fis=new FileWriter("./src/test/resources/data.json");
//		
//		fis.write(o.toJSONString());
//		fis.close();
//		System.out.println("file created sucessfully");
//		
		
		// 3 read the data
		JSONParser parser=new JSONParser();
		FileReader reader=new  FileReader("./src/test/resources/data.json");
        Object obj = parser.parse(reader);
		
     // Cast the parsed object to a JSONArray
        JSONArray jsonArray = (JSONArray) obj;
     // Iterate through the array and access each JSONObject
        for (Object o : jsonArray) {
            JSONObject person = (JSONObject) o;
            
            //individual
            String name = (String) person.get("name");
            Long age = (Long) person.get("age");
            String gender = (String) person.get("gender");
		

            System.out.println("Name: " + name + ", Age: " + age + ", Gender: " + gender);
		
		
		HashMap<Object, Object>n=new HashMap<Object, Object>();
		n.put("name", name);
		n.put("gender", gender);
		n.put("age", age);
		
		
		
		//copythe data from the jsonfile and paste it in sendkeys
//	driver.findElement(By.id("jsondata")).sendKeys(Keys.CLEAR);
//	Thread.sleep(2000);
	driver.findElement(By.id("jsondata")).sendKeys(n.toString());

        }
		//click on refresh button
	driver.findElement(By.xpath("//button[text()='Refresh Table']")).click();
	System.out.println("clicked");
	//5. Now assert the data you have stored with the data that is populated in the UI table. Both data should	match.
		
		
		
		
		
		
		
	}
}
