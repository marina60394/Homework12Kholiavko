package com.aqacources.tests.tests;

import com.aqacources.tests.base.BaseTest;
import com.aqacources.tests.pages.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Marina on 26.02.2019.
 */
public class AddToCartTest extends BaseTest {

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccoutPage myAccoutPage;
    private TShirtPage tShirtPage;
    private ProductPage productPage;
    private CheckoutPage checkoutPage;


    @Given("The user opens site sees Home Page")
    public void theUserOpensSiteSeesHomePage() {
        homePage = openSite();
    }

    @When("He clicks to Sign In link sees Login Page")
    public void heClicksToSignInLinkSeesLoginPage() {
        loginPage = homePage.clickSignInLink();
    }

    @When("He writes login '([^\\\"]*)' and password '([^\\\"]*)' data sees My Account Page")
    public void heWritesLoginDataSeesMyAccountPage(String login, String password) {
        myAccoutPage = loginPage.signIn(login, password);
    }

    @When("He clicks to T-Shirt category and sees T-Shirt Page")
    public void heClicksToTShirtPageAndSeesTShirtPage() {
        tShirtPage = myAccoutPage.clickMenuTShirt();
    }

    @When("He clicks to product '([^\\\"]*)' sees Product Page")
    public void heClicksToProductSeesProductPage(String productName) {

        productPage = tShirtPage.clickToProduct(productName);
    }

    @Then("Breadcrumb on Product Page is '([^\\\"]*)'")
    public void breadcrumbOnPeoductPageIs(String productBreadcrumb) {
        productPage.checkBreadrumb(productBreadcrumb);
    }


    @When("He clicks to button Add to Cart")
    public void heClicksToButtonAddToCart() {

        productPage.clickToButtonAddToCart();
    }

    @When("He clicks to Proceed to Checkout")
    public void heClickstoProceedCheckout() {
        checkoutPage = productPage.clickButtonProceedToCheckout();
    }


    @When("He clicks to increase quantity")
    public void heClicksToIncreaseQuantity() {
        checkoutPage.clickToIncreaseQuantity();
    }

    @Then("Total Price {float} is the result of multiply quantity and price {float} * {int}")
    public void totalPriceIsTheResultOfMultiplyQuantity(float totalPrice, float productPrice, int quantity) {
        checkoutPage.checkTotalPrice(totalPrice, productPrice, quantity);
    }

    @When("He deletes product")
    public void heDeletesProduct() {
        checkoutPage.clickDeleteProduct();
    }

    @Then("He sees cart is Empty")
    public void heSeesCasrIsEmpty() {
        checkoutPage.checkEmptyCart();
    }

    @Then("User closes browser")
    public void userClosesBrowser() {
        closeSite();
    }

}
