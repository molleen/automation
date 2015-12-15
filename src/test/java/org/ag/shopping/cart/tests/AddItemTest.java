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
    public void addItemsTest(){
        //GIVEN

        buyerSteps.openPage();
        buyerSteps.verify_Header_Text(headerText);
    }
}
