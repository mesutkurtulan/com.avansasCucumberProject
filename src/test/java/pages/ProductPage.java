package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class ProductPage {
    Select select;

    public ProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="sort")
    public WebElement sortSelector;

    @FindBy(id="select2-sort-container")
    public WebElement smartSortButton;

    @FindBy(xpath="//ul[@class='select2-results__options']//li[2]")
    public WebElement sortByNameA_ZButton;

    @FindBy(xpath="//ul[@class='select2-results__options']//li[3]")
    public WebElement sortByNameZ_AButton;

    public void sortByNameA_Z(){
        smartSortButton.click();
        ReusableMethods.waitForVisibility(sortByNameA_ZButton,10);
        sortByNameA_ZButton.click();
        ReusableMethods.waitFor(2);
    }

    public void sortByNameZ_A(){
        smartSortButton.click();
        ReusableMethods.waitForVisibility(sortByNameA_ZButton,10);
        sortByNameA_ZButton.click();
    }
    public int productQuantity=0;
    public int findProductQuantity(String productName){
        String text = "//h3[contains(text(),'"+productName+"')]";
        List<WebElement> productQuantityList = Driver.getDriver().findElements(By.xpath(text));
        int productQuantity = productQuantityList.size();
        return productQuantity;
    }
}
