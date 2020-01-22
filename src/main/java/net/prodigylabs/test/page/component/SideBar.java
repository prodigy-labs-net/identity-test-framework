package net.prodigylabs.test.page.component;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Navigation bar page component
 */
public class SideBar extends PageComponent {

  private static final String SELECTOR = ".container-side-bar";

  public SideBar(final WebDriver webDriver) {
    super(webDriver);
  }

  @Override
  public SideBar getSideBar() {
    return this;
  }

  public boolean isMetricsMenuItemActive() {
    return new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElement(By.cssSelector(".nav-item.is-active")))
        .getText().trim().equals("Metrics");
  }
}
