package Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class ValidateGeeks {

    WebDriver driver= new EdgeDriver();
    Google google = PageFactory.initElements(driver, Google.class);
    Geeks geeks = PageFactory.initElements(driver, Geeks.class);

    @Given("The user is {string}.")
    public void openURL(String resource) throws IOException {
       google.openWebsite(resource);
    }

    @When("User search for {string}.")
    public void userSearchFor(String text) {
        google.search(text);
    }

    @Then("Navigate to first link and validate.")
    public void navigateToFirstLinkAndValidate() {
        google.openLinkInNewTab();
        geeks.validateGeeks();
    }

}
