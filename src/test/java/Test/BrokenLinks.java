package Test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks {

    public static void main(String[] args) throws IOException {

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        List<WebElement> aTag = driver.findElements(By.tagName("a"));
        List<String> links = new ArrayList<>();
        for(int i=0; i<aTag.size(); i++) {
            links.add(aTag.get(i).getAttribute("href"));
            System.out.println(aTag.get(i).getText());;

            URL url = new URL(aTag.get(i).getAttribute("href"));

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.connect();
            int response= conn.getResponseCode();
            System.out.println(response);
            Assert.assertEquals(response,200);

            conn.disconnect();
        }

        //links.forEach(System.out::println);
        driver.close();
        driver.quit();

    }
}
