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
public class MouseTracker {
    static String addImageJs =
  "var img = document.createElement(\"img\");"
+ "img.src = 'data:image/svg+xml;utf8,<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"16\" height=\"16\"> <circle r=\"7\" cx=\"8\" cy=\"8\" style=\"fill:red;stroke:gray;stroke-width:0.1\"/> </svg>';"
+ "img.id = \"reddotpointer\";"
+ "img.style.zIndex = \"1000\";"
+ "img.style.position = \"absolute\";"
+ "return document.body.appendChild(img);";

    static String addOnclickJs =
  "window.dot=document.getElementById(arguments[0]);"
+ "document.body.onclick = function(e) {"
+ "    console.log(e);"
+ "    dot.style.left = (e.clientX - dot.width / 2) + 'px';"
+ "    dot.style.top = (e.clientY - dot.height / 2) + 'px';"
+ "};";

    /**
     * Shows the last click on the currently loaded page.
     *
     * This function must be called on each page mouse-tracking is needed on.
     */
    public static void showLastClick(JavascriptExecutor js) {
        // Set up image for mouse's last click.
        WebElement img = (WebElement) js.executeScript(addImageJs);

        // Wait for element to be visible
        WebDriver driver = (WebDriver) js;
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.id(img.getAttribute("id"))));

        // Move the image when the body is clicked.
        js.executeScript(addOnclickJs, img.getAttribute("id"));
    }
}
