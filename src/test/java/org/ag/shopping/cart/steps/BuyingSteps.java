package org.ag.shopping.cart.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.ag.shopping.cart.pages.ShoppingPage;

/**
 * Created by kusum.maned on 15/12/2015.
 */
public class BuyingSteps extends ScenarioSteps{

    ShoppingPage basePage;


    @Step
    public void openPage(){

        basePage.open();

    }

    @Step
    public void verify_Header_Text(String text){

        basePage.verifyHeaderText(text);
    }

    @Step
    public void check_All_The_Elements_On_The_Page(String headerText, String quatityText, String desc){
        basePage.onShoppingPage()
                .verifyHeaderText(headerText)
                .verifyQuantityText(quatityText)
                .verifyDescriptionText(desc);
    }

    @Step
    public void select_no_items_from_the_dropdown(int noOfItems){
        basePage.selectNoOfItems(noOfItems);
    }


    @Step
    public void type_in_the_description(String desc){
        basePage.writeDescription(desc);
    }

    @Step
    public void click_add_to_cart(){
        basePage.clickAddToCart();
    }

    @Step
    public void check_that_the_item_has_been_to_the_cart(){
        basePage.verifyItemThatItemGetsAddedToTheList();
    }

}
