package net.prodigylabs.test.page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Nav bar page component
 */
public class Notifier extends PageComponent {

  private static final String SELECTOR = ".container-notifier";

  public Notifier(final WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  public Notifier getNotifier() {
    return this;
  }

  public boolean isSuccessfulLoginNotificationDisplayed() {
    try {
      new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElements(By.cssSelector(".notifier-alert .alert-success.show"))
          .stream().map(WebElement::getText).filter(text -> text.contains("Successfully logged in")).count() == 1);
    } catch (TimeoutException te) {
      return false;
    }

    return true;
  }

  public boolean isSuccessfulLogoutNotificationDisplayed() {
    try {
      new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElements(By.cssSelector(".notifier-alert .alert-success.show"))
          .stream().map(WebElement::getText).filter(text -> text.contains("Successfully logged in")).count() == 1);
    } catch (TimeoutException te) {
      return false;
    }

    return true;
  }
}
