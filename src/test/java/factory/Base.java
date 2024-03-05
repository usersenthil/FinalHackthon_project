package factory;
 
 
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;
 
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v119.runtime.Runtime.GetPropertiesResponse;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
 
public class Base {
	public static WebDriver driver;
	public static Properties p;
	public static Logger logger;
 
	public static WebDriver IntializeBrowser()throws IOException{   
		if(getProperties().getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			if(getProperties().getProperty("os").equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}
			else if(getProperties().getProperty("os").equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("No Matching os");
			}
			switch(getProperties().getProperty("browser").toLowerCase()) {
			case  "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case  "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("No matching browser");
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
		}
		else if (getProperties().getProperty("execution_env").equalsIgnoreCase("local")) {
			switch(getProperties().getProperty("browser").toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver=new EdgeDriver();
				break;
			default:
				System.out.println("No Matching Browser");
				driver=null;
			}
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;

 
	}
	public static WebDriver getDriver() {
		return driver;
	}
	public static Properties getProperties() throws IOException{
		FileReader file = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(file);
		return p;
	}
//	public static Logger getLogger() {
//		logger=Logger.getLogger();
//		return logger;
//	}
 
}
