import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;

public class FirefoxTest {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        js.executeScript("document.body.onclick = function(e) {console.log(e);}");
        Point loc = element.getLocation();
        Dimension size = element.getSize();
        System.out.println("Location: " + loc);
        System.out.println("Size:     " + size);
        System.out.printf("Midpoint:    (%d,%d)\n", loc.getX() + size.getWidth() / 2, loc.getY() + size.getHeight() / 2);
        element.click();
	}
}
