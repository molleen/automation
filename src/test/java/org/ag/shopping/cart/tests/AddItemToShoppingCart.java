package org.ag.shopping.cart.tests;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features/add-item/add_item_to_shopping_cart.feature")
public class AddItemToShoppingCart {
}
