package org.ag.shopping.cart.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import org.ag.shopping.cart.requirements.StaticPages;
import org.ag.shopping.cart.steps.BuyingSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by kusum.maned on 15/12/2015.
 */

@RunWith(SerenityRunner.class)
@Story(StaticPages.Footer.ShoppingCart.class)
public class AddItemTest {

    @Managed
    private String headerText = "Items";

    @Managed
    WebDriver driver;

    @Steps
    public BuyingSteps buyerSteps;

    @Test
    public void checkAllTheElementsOnThePageLoadCorrectly(){
        //GIVEN
        buyerSteps.openPage();

        //WHEN
        buyerSteps.check_All_The_Elements_On_The_Page("Items", "Quantity", "Description");

    }

    @Test
    public void addItemsWithDescriptionTest(){
        //GIVEN
        buyerSteps.openPage();

        //WHEN
        buyerSteps.check_All_The_Elements_On_The_Page("Items", "Quantity", "Description");
        buyerSteps.select_no_items_from_the_dropdown(1);
        buyerSteps.type_in_the_description(String.valueOf(System.currentTimeMillis()).substring(0, 8) + "adding new Item to the cart");
        buyerSteps.click_add_to_cart();

        //THEN
        buyerSteps.check_that_the_item_has_been_to_the_cart();
    }

    @Test
    public void addItemsWithoutDescriptionTest(){
        //GIVEN
        buyerSteps.openPage();

        //WHEN
        buyerSteps.check_All_The_Elements_On_The_Page("Items", "Quantity", "Description");
        buyerSteps.select_no_items_from_the_dropdown(1);
        buyerSteps.type_in_the_description("");
        buyerSteps.click_add_to_cart();

        //THEN
        buyerSteps.check_that_the_item_has_been_to_the_cart();
    }

}
