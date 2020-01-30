package net.prodigylabs.test.page.component.dac.ui.r13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Prodigy main component
 */
public class ProdigyMain extends ProdigyPageComponent {

  private static final String SELECTOR = ".container-main";

  public ProdigyMain(final WebDriver webDriver) {
    super(webDriver);
  }

  public boolean isLoaded() {
    return new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).isDisplayed());
  }

  public VerifiedMeFinancialInstitution clickSignUpWithVerifiedMe() {
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("button[type='button']"))).click();

    return new VerifiedMeFinancialInstitution(getWebDriver());
  }
}
