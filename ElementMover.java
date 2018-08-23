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



/**
 * This class provides a top-left corner based coordinate system for moving the
 * Selenium mouse to various locations relative to an element.
 *
 * The Gecko driver has a center-based coordinate system which is difficult to
 * use with different screen sizes and inconsistent with the browser's own own
 * reported location for a click, making debugging difficult and cursor
 * movement error-prone.
 */
public class ElementMover {
    /**
     * Constructor.
     *
     * \param element
     *     The WebElement that all movement is relative to the top-left corner
     *     of.
     */
    public ElementMover(WebElement element) {
        this.element = element;
    }

    /**
     * Add an action to move the mouse to a percentage offset from the top-left
     * corner of a given WebElement.
     *
     * This function must be called on each page mouse-tracking is needed on.
     *
     * \param actions
     *     The previous actions to append to.
     * \param xFraction
     *     The fraction of the element's width from the left edge of the
     *     element to move it. It is expressed as a decimal between 0 and 1.
     * \param yFraction
     *     The fraction of the element's height from the top edge of the
     *     element to move it. It is expressed as a decimal between 0 and 1.
     * \param xOffset
     *     The additional absolute offset to shift left or right after reaching
     *     xFraction.
     * \param yOffset
     *     The additional absolute offset to shift up or down after reaching
     *     yFraction.
     */
    public Actions moveToElement(Actions actions, double xFraction, double yFraction, int xOffset, int yOffset) {
        // Compute the absolute offsets relative to the top-level corner
        int absX = (int) (element.getRect().getWidth() * xFraction) + xOffset;
        int absY = (int) (element.getRect().getHeight() * yFraction) + yOffset;

        // Translate them into selenium-friendly coordinates (center of element is 0-0)
        Point p = translateToCenterCoordinates(new Point(absX, absY));

        // Add the move action and return it.
        return actions.moveToElement(element, p.getX(), p.getY());
    }


    /**
     * Add an action to move the mouse to a percentage offset from the top-left
     * corner of a given WebElement.
     *
     * This function must be called on each page mouse-tracking is needed on.
     *
     * \param actions
     *     The previous actions to append to.
     * \param xFraction
     *     The fraction of the element's width from the left edge of the
     *     element to move it. It is expressed as a decimal between 0 and 1.
     * \param yFraction
     *     The fraction of the element's height from the top edge of the
     *     element to move it. It is expressed as a decimal between 0 and 1.
     */
    public Actions moveToElement(Actions actions, double xFraction, double yFraction) {
        return moveToElement(actions, xFraction, yFraction, 0, 0);
    }

    /**
     * Change coordinates based on top-left to coordinates based on center
     * point.
     */
    public Point translateToCenterCoordinates(Point topLeftCoordinates) {
        // It suffices to take the first set of coordinates and subtract the
        // coordinates of the center under the top-left based coordinate
        // system.
        int centerX = element.getRect().getWidth() / 2;
        int centerY = element.getRect().getHeight() / 2;
        return new Point(topLeftCoordinates.getX() - centerX, topLeftCoordinates.getY() - centerY);
    }

    private WebElement element;
}
