package net.prodigylabs.test.page.component.console;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Nav bar page component
 */
public class NavBar extends PageComponent {

  private static final String SELECTOR = ".container-nav-bar";

  public NavBar(final WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  public NavBar getNavBar() {
    return this;
  }

  public boolean isUserInfoDisplayed() {
    try {
      new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".navbar-user-info")));
    } catch (TimeoutException te) {
      return false;
    }

    return true;
  }

  public Login clickLogout() {
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".navbar-user-info a"))).click();

    return new Login(getWebDriver());
  }
}
