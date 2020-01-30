package net.prodigylabs.test.page.component.dac.ui.r13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * My Bank verification code page component
 */
public class VerifiedMeMyBankVerificationCode {

  private final WebDriver webDriver;

  private static final String SELECTOR = ".vme-theme--my-bank";

  public VerifiedMeMyBankVerificationCode(final WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public boolean isLoaded() {
    return new WebDriverWait(webDriver, 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".vme-form__footer__right .vme-button")).isDisplayed()
        && wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".vme-header img")).getAttribute("alt").contains("My Bank"));
  }

  public VerifiedMeMyBankIdentityProfile clickOk() {
    new WebDriverWait(webDriver, 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".vme-form__footer__right button"))).click();

    return new VerifiedMeMyBankIdentityProfile(webDriver);
  }
}
