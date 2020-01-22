package net.prodigylabs.driver.provider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URL;
import java.util.Optional;

public class ChromeDriverProvider implements WebDriverProvider {

  private final WebDriver webDriver;

  public ChromeDriverProvider() {
    final URL url = Optional.ofNullable(this.getClass().getClassLoader().getResource("driver/mac/chromedriver"))
        .orElseThrow(() -> new IllegalArgumentException("Could not find chromedriver executable for Mac OS X"));

    // TODO Need this hack if we want to have chromedriver as a part of the repository
    new File(url.getPath()).setExecutable(true);

    System.setProperty("webdriver.chrome.driver", url.getPath());

    this.webDriver = new ChromeDriver();
  }

  @Override
  public WebDriver provide() {
    return webDriver;
  }
}
