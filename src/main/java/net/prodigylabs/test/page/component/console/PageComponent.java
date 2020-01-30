package net.prodigylabs.test.page.component.console;

import org.openqa.selenium.WebDriver;

/**
 * Basic page object, all page components should inherit it
 */
public abstract class PageComponent {

  private final WebDriver webDriver;

  private NavBar navBar;
  private SideBar sideBar;
  private Notifier notifier;

  public PageComponent(final WebDriver webDriver) {
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
  public NavBar getNavBar() {
    // Create it once, no need to create a lot of objects
    if (navBar == null) {
      navBar = new NavBar(webDriver);
    }
    return navBar;
  }

  /**
   * Side bar is a part of all pages, hence should be accessible to all page components
   *
   * @return {@link SideBar}
   */
  public SideBar getSideBar() {
    // Create it once, no need to create a lot of objects
    if (sideBar == null) {
      sideBar = new SideBar(webDriver);
    }
    return sideBar;
  }

  /**
   * Notifier is a part of all pages, hence should be accessible to all page components
   *
   * @return {@link Notifier}
   */
  public Notifier getNotifier() {
    // Create it once, no need to create a lot of objects
    if (notifier == null) {
      notifier = new Notifier(webDriver);
    }
    return notifier;
  }
}
