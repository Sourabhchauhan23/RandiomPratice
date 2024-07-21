package Test;

import Util.Util;
import Util.Resouces;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.Data;
import org.example.Page;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;

public class InterviewPrep extends Util {

    Response response=null;
    RequestSpecification res=null;
    Response resp=null;

    WebDriver driver = new EdgeDriver();

    InterviewPrep interviewPrep = PageFactory.initElements(driver,InterviewPrep.class);


    @Given("The user is on {string}.")
    public void theUserIsOn(String resource) throws IOException {
        Resouces resourceAPI= Resouces.valueOf(resource);
        res =given().spec(buildRequest()).contentType("application/json");
        response = res.get(resourceAPI.getResource());
        res.get(resourceAPI.getResource()).then().assertThat()
                .body(matchesJsonSchemaInClasspath("src/test/java/Test/schemaValidation.json")
                        .using(settings().with().checkedValidation(false)));
        System.out.println("Given statment completed");
    }

    @Then("{string} should have {int} AvatarId with AvatarName, AvatarEmail details.")
    public void shouldHaveAvatarIdWithAvatarNameAvatarEmailDetails(String resource, int avatarCount) {
        String resp = response.getBody().asString();
    //    System.out.println(resp);
        JsonPath js = new JsonPath(resp);
        String page= js.getString("page");
    //    List<Data> dataa= response.getBody().
    //    dataa.stream().filter(x -> x.getId().equals("8")).forEach(x -> System.out.println(x.getFirst_name()+" "+x.getLast_name()));
        System.out.println(page);
        Assert.assertEquals("2",page);


    }

    @Given("The user is at {string}.")
    public void theUserIsAt(String resource) throws IOException {
        if(resource.equals("Google")){
            Resouces website= Resouces.valueOf(resource);
            driver.get(website.getResource());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        }else {
            Resouces resourceAPI= Resouces.valueOf(resource);
            res =given().spec(buildRequest()).contentType("application/json");
            Page page = res.get(resourceAPI.getResource()).then()
                    .extract().as(Page.class);
            assertThat(page.getTotal_pages(), equalTo("2"));
            System.out.println(page.getData().size());
            resp = res.get(resourceAPI.getResource());
            Data dd= page.getData().stream().filter(x -> x.getLast_name().equalsIgnoreCase("Howell"))
                    .findFirst().orElse(null);

        }
    }


}
