package Test;

import Util.Resouces;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Google {

    final WebDriver driver;

    public Google(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(xpath = "//body/div/div[3]/form/div/div/div/div/div[2]/textarea")
    WebElement searchField;

    @FindBy(xpath = "//div[@id=\"search\"]/div/div/div/div/div/div/div/div/div/div/div/div/span/a")
    WebElement firstLink;


    public void search(String text){
        searchField.sendKeys(text);
        searchField.sendKeys(Keys.ENTER);
    }

    public void openWebsite(String resource) throws IOException {
        if (resource.equals("Google")) {
            Resouces website = Resouces.valueOf(resource);
            driver.get(website.getResource());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        }
    }

    public void openLinkInNewTab() {
        Actions actions = new Actions(driver);
        actions.contextClick(firstLink).build().perform();
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
    }
}
