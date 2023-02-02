package org.example.Tyrism;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TyrismParser implements Parser {
    @Override
    public ArrayList<String> parse(final WebDriver driver) {
        final ArrayList<String> list = new ArrayList<>();
        List<WebElement> reviewers = driver.findElements(By.cssSelector("div[class='find-list-box']"));

        for (int i = 0; i < reviewers.size(); i++) {
            reviewers = driver.findElements(By.cssSelector("div[class='find-list-box']"));
            reviewers.get(i)
                    .findElement(By.cssSelector("a[class='ss']"))
                    .click();

            final StringBuilder tourCompany = new StringBuilder();
            tourCompany.append(
                    driver.findElement(
                                    By.cssSelector("header[class='main-head']"))
                            .findElement(By.cssSelector("h1[class='ib']"))
                            .getText());
            tourCompany.append("\n");

            final List<WebElement> one = driver.findElement(
                            By.cssSelector("div[class='reviewers-block']"))
                    .findElements(By.cssSelector("div[class='reviewers-box']"));

            if (one.size() == 0) {
                tourCompany.append("Отзывов нет :(");
                continue;
            }

            for (final WebElement webElement : one) {
                int point = 5;
                tourCompany.append(webElement.findElement(
                                By.cssSelector("span[itemprop='author']"))
                        .getText());
                tourCompany.append(". Оценка: ");

                final List<WebElement> li = webElement.findElement(
                                By.cssSelector("header[class='head']"))
                        .findElements(By.cssSelector("li"));

                for (final WebElement element : li) {
                    if (element.findElement(
                                    By.cssSelector("span"))
                            .getAttribute("class")
                            .equals("star e")) {
                        point--;
                    }
                }
                tourCompany.append(point).append("\n");

                final List<WebElement> tr = webElement.findElement(
                                By.cssSelector("tbody"))
                        .findElements(By.cssSelector("tr"));

                for (int j = 0; j < tr.size(); j++) {
                    if (j == 0) {
                        tourCompany.append("Плюсы: ");
                        tourCompany.append(webElement.findElement(
                                        By.cssSelector("td[itemprop='pro']"))
                                .getText());
                        tourCompany.append("\n");
                        continue;
                    }
                    if (j == 1) {
                        tourCompany.append("Минусы: ");
                        tourCompany.append(webElement.findElement(
                                        By.cssSelector("td[itemprop='contra']"))
                                .getText());
                        tourCompany.append("\n");
                        continue;
                    }
                    if (j == 2) {
                        tourCompany.append("Отзыв: ");
                        tourCompany.append(webElement.findElement(
                                        By.cssSelector("td[itemprop='reviewBody']"))
                                .getText());
                        tourCompany.append("\n");
                    }
                }
                tourCompany.append("\n");
            }
            list.add(tourCompany.toString());
            driver.navigate().back();
        }
        return list;
    }
}
