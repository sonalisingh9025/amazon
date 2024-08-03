package amazont;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonTwo {

	WebDriver driver;

    String url = "https://www.amazon.in/";

	
	public void invokeBrowser() {
		
		System.setProperty("Webdriver.chrome.driver", "C:\\Users\\sonal\\OneDrive\\Documents\\libs");
		
		driver = new ChromeDriver();
		//driver.manage().window.maxmize();
		driver.manage().window().maximize();

		driver.get(url);
	}

	
	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\sonal\\OneDrive\\Documents\\libs");

        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://www.amazon.in/");


            WebElement categoryLink = driver.findElement(By.xpath("//link[@rel = \"preload\"]"));
            categoryLink.click();

            long loadTime = (Long) ((JavascriptExecutor) driver).executeScript(
                    "return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart);");

            System.out.println("Page Load Time: " + loadTime + " ms");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
