// Seleinum imports
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;

public class FirefoxTest {
    public static void printElementBox(WebElement element) {
        Point loc = element.getLocation();
        Dimension size = element.getSize();
        System.out.println("Location: " + loc);
        System.out.println("Size:     " + size);
        System.out.printf("Midpoint: (%d,%d)\n", loc.getX() + size.getWidth() / 2, loc.getY() + size.getHeight() / 2);
    }

    public static void main(String[] args) {
        // Set up driver
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("http://www.google.com");
        WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        MouseTracker.showLastClick(js);

        // Perform a move and click action to see where it lands.
        ElementMover mover = new ElementMover(element);
        Actions moveAndClick = mover.moveToElement(new Actions(driver), 0.3, 0.5);
        moveAndClick = mover.moveToElement(new Actions(driver), 0.8, 0.5);
        moveAndClick = moveAndClick.click();
        moveAndClick.perform();
    }
}
