package org.ag.shopping.cart.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.ag.shopping.cart.pages.BuyerSteps;

/**
 * Created by kusum.maned on 15/12/2015.
 */
public class BuyingSteps extends ScenarioSteps{

    org.ag.shopping.cart.pages.BuyerSteps basePage;


    @Step
    public void openPage(){

        basePage.open();

    }

    @Step
    public void verify_Header_Text(String text){
        basePage.verifyHeaderText(text);
    }




}
