package net.prodigylabs.test.page.component.console;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Optional;

/**
 * Login page component
 */
public class Login extends PageComponent {

  private static final String SELECTOR = ".container-login form";

  public Login(final WebDriver webDriver) {
    super(webDriver);
  }

  public boolean isSubmitButtonEnabled() {
    final WebElement webElement = new WebDriverWait(getWebDriver(), 1)
        .until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("button[type='submit']")));

    final boolean isDisabled = Optional.ofNullable(webElement.getAttribute("disabled")).map("true"::equals).orElse(Boolean.FALSE);
    final boolean isReadonly = Optional.ofNullable(webElement.getAttribute("readonly")).map("true"::equals).orElse(Boolean.FALSE);

    return !isDisabled && !isReadonly;
  }

  public Login setUsername(final String username) {
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("#username"))).sendKeys(username);

    return this;
  }

  public Login setPassword(final String password) {
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("#password"))).sendKeys(password);

    return this;
  }

  public Login clickRememberMe() {
    final WebElement webElement = new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("#remember-me")));

    new Actions(getWebDriver()).moveToElement(webElement).click().build().perform();

    return this;
  }

  public Metrics clickLogin() {
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("button[type='submit']"))).click();

    return new Metrics(getWebDriver());
  }
}
