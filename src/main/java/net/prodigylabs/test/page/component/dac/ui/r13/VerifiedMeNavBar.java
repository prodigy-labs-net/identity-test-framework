package net.prodigylabs.test.page.component.dac.ui.r13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Nav bar page component
 */
public class VerifiedMeNavBar extends VerifiedMePageComponent {

  private static final String SELECTOR = "header.c-header";
  private static final String CANCEL_MODAL = "#cancel-modal";

  public VerifiedMeNavBar(final WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  public VerifiedMeNavBar getNavBar() {
    return this;
  }

  public ProdigyPostVerifyCancel clickCancelAndYes() {
    // Cancel is a two step process, first we click on Cancel button itself and after click Yes in modal
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".c-header__actions #ui-border-button-cancel"))).click();
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(CANCEL_MODAL)).findElement(By.cssSelector(".c-modal__ctas .ui-main-button  "))).click();

    return new ProdigyPostVerifyCancel(getWebDriver());
  }
}
