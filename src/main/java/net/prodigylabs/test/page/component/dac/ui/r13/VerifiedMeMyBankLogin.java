package net.prodigylabs.test.page.component.dac.ui.r13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * My Bank login page component
 */
public class VerifiedMeMyBankLogin {

  private final WebDriver webDriver;

  private static final String SELECTOR = ".vme-theme--my-bank";

  public VerifiedMeMyBankLogin(final WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public boolean isLoaded() {
    return new WebDriverWait(webDriver, 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("#login")).isDisplayed()
        && wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".vme-header img")).getAttribute("alt").contains("My Bank"));
  }

  public VerifiedMeMyBankLogin setUsername(final String username) {
    new WebDriverWait(webDriver, 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("#userid"))).sendKeys(username);

    return this;
  }

  public VerifiedMeMyBankLogin setPassword(final String password) {
    new WebDriverWait(webDriver, 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("#password"))).sendKeys(password);

    return this;
  }

  public VerifiedMeMyBankVerificationCode clickSignIn() {
    new WebDriverWait(webDriver, 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("#login"))).click();

    return new VerifiedMeMyBankVerificationCode(webDriver);
  }
}
