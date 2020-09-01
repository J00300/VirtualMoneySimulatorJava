package pr;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.coordinates.*;

public class Seleniumprocess 
{
	//WebDriver
	private WebDriver driver;
	private WebElement element;
	private String url;
    
	//Properties
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "chromedriver.exe";
    
	public Seleniumprocess() 
	{
		
		System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		ChromeOptions options = new ChromeOptions();

		
		options.setCapability("ignoreProtectedModeSettings", true);
		options.addArguments("--window-position=-32000,-32000");
		driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(2000, 1500));
        
	}
	
	public void oper(String url, String saveFiles) 
	{
		try {
			//get방식으로 url 요청
			driver.get(url);
			//driver.manage().window().maximize();
			
			Thread.sleep(400);
			element = driver.findElement(By.id("chart_container"));
			Screenshot screenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,element);
			ImageIO.write(screenshot.getImage(), "PNG", new File(saveFiles));
			
			if (saveFiles.equals("LINK.png"))
			{
				driver.close();
			}
		
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}


