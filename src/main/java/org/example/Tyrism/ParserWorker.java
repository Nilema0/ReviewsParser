package org.example.Tyrism;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ParserWorker {
    final Parser parser;
    final String url;

    final public ArrayList<OnNewDataHandler> onNewDataList = new ArrayList<>();
    final public ArrayList<OnCompleted> onCompletedList = new ArrayList<>();

    public ParserWorker(Parser parser, String url) {
        this.parser = parser;
        this.url=url;
    }

    public void Start() {
        final WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get(url);

        final ArrayList<String> result = parser.parse(driver);
        driver.quit();

        for (final OnNewDataHandler newData :  onNewDataList) {
            newData.onNewData(this, result);
        }

        for (final OnCompleted completed : onCompletedList) {
            completed.onCompleted(this);
        }
    }
}
