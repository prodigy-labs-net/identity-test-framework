package net.prodigylabs.test.page.component.dac.ui.r13;

import net.prodigylabs.test.page.component.console.NavBar;
import org.openqa.selenium.WebDriver;

/**
 * Basic page object, all prodigy page components should inherit it
 */
public abstract class ProdigyPageComponent {

  private final WebDriver webDriver;

  private ProdigyNavBar navBar;

  public ProdigyPageComponent(final WebDriver webDriver) {
    this.webDriver = webDriver;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }

  /**
   * Nav bar is a part of all pages, hence should be accessible to all page components
   *
   * @return {@link NavBar}
   */
  public ProdigyNavBar getNavBar() {
    // Create it once, no need to create a lot of objects
    if (navBar == null) {
      navBar = new ProdigyNavBar(webDriver);
    }
    return navBar;
  }
}
