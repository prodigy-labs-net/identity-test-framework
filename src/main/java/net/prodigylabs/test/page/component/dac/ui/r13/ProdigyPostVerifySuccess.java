package net.prodigylabs.test.page.component.dac.ui.r13;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Prodigy post verify success component
 */
public class ProdigyPostVerifySuccess extends ProdigyPageComponent {

  private static final String SELECTOR = ".container-post-verify .content-assets";

  public ProdigyPostVerifySuccess(final WebDriver webDriver) {
    super(webDriver);
  }

  public boolean isLoaded() {
    return new WebDriverWait(getWebDriver(), 20).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).isDisplayed());
  }

  public Map<String, String> getFields() {
    new WebDriverWait(getWebDriver(), 1).until(wd -> wd.findElement(By.cssSelector(SELECTOR)).findElements(By.cssSelector(".content-assets-field")).size() > 0);

    return getWebDriver().findElement(By.cssSelector(SELECTOR)).findElements(By.cssSelector(".content-assets-field"))
        .stream().map(webElement -> Pair.of(webElement.findElement(By.cssSelector("label")).getText().trim(),
            webElement.findElement(By.cssSelector("input")).getAttribute("value").trim()))
        .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
  }
}
