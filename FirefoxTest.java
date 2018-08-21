import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class FirefoxTest {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('hello world from seleinium!');");
	}
}
