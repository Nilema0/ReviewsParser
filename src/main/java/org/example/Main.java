package org.example;

import org.example.Tyrism.*;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ParserWorker<ArrayList<String>> parser = new ParserWorker<>(new TyrismParser());
        parser.setParserSettings("https://nanegative.ru/turoperatory");
        parser.onCompletedList.add(new Completed());
        parser.onNewDataList.add(new NewData());

        parser.Start();
        Thread.sleep(10000);
        parser.Abort();
    }
}