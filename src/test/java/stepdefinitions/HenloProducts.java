package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HenloProducts {
	@Given("I am on the homepage of supertails")
	public void i_am_on_the_homepage_of_supertails() {
	    System.out.println(".........");
	}

	@When("I click on the  link henlo")
	public void i_click_on_the_link_henlo() {
		System.out.println(".........");
	}

	@Then("I should be on the Henlo Products page")
	public void i_should_be_on_the_henlo_products_page() {
		System.out.println(".........");
	}

	@Then("The  displayed products should be the henlo products")
	public void the_displayed_products_should_be_the_henlo_products() {
		System.out.println(".........");
	}



}
