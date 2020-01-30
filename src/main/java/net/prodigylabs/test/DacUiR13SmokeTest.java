package net.prodigylabs.test;

import net.prodigylabs.driver.provider.ChromeDriverHolder;
import net.prodigylabs.test.page.component.dac.ui.r13.ProdigyMain;
import net.prodigylabs.test.page.component.dac.ui.r13.ProdigyPostVerifyCancel;
import net.prodigylabs.test.page.component.dac.ui.r13.ProdigyPostVerifySuccess;
import net.prodigylabs.test.page.component.dac.ui.r13.VerifiedMeFinancialInstitution;
import net.prodigylabs.test.page.component.dac.ui.r13.VerifiedMeLicense;
import net.prodigylabs.test.page.component.dac.ui.r13.VerifiedMeMyBankIdentityProfile;
import net.prodigylabs.test.page.component.dac.ui.r13.VerifiedMeMyBankLogin;
import net.prodigylabs.test.page.component.dac.ui.r13.VerifiedMeMyBankVerificationCode;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;

@RunWith(JUnit4.class)
public class DacUiR13SmokeTest {

  private static final String URL = "https://dev.id.prodigylabs.net";

  private static final String USERNAME = "arpitha.joshi@prodigylabs.net";
  private static final String PASSWORD = "password";

  private WebDriver webDriver;

  @Before
  public void before() {
    webDriver = new ChromeDriverHolder().getWebDriver();
  }

  @Test
  public void webFlowSuccess() {
    webDriver.get(URL);

    // Prodigy main is initial page
    ProdigyMain prodigyMain = new ProdigyMain(webDriver);

    // Make sure that initially we are on a prodigy main page
    Assertions.assertThat(prodigyMain.isLoaded()).isTrue();

    // Click sign up with Verified.Me
    VerifiedMeFinancialInstitution verifiedMeFinancialInstitution = prodigyMain.clickSignUpWithVerifiedMe();

    // Make sure that Verified.Me financial institution page is loaded
    Assertions.assertThat(verifiedMeFinancialInstitution.isLoaded()).isTrue();

    // Click My Bank
    VerifiedMeMyBankLogin verifiedMeMyBankLogin = verifiedMeFinancialInstitution.clickMyBank();

    // Make sure that My Bank login page is loaded
    Assertions.assertThat(verifiedMeMyBankLogin.isLoaded()).isTrue();

    // Fill all fields and click sign in
    VerifiedMeMyBankVerificationCode verifiedMeMyBankVerificationCode = verifiedMeMyBankLogin.setUsername(USERNAME).setPassword(PASSWORD).clickSignIn();

    // Make sure that My Bank verification code page is loaded
    Assertions.assertThat(verifiedMeMyBankVerificationCode.isLoaded()).isTrue();

    // Click OK
    VerifiedMeMyBankIdentityProfile verifiedMeMyBankIdentityProfile = verifiedMeMyBankVerificationCode.clickOk();

    // Make sure that My Bank identity profile page is loaded
    Assertions.assertThat(verifiedMeMyBankIdentityProfile.isLoaded()).isTrue();

    // Click OK
    VerifiedMeLicense verifiedMeLicense = verifiedMeMyBankIdentityProfile.clickOk();

    // Make sure that Verified.Me licence page is loaded
    Assertions.assertThat(verifiedMeLicense.isLoaded()).isTrue();

    // Click I Agree
    ProdigyPostVerifySuccess prodigyPostVerifySuccess = verifiedMeLicense.clickIAgree();

    // Make sure that Prodigy post verify success page is loaded
    Assertions.assertThat(prodigyPostVerifySuccess.isLoaded()).isTrue();

    // Verify fields returned by Verified.Me
    Assertions.assertThat(prodigyPostVerifySuccess.getFields())
        .containsEntry("Given Name", "Arpitha").containsEntry("Family Name", "Joshi")
        .containsEntry("Birthdate", "1990-02-18").containsEntry("Address", "4101 Yonge Suite 501, Toronto, ON, M2P 1N6")
        .containsEntry("Phone Number", "15197215552").containsEntry("Email", "arpitha.joshi@prodigylabs.net");
  }

  @Test
  public void webFlowCancel() {
    webDriver.get(URL);

    // Prodigy main is initial page
    ProdigyMain prodigyMain = new ProdigyMain(webDriver);

    // Make sure that initially we are on a prodigy main page
    Assertions.assertThat(prodigyMain.isLoaded()).isTrue();

    // Click sign up with Verified.Me
    VerifiedMeFinancialInstitution verifiedMeFinancialInstitution = prodigyMain.clickSignUpWithVerifiedMe();

    // Make sure that Verified.Me financial institution page is loaded
    Assertions.assertThat(verifiedMeFinancialInstitution.isLoaded()).isTrue();

    // Click Cancel
    ProdigyPostVerifyCancel prodigyPostVerifyCancel = verifiedMeFinancialInstitution.getNavBar().clickCancelAndYes();

    // Make sure that Prodigy post verify cancel page is loaded
    Assertions.assertThat(prodigyPostVerifyCancel.isLoaded()).isTrue();

    // Click return home
    prodigyMain = prodigyPostVerifyCancel.clickReturnHome();

    // Make sure that Prodigy main page is loaded
    Assertions.assertThat(prodigyMain.isLoaded()).isTrue();
  }

  @Test
  public void webFlowError() {
    // TODO
  }

  @After
  public void after() {
    webDriver.quit();
  }
}
