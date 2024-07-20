package Util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Map;
import java.util.Properties;


public class Util {

    RequestSpecification res= null;
    public RequestSpecification buildRequest() throws IOException {
        if(res==null){
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

            res= new RequestSpecBuilder().setBaseUri(getValueOf("baseURI"))
                    .addQueryParam("Page","2")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON) .build();
        }

        return res;
    }

    public static String getValueOf(String key) throws IOException {

        String value= null;
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream("C:/Users/Sourabh/IdeaProjects/RestAPIProject/src/test/java/Util/gobal.properties");
        properties.load(fis);

        return properties.getProperty(key);
    }


}
