package net.prodigylabs.test.page.component.dac.ui.r13;

import net.prodigylabs.test.page.component.console.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Nav bar page component
 */
public class ProdigyNavBar extends ProdigyPageComponent {

  private static final String SELECTOR = ".container-nav-bar";

  public ProdigyNavBar(final WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  public ProdigyNavBar getNavBar() {
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
