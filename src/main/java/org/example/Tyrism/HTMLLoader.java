package org.example.Tyrism;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class HTMLLoader {
    String url;

    public HTMLLoader(ParserSettings settings){
        url=TyrismSettings.BASE_URL;
    }

    public WebDriver GetSourceByPageId()throws IOException{
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get(url);
        return driver;
    }
}
