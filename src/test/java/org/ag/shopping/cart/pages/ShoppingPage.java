package org.ag.shopping.cart.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Created by kusum.maned on 15/12/2015.
 */


@DefaultUrl("http://localhost:4444/items")
public class ShoppingPage extends PageObject {

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

    @FindBy(css = "#quantity")
    private Select dropDownItems;

    @FindBy(css = "")
    private WebElement listItems;

    @FindBy(css = " div.media")
    private WebElement cart;

    @FindBy(css = "div li a")
    private WebElement linkMore;

    private List<WebElementFacade> currentItemsInCart = new ArrayList<>();
    Integer cartSize = 0;
    private String description = "";
    private String itemNumber = "";

    public ShoppingPage onShoppingPage(){
        return this;
    }


    public ShoppingPage checkPageTitle(String title){
        assertTrue(getTitle().contains(title));
        return this;
    }

    public ShoppingPage verifyHeaderText(String header){
        assertTrue(lblItems.getText().equals(header));
        return this;
    }

    public ShoppingPage verifyQuantityText(String quantityTxt){
        assertTrue($(lblQuality).containsText(quantityTxt));
        return this;
    }

    public ShoppingPage verifyDescriptionText(String desc){
        assertTrue($(lblDescription).containsText(desc));
        return this;
    }

    public void selectNoOfItems(Integer noOfItems){
        this.itemNumber = String.valueOf(noOfItems);
        Select dropDown = new Select(findBy("#quantity"));
        dropDown.selectByVisibleText(itemNumber);

    }

    public void writeDescription(String description){
        this.description = description;
        $(txtDescription).sendKeys(description);
    }


    public void clickAddToCart(){
        currentItemsInCart = findAll(By.cssSelector("div.media"));

        if(cartSize == 15){
            clickOn(linkMore);
        }
        clickOn(btnAddToCart);
        cartSize = currentItemsInCart.size();
    }

    public void verifyItemThatItemGetsAddedToTheList(){
        currentItemsInCart = findAll(By.cssSelector("div.media"));
        Integer currentSizeOftheCart = currentItemsInCart.size();
        if(currentSizeOftheCart == 15){
            clickOn(linkMore);
        }

        currentItemsInCart = findAll(By.cssSelector("div.media"));
        currentSizeOftheCart = currentItemsInCart.size();



        String s = currentItemsInCart.get(currentSizeOftheCart - 1).getText();
        String e = description + " Quantity:" + itemNumber;

        System.out.println(s);
        System.out.println(e);

//        assertTrue(currentSizeOftheCart > cartSize);
        assertTrue("Not Equal! ", s.contains(description));

    }


}
