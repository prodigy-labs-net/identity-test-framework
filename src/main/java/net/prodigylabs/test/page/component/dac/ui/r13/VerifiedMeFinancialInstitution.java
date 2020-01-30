package net.prodigylabs.test.page.component.dac.ui.r13;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Financial institution page component
 */
public class VerifiedMeFinancialInstitution extends VerifiedMePageComponent {

  private static final String SELECTOR = "section.c-box";

  public VerifiedMeFinancialInstitution(final WebDriver webDriver) {
    super(webDriver);
  }

  public boolean isLoaded() {
    return new WebDriverWait(getWebDriver(), 10)
        .until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".c-fi-selector h1")))
        .getText().trim().contains("Sign in with your current Financial Institution");
  }

  public VerifiedMeMyBankLogin clickMyBank() {
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR))
        .findElements(By.cssSelector(".c-fi-selector .c-fi-selector__grid .c-fi-selector-item"))
        .stream().filter(webElement -> webElement.getText().contains("My Bank")).findFirst()
        .orElseThrow(NotFoundException::new)).click();

    return new VerifiedMeMyBankLogin(getWebDriver());
  }
}
