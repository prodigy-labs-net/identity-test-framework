package net.prodigylabs.test.page.component.dac.ui.r13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Financial institution page component
 */
public class VerifiedMeLicense extends VerifiedMePageComponent {

  private static final String SELECTOR = "main.l-wrapper";

  public VerifiedMeLicense(final WebDriver webDriver) {
    super(webDriver);
  }

  public boolean isLoaded() {
    return new WebDriverWait(getWebDriver(), 20)
        .until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("#wrapper-title")))
        .getText().trim().contains("Please review and verify the following requested by Prodigy Labs");
  }

  public ProdigyPostVerifySuccess clickIAgree() {
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR))
        .findElement(By.cssSelector("section.c-box .c-box-footer #license__button-agree"))).click();

    return new ProdigyPostVerifySuccess(getWebDriver());
  }
}
