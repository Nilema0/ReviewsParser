package org.example;

import org.example.Tyrism.*;

public class Main {
    final static ParserWorker parser = new ParserWorker
            (new TyrismParser(),"https://nanegative.ru/turoperatory");
    static {
        parser.onCompletedList.add(new Completed());
        parser.onNewDataList.add(new NewData());
    }
    public static void main(String[] args) {
        parser.Start();
    }
}