package net.prodigylabs.test;

import net.prodigylabs.driver.provider.ChromeDriverHolder;
import net.prodigylabs.test.page.component.Login;
import net.prodigylabs.test.page.component.Metrics;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;

@RunWith(JUnit4.class)
public class ConsoleSmokeTest {

  private static final String URL = "https://dev.console.id.prodigylabs.net";

  private static final String USERNAME = "Test";
  private static final String PASSWORD = "Devteam1!";

  private WebDriver webDriver;

  @Before
  public void before() {
    webDriver = new ChromeDriverHolder().getWebDriver();
  }

  @Test
  public void loginAndLogout() {
    webDriver.get(URL);

    // Login is initial page
    Login login = new Login(webDriver);

    // Make sure that submit button is disabled
    Assertions.assertThat(login.isSubmitButtonEnabled()).isFalse();

    // Make sure user info is not displayed
    Assertions.assertThat(login.getNavBar().isUserInfoDisplayed()).isFalse();

    // Fill all fields
    login.setUsername(USERNAME).setPassword(PASSWORD).clickRememberMe();

    // Make sure that submit button is enabled
    Assertions.assertThat(login.isSubmitButtonEnabled()).isTrue();

    // After logging in user should be metrics page
    Metrics metrics = login.clickLogin();

    // Make sure notification about successful login is displayed
    Assertions.assertThat(metrics.getNotifier().isSuccessfulLoginNotificationDisplayed()).isTrue();

    // TODO We probably need to make sure that page which is loaded is metrics page, by checking its content

    // Make sure Metrics menu item is active in the side bar
    Assertions.assertThat(metrics.getSideBar().isMetricsMenuItemActive()).isTrue();

    // Make sure user info is displayed
    Assertions.assertThat(metrics.getNavBar().isUserInfoDisplayed()).isTrue();

    // Logout
    login = metrics.getNavBar().clickLogout();

    // Make sure notification about successful logout is displayed
    Assertions.assertThat(metrics.getNotifier().isSuccessfulLogoutNotificationDisplayed()).isTrue();

    // Make sure that submit button is disabled
    Assertions.assertThat(login.isSubmitButtonEnabled()).isFalse();
  }

  @After
  public void after() {
    webDriver.quit();
  }
}
