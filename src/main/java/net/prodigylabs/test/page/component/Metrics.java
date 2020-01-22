package net.prodigylabs.test.page.component;

import org.openqa.selenium.WebDriver;

/**
 * Metrics page component
 */
public class Metrics extends PageComponent {

  // TODO It should be fixed eventually to container-metrics
  private static final String SELECTOR = ".container-content";

  public Metrics(final WebDriver webDriver) {
    super(webDriver);
  }
}
