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

// Other imports
import java.io.IOException;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;


public class FirefoxTest {
    public static void printElementBox(WebElement element) {
        Point loc = element.getLocation();
        Dimension size = element.getSize();
        System.out.println("Location: " + loc);
        System.out.println("Size:     " + size);
        System.out.printf("Midpoint: (%d,%d)\n", loc.getX() + size.getWidth() / 2, loc.getY() + size.getHeight() / 2);
    }
    static String readFile(String path, Charset encoding)
    {
        byte[] encoded = null;
        try {
            encoded = Files.readAllBytes(Paths.get(path));
        } catch (IOException io) {
            System.err.println("Error reading file " + path);
            System.exit(1);
        }
        return new String(encoded, encoding);
    }

    /**
     * Shows the last click on the currently loaded page.
     *
     * This function must be called on each page mouse-tracking is needed on.
     */
    public static void showLastClick(JavascriptExecutor js) {
        // Set up image for mouse's last click.
        WebElement img = (WebElement) js.executeScript(readFile("js/add_image.js", Charset.defaultCharset()));

        // Wait for element to be visible
        WebDriver driver = (WebDriver) js;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id(img.getAttribute("id"))));

        // Move the image when the body is clicked.
        js.executeScript(readFile("js/add_onclick.js", Charset.defaultCharset()), img.getAttribute("id"));
    }

    public static void main(String[] args) {
        // Set up driver
        WebDriver driver = new FirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("http://www.google.com");
        WebElement element = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        showLastClick(js);
        printElementBox(element);
        element.click();
    }
}
