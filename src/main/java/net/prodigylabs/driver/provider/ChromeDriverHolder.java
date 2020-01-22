package net.prodigylabs.driver.provider;

import com.google.common.collect.ImmutableMap;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.Optional;

/**
 * TODO Implement more drivers
 */
public class ChromeDriverHolder {

  // TODO Add other operation systems
  private final Map<String, WebDriverProvider> providers = ImmutableMap.of(
      "Mac OS X", new ChromeDriverProvider()
  );

  private final WebDriver webDriver;
  private final JavascriptExecutor javaScriptExecutor;

  public ChromeDriverHolder() {
    final String os = System.getProperty("os.name");

    this.webDriver = Optional.ofNullable(providers.get(os))
        .orElseThrow(() -> new IllegalArgumentException("Not implemented os " + os)).provide();

    this.javaScriptExecutor = (JavascriptExecutor) webDriver;
  }

  public WebDriver getWebDriver() {
    return webDriver;
  }

  public JavascriptExecutor getJavascriptExecutor() {
    return javaScriptExecutor;
  }
}
