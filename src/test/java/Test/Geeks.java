package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Geeks {

    final WebDriver driver;

    public Geeks(WebDriver driver){
        this.driver=driver;
    }

    @FindBy(xpath = "//img[@alt=\"geeksforgeeks\"]")
    WebElement geeks;

    public void validateGeeks(){
        geeks.isDisplayed();
    }
}
