package net.prodigylabs.test.page.component.dac.ui.r13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Prodigy post verify cancel component
 */
public class ProdigyPostVerifyCancel extends ProdigyPageComponent {

  private static final String SELECTOR = ".container-post-verify .content-cancel";

  public ProdigyPostVerifyCancel(final WebDriver webDriver) {
    super(webDriver);
  }

  public boolean isLoaded() {
    return new WebDriverWait(getWebDriver(), 20).until(wd -> wd.findElement(By.cssSelector(SELECTOR))
        .findElement(By.cssSelector(".content-cancel-name")).getText().trim().contains("Transaction Cancelled"));
  }

  public ProdigyMain clickReturnHome() {
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector("button[type='button']"))).click();

    return new ProdigyMain(getWebDriver());
  }
}
