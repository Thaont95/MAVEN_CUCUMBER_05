package commons;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.AbstractPageUi;
import interfaces.HomePageUi;
import pageObjects.DeleteAccountPageObject;
import pageObjects.EditCustomePageObject;
import pageObjects.HomePageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.WithdrawPageObject;

public class AbstractPage {

	public void openAnyURL(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void foward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String idTextboxValue, String value) {
		locator = String.format(locator, idTextboxValue);
		WebElement element = driver.findElement(By.xpath(locator));		
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String item) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String idDropdown, String item) {
		locator = String.format(locator, idDropdown);
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}
	
	public void selectDropdown(WebDriver driver, String dropdown, String listitems, String value) throws Exception {
		// Click vào dropdown
		WebElement dropdownlist = driver.findElement(By.xpath(dropdown));
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownlist);
		dropdownlist.click();
		Thread.sleep(3000);

		// Get tất cả item trong dropdown vào 1 list element (List <WebElement>)
		List<WebElement> allitems = driver.findElements(By.xpath(listitems));

		// Wait để tất cả phần tử trong dropdown được hiển thị
		wait.until(ExpectedConditions.visibilityOfAllElements(allitems));

		// Dùng vòng lặp for duyệt qua từng phần tử sau đó getText
		for (WebElement item : allitems) {
			if (item.getText().trim().equals(value)) {
				// scroll
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);

				item.click();
				break;
			}

		}
	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}
	
	public String getTextElement(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(locator));		
		return element.getText();
	}

	public int getSizeElement(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}

	}

	public void unCheckToCheckbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplay(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlDisplay(WebDriver driver, String locator, String... values) {

		locator = String.format(locator, (Object[]) values);
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}
	
	

	public boolean isControlUndisplayed(WebDriver driver, String locator) {
		Date date = new Date();
		System.out.println("Started time = " + date.toString());
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return true;
		} else {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return false;
		}
	}

	public boolean isControlUndisplayed(WebDriver driver, String locator, String... value) {
		Date date = new Date();
		System.out.println("Started time = " + date.toString());
		overrideGlobalTimeout(driver, shortTimeout);
		locator = String.format(locator, (Object[]) value);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.size() == 0) {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return true;
		} else {
			date = new Date();
			System.out.println("End time = " + date.toString());
			overrideGlobalTimeout(driver, longTimeout);
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public boolean isControlEnable(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public void acceptToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void RightClickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void DragAndDrop(WebDriver driver, String locator1, String locator2) {
		WebElement source = driver.findElement(By.xpath(locator1));
		WebElement target = driver.findElement(By.xpath(locator2));
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}

	public void keyPress(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).build().perform();
		elements.get(0).click();
		elements.get(2).click();
		elements.get(4).click();
		elements.get(6).click();
		action.keyUp(Keys.CONTROL).build().perform();
	}

	public void pressKeyForElement(WebDriver driver, String locator, Keys keyname) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.sendKeys(element, keyname);
	}

	public void uploadFile(WebDriver driver, String fileName) {
		String ProjectDirectory = System.getProperty("user.dir");
		String uploadFilePath = ProjectDirectory + "\\fileUploads\\" + fileName;
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys(uploadFilePath);
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}

	public void waitForControlVisible(WebDriver driver, String locator, String...values) {
		locator = String.format(locator, (Object[]) values);
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}

	
	public void waitForControlInvisible(WebDriver driver, String locator) {
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
	}

	public void waitForControlPresence(WebDriver driver, String locator) {
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byElement));
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void waitForClickAbel(WebDriver driver, String locator) {
		By byElement = By.xpath(locator);
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		wait.until(ExpectedConditions.elementToBeClickable(byElement));
	}

	public Object executeForBrowserElement(WebDriver driver, String javascript) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript(javascript);
	}

	public Object highlightElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("arguments[0].style.border='6px groove red'", element);
	}

	public Object clickElementByJavascript(WebDriver driver, WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		return je.executeScript("arguments[0].click();", element);
	}

	public void removeAttributeInDOM(WebDriver driver, WebElement element, String attribute) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
	}

	public Object scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	public void switchToWindowById(WebDriver driver, String parent) {
		// Get all Windows ID
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			// Kiem tra ID nao != parent thi switch qua
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToChildWindowbytitle(WebDriver driver, String title) {
		// Get all Windows ID
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			driver.switchTo().window(runWindow);

			// Get title cua page day ra
			String currentWin = driver.getTitle();

			// Title cua current windows = title truyen vao
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWithoutParentWindows(WebDriver driver, String parentWindow) {

		// Get all windows ID
		Set<String> allWindows = driver.getWindowHandles();

		// Duyet qua tung ID
		for (String runWindows : allWindows) {

			// Kiem tra neu windowsID != parent ID
			if (!runWindows.equals(parentWindow)) {

				// Switch qua windowsID
				driver.switchTo().window(runWindows);
				// Close
				driver.close();
			}
		}
		// Switch ve parentID
		driver.switchTo().window(parentWindow);

		// Kiem tra con duy nhat 1 ID cua parent
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToIframe(WebDriver driver, String iframeLocator) {
		WebElement iframe = driver.findElement(By.xpath(iframeLocator));
		driver.switchTo().frame(iframe);
	}

	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	public HomePageObject openHomePage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, "Manage");
		clickToElement(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, "Manage");
		return PageFactoryManager.openHomePage(driver);

	}

	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, "New Customer");
		clickToElement(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, "New Customer");
		return PageFactoryManager.openNewCustomerPage(driver);

	}

	public EditCustomePageObject openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, "Manage");
		clickToElement(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, "Manage");
		return PageFactoryManager.openEditCustomerPage(driver);

	}

	public WithdrawPageObject openWithdrawPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, "Withdraw");
		clickToElement(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, "Withdraw");
		return PageFactoryManager.openWithdrawPage(driver);

	}

	public DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, "Delete Account");
		clickToElement(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, "Delete Account");
		return PageFactoryManager.openDeleteAccountPage(driver);

	}
	
	public AbstractPage openDynamicPage(WebDriver driver, String pageName) {
		waitForControlVisible(driver,AbstractPageUi.DYNAMIC_PAGE_LINK, pageName);
		clickToElement(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, pageName);
		
		switch (pageName) {
			case "New Customer":
				return PageFactoryManager.openNewCustomerPage(driver);
				
			case "Edit Customer":
				return PageFactoryManager.openEditCustomerPage(driver);
				
			case "New Account":
				return PageFactoryManager.openAddAccountPage(driver);
				
			case "Deposit":
				return PageFactoryManager.openDepositPage(driver);
			case "Withdrawal":
				return PageFactoryManager.openWithdrawPage(driver);
				
			case "Fund Transfer":
				return PageFactoryManager.openFundTransferPage(driver);
				
			case "Balance Enquiry":
				return PageFactoryManager.openBalanceEnquiryPage(driver);
				
			case "Delete Account":
				return PageFactoryManager.openDeleteAccountPage(driver);
			case "Delete Customer":
				return PageFactoryManager.openDeleteCustomerPage(driver);
			default:
				return PageFactoryManager.openHomePage(driver);
		}
	}
	
	public void clickToDynamicPageLink(WebDriver driver, String text) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, text);
		clickToElement(driver, AbstractPageUi.DYNAMIC_PAGE_LINK, text);
		//return null;
	}
	
	
	public AbstractPage clickToDynamicButton(WebDriver driver, String titleName) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_BUTTON, titleName);
		clickToElement(driver, AbstractPageUi.DYNAMIC_BUTTON, titleName);
		return null;
	}
	
	
	public void sendKeyToDynamicTextarea(WebDriver driver, String textboxName, String value) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_TEXTAREA, textboxName);
		sendKeyToElement(driver, AbstractPageUi.DYNAMIC_TEXTAREA, value, textboxName);
	}
	
	public void selectItemInDynamicDropdown(WebDriver driver, String dropdownName, String valueName) {
		waitForControlVisible(driver, AbstractPageUi.DYNAMIC_DROPDOWN, dropdownName);
		Select select = new Select(driver.findElement(By.xpath(AbstractPageUi.DYNAMIC_DROPDOWN)));
		select.selectByVisibleText(valueName);
	}

	
	public AbstractPage acceptToAlertDynamic(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return null;
	}

	
	public int randomNumber() {
		Random rand = new Random();
		int number = rand.nextInt(99999) + 1;
		return number;
	}

	private int longTimeout = 30;
	private long shortTimeout = 10;

}
