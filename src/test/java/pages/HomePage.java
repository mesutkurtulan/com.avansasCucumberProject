package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;
import utilities.ReusableMethods;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);

    @FindBy(name="q")
    public WebElement searchBox;

    @FindBy(xpath="//button[text()='ARA']")
    public WebElement searchButton;



    public void searchWithText(String string) {
        ReusableMethods.waitForVisibility(searchBox,15);
        searchBox.sendKeys(string);
        ReusableMethods.waitFor(1);
        searchButton.click();
        ReusableMethods.waitFor(2);
    }

    public void selectACategoryName(String categoryName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String categoryElement = "//div[@class='category-card']//h3[text()='"+categoryName+"']";
        WebElement UrunAltKategoriElementi = Driver.getDriver().findElement(By.xpath(categoryElement));
        //js.executeScript("scrollBy(0,-100);");
        ReusableMethods.hover(UrunAltKategoriElementi);
        ReusableMethods.waitFor(1);
        UrunAltKategoriElementi.click();
        ReusableMethods.waitFor(2);
    }

    public String getCategoryNameText(String categoryName) {
        String categoryElement = "//h2/a[text()='"+categoryName+"']";
        return Driver.getDriver().findElement(By.xpath(categoryElement)).getText();
    }

    public void hoverOverText(String ElementName) {
        String textLocator = "//h3[text()='"+ElementName+"']";
        WebElement textElement = Driver.getDriver().findElement(By.xpath("textLocator"));
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(textElement).perform();
    }
}
