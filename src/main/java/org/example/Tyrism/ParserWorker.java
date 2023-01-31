package org.example.Tyrism;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.ArrayList;

public class ParserWorker<T> {
    Parser<T> parser;
    String url;
    boolean isActive;

    public ArrayList<OnNewDataHandler> onNewDataList = new ArrayList<>();
    public ArrayList<OnCompleted> onCompletedList = new ArrayList<>();

    public void setParserSettings(String parserSettings) {
        url = parserSettings;
    }

    public void Start()throws IOException{
        isActive=true;
        Worker();
    }

    public void Abort(){
        isActive=false;
    }

    public ParserWorker(Parser<T> parser) {
        this.parser = parser;
    }

    private void Worker()throws IOException{
            if(!isActive){
                onCompletedList.get(0).OnCompleted(this);
                return;
            }

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get(url);

            //WebDriver driver = loader.GetSourceByPageId();
            T result = parser.Parse(driver);
            driver.quit();
            onNewDataList.get(0).OnNewData(this,result);

        onCompletedList.get(0).OnCompleted(this);
        isActive = false;
    }
}
