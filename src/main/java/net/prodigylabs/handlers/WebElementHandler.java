package net.prodigylabs.handlers;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.prodigylabs.config.ObjectRepository;

/** @author arpitha **/
public class WebElementHandler {
	
	protected WebDriver driver = null;
	WebDriverWait driverWait = null;
	private boolean flag = false;
	int count = ObjectRepository.getInt("global.driver.interate");
	JavascriptExecutor jse = null;
	Actions action = null;

	
	public WebElementHandler(WebDriver webdriver)
	{
		driver=webdriver;
		jse = (JavascriptExecutor)driver;
		action = new Actions(driver);
	}
	
	public void setDriverWait(String locator) {
		driverWait = new WebDriverWait(driver, ObjectRepository.getLong("global.driver.wait"));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void setDriverWait(By locator) {
		driverWait = new WebDriverWait(driver, ObjectRepository.getLong("global.driver.wait"));
		driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void clickButton(String locator) {
		setDriverWait(locator);
		driver.findElement(By.xpath(locator)).click();
	}
	
	public void clickButton(By locator) {
		setDriverWait(locator);
		driver.findElement(locator).click();
	}
	
	public void enterText(String locator, String text) {
		setDriverWait(locator);
		driver.findElement(By.xpath(locator)).sendKeys(text);
	}
	
	public void enterText(By locator, String text) throws Exception {
		setDriverWait(locator);
		WebElement we = driver.findElement(locator);
		if (we!=null) {
			setDriverWait(locator);
			we.click();
			we.sendKeys(text);
		}		
	}
	
	public void enterTextUsingJavascript(By locator, String text) throws Exception {
		setDriverWait(locator);
		WebElement we = driver.findElement(locator);
		if (we!=null) {
			setDriverWait(locator);
			we.click();
			jse.executeScript("arguments[0].value='"+text+"';", we);
		}		
	}
	
	public String getText(By locator) {
		setDriverWait(locator);
		String text = driver.findElement(locator).getText();
		return text;
	}

	public String getText(String locator) {
		setDriverWait(locator);
		String text = driver.findElement(By.xpath(locator)).getText();
		return text;
	}
	
	public boolean verifyTextInList(String locator, String text) {
		try {
			setDriverWait(ObjectRepository.getString(locator));
			List<WebElement> webElements = driver.findElements(By.xpath(ObjectRepository.getString(locator)));
			for (WebElement webElement : webElements) {
				flag = webElement.getText().contains(text);
				if (flag == true) break;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
  
	public boolean isDisplayed(String locator) {
		setDriverWait(locator);
		return driver.findElement(By.xpath(locator)).isDisplayed();
	}
	
	public boolean isDisplayed(By locator) throws Exception {
		setDriverWait(locator);		
		WebElement we = driver.findElement(locator);
		if (we!=null) {
			for(int i=0; i<=count;i++){
				  try{
				     flag = we.isDisplayed();
				     break;
				  }
				  catch(Exception e){
					     throw new Exception("ELement is not displayed "+locator);
					  }
				  }
		}
		return flag;
	}
	
	public Select getDropDown(By locator) throws Exception {
		Select dropDown = null;
		setDriverWait(locator);
		dropDown = new Select(driver.findElement(locator));
		return dropDown;
	}
	
	public void selectByVisibleText(Select dropDown, String visibleText) throws Exception {
		if (dropDown != null) {
			dropDown.selectByVisibleText(visibleText);
		} else {
			throw new Exception("Unable to locate dropdown element");
		}
	}
	
	public void selectByValue(Select dropDown, String value) throws Exception {
		if (dropDown != null) {
			dropDown.selectByValue(value);
		} else {
			throw new Exception("Unable to locate dropdown element");
		}
	}
	
	public void selectByIndex(Select dropDown, int index) throws Exception {
		if (dropDown != null) {
			dropDown.selectByIndex(index);
		} else {
			throw new Exception("Unable to locate dropdown element");
		}
	}
	
	public void waitforinvisibilityofElement(By locator) throws Exception {
		driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitforinvisibilityofAllElements(By locator) throws Exception {
		driverWait.until(myCustomCondition());
		driverWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(locator)));
	}
	
	public static ExpectedCondition<Boolean> myCustomCondition() {
		    return new ExpectedCondition<Boolean>() {
		      @Override
		      public Boolean apply(WebDriver driver) {return (Boolean) ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");}};
	  }
	  
	public void clickElementByText(By locator, String text) throws Exception {
		setDriverWait(locator);
		List<WebElement> allelements = driver.findElements(locator);
		for (WebElement element : allelements) {
			if (element.getText()!=null && element.getText().contains(text)) {
				element.click();
				break;
			}
		}		
	}
	
	public void clickElementByText(String locator, String text) throws Exception {
		setDriverWait(locator);
		List<WebElement> allelements = driver.findElements(By.xpath(locator));
		for (WebElement element : allelements) {
			if (element.getText()!=null && element.getText().contains(text)) {
				//jse.executeScript("arguments[0].scrollIntoView(true);", element);
				Thread.sleep(1000);
				element.click();
				break;
			}
		}		
	}
	
	public void clickElementByTextUsingActions(String locator, String text) throws Exception {
		setDriverWait(locator);
		List<WebElement> allelements = driver.findElements(By.xpath(locator));
		for (WebElement element : allelements) {
			if (element.getText()!=null && element.getText().contains(text)) {
				Thread.sleep(1000);
				action.click().build().perform();
				break;
			}
		}		
	}
	
	public boolean verifyElementNotPresent(String locator) throws Exception {
		try {
			flag = driver.findElements(By.xpath(ObjectRepository.getString(locator))).size()>0;
		} catch (Exception e) {
		     throw new Exception("verifyElementNotPresent "+flag);
		}
		return flag;
	}
}
