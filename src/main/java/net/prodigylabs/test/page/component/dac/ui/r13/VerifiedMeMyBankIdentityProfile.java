package net.prodigylabs.test.page.component.dac.ui.r13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * My Bank identity profile page component
 */
public class VerifiedMeMyBankIdentityProfile {

  private final WebDriver webDriver;

  private static final String SELECTOR = ".vme-theme--my-bank";

  public VerifiedMeMyBankIdentityProfile(final WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public boolean isLoaded() {
    return new WebDriverWait(webDriver, 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".vme-form__footer__right #consent_ok")).isDisplayed()
        && wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".vme-header img")).getAttribute("alt").contains("My Bank"));
  }

  public VerifiedMeLicense clickOk() {
    new WebDriverWait(webDriver, 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".vme-form__footer__right #consent_ok"))).click();

    return new VerifiedMeLicense(webDriver);
  }
}
