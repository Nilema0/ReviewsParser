package org.example.Tyrism;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public interface Parser {
    ArrayList<String> parse(WebDriver document);
}
