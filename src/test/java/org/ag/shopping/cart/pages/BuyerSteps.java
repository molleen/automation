package org.ag.shopping.cart.pages;

import junit.framework.Assert;
import com.google.common.base.Function;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static junit.framework.Assert.assertTrue;

/**
 * Created by kusum.maned on 15/12/2015.
 */


@DefaultUrl("http://localhost:4444/items")
public class BuyerSteps extends PageObject {

    @FindBy(css = "h3")
    private WebElement lblItems;

    @FindBy(css = "form div img")
    private WebElement imgProduct;

    @FindBy(css = "form div:nth-child(2)>label")
    private WebElement lblQuality;

    @FindBy(css = "form div:nth-child(3)>label")
    private WebElement lblDescription;

    @FindBy (css = "#description")
    private WebElement txtDescription;

    @FindBy(css = "button")
    private WebElement btnAddToCart;

    @FindBy(css = "quantity")
    private Select dropDownItems;

    @FindBy(css = "")
    private WebElement listItems;

    public void checkPageTitle(String title){
        assertTrue(getTitle().contains(title));
    }

    public void verifyHeaderText(String header){
        assertTrue(containsText(header));
    }


}
